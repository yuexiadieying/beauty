package com.meixiang.beauty.webapp.education.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.ObjectUtils;
import com.meixiang.beauty.webapp.education.dao.StudentDao;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.util.ClassCircleMessage;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StudentService {

    @Autowired
    public StudentDao studentDao;

    public Map studentCourseTableList(StudentDTO studentDTO,Integer weekIndex){
        Map returnMap = new HashMap();
        List<StudentCourseTableDTO> studentCourseDTOList = new LinkedList<>();
        SchoolDTO schoolDTO = studentDao.getSchoolInfo(studentDTO.getClassId());
        Date startSchoolDate = schoolDTO.getStartSchoolDate();

        weekIndex = EducationUtil.getCurrentWeekIndex(startSchoolDate,weekIndex);

        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(startSchoolDate);
        int week = c.get(Calendar.DAY_OF_WEEK)-1;
        int addcount = 7*weekIndex-week-7;
        c.add(Calendar.DATE,addcount);

        for(int i=1;i<8;i++){
            c.add(Calendar.DATE,1);
            week = c.get(Calendar.DAY_OF_WEEK)-1;
            System.out.println("今天是:" + f.format(c.getTime())+"周"+week);
            List<CourseInfoDTO> courseTableList = studentDao.getStudentCourseTableList(studentDTO.getClassId(),week);
            List<CourseInfoDTO> courseInfoDTOList = new ArrayList<>();
            for(CourseInfoDTO temp : courseTableList){
                String[] places = temp.getCoursePlace().split(",");
                for(int j=0;j<places.length;j++)
                {
                    CourseInfoDTO courseInfoDTO1 = new CourseInfoDTO();
                    courseInfoDTO1.setClassName(temp.getClassName());
                    courseInfoDTO1.setClassId(temp.getClassId());
                    courseInfoDTO1.setCourseId(temp.getCourseId());
                    courseInfoDTO1.setClassCourseId(temp.getClassCourseId());
                    courseInfoDTO1.setCourseName(temp.getCourseName());
                    courseInfoDTO1.setCoursePlace(places[j]);


                    List<HashMap<String,Object>> hashMapList = new ArrayList<>();

                    //判断这个课程，老师是不是布置了任务
                    CourseHomeWorkStudentDTO courseHomeWorkStudentDTO = new CourseHomeWorkStudentDTO();
                    courseHomeWorkStudentDTO.setStudentId(studentDTO.getStudentId());
                    courseHomeWorkStudentDTO.setClassCourseId(temp.getClassCourseId());
                    courseHomeWorkStudentDTO.setHomeWorkTime(new Date());

                    MissionBaseInfoDTO missionBaseInfoDTO = studentDao.getStudentCourseMissionDetail(courseHomeWorkStudentDTO);
                    HashMap<String,Object> yellowMapValue = new HashMap<>();
                    if(missionBaseInfoDTO!=null)
                    {
                        yellowMapValue.put("yellowFlag",true);
                    }
                    else
                    {
                        yellowMapValue.put("yellowFlag",false);
                    }
                    hashMapList.add(yellowMapValue);

                    //获取学生在此课程中的老师点评
                    HashMap<String,Object> redMapValue = new HashMap<>();
                    HashMap<String,Object> greenMapValue = new HashMap<>();
                    StudentCourseCommentDTO studentCourseCommentDTO = studentDao.getStudentCourseCommentByClassCourseId(temp.getCourseId(),studentDTO.getStudentId());
                    if(studentCourseCommentDTO!=null)
                    {
                        if(studentCourseCommentDTO.getCourseCommentStatus().equals("0")||studentCourseCommentDTO.getCourseCommentStatus().equals("2"))
                        {
                            redMapValue.put("redFlag",false);
                            greenMapValue.put("greenFlag",true);
                        }
                        else
                        {
                            redMapValue.put("redFlag",true);
                            greenMapValue.put("greenFlag",false);
                        }

                    }else{
                        redMapValue.put("redFlag",false);
                        greenMapValue.put("greenFlag",false);
                    }
                    hashMapList.add(redMapValue);
                    hashMapList.add(greenMapValue);

                    courseInfoDTO1.setCourseStatus(hashMapList);
                    courseInfoDTOList.add(courseInfoDTO1);
                }


            }

            StudentCourseTableDTO studentCourseTableDTO = new StudentCourseTableDTO();
            studentCourseTableDTO.setWeekIndex(weekIndex);
            studentCourseTableDTO.setWeekName(String.valueOf(week));
            studentCourseTableDTO.setWeekDate(DateUtils.DateToStr(c.getTime(),"date"));
            studentCourseTableDTO.setCourseList(courseInfoDTOList);
            studentCourseDTOList.add(studentCourseTableDTO);
        }
        HashMap<String,Object> hashMap = new HashMap<String,Object>();

        //获得当前时间的月份，月份从0开始所以结果要加1
        int month = c.get(Calendar.MONTH);

        hashMap.put("weekIndex",weekIndex);

        hashMap.put("month",month);

        hashMap.put("className",studentDTO.getClassName());

        String startMonth = DateUtils.formatDate(startSchoolDate, "MM");

        if(Integer.parseInt(startMonth)>7)
        {
            hashMap.put("semester","第一学期");
        }
        else if(Integer.parseInt(startMonth)<7)
        {
            hashMap.put("semester","第二学期");
        }
        returnMap.put("semester",hashMap);
        returnMap.put("studentCourseDTOList",studentCourseDTOList);
        return returnMap;
    }

    public List<StudentVacationApplyDTO> getStudentVacationApplyList(String studyNo){
        return studentDao.getStudentVacationApplyList(studyNo);
    }

    public StudentVacationApplyDTO getStudentApplyVacationDetail(String vacationId){
        return studentDao.getStudentApplyVacationDetail(vacationId);
    }

    public void saveStudentApplyVacation(StudentVacationApplyDTO studentVacationApplyDTO){
        studentDao.saveStudentApplyVacation(studentVacationApplyDTO);
    }

    public void saveStudentMission(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO){
        if(new Date().getTime()>courseHomeWorkStudentDTO.getHomeWorkTime().getTime()){
            courseHomeWorkStudentDTO.setCommitStatus("0");
        }else{
            courseHomeWorkStudentDTO.setCommitStatus("1");
        }
        studentDao.updateStudentHomeworkRel(courseHomeWorkStudentDTO);
    }

    public ShortMessageDTO getStudentShortMessage(String studentId){
        return studentDao.getStudentShortMessage(studentId);
    }

    public List<StudentMoralityDTO> getStudentMoralityList(String studentId){
        return studentDao.getStudentMoralityList(studentId);
    }

    /*public List<CourseHomeWorkStudentDTO> getStudentCourseMissionByDate(StudentDTO studentDTO,Date courseDate)
    {
        CourseHomeWorkStudentDTO courseHomeWorkStudentDTO = new CourseHomeWorkStudentDTO();
        courseHomeWorkStudentDTO.setStudentId(studentDTO.getStudentId());
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = studentDao.getStudentCourseHomeWork(courseHomeWorkStudentDTO);
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOS = new ArrayList<>();
        if(courseHomeWorkStudentDTOList.size()>0)
        {
            for(CourseHomeWorkStudentDTO courseHomeWorkStudent:courseHomeWorkStudentDTOList)
            {

                courseHomeWorkStudent.setClassTime(courseDate);
                String time = DateUtils.DateToStr(courseDate,"time");
                if(Integer.parseInt(time.split(":")[0])>=18){
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE,1);
                    courseHomeWorkStudent.setClassTime(calendar.getTime());
                }
                //如果系统传入的日期，小于homeWorkTime，则加入到队列中
                int flag = DateUtils.compare_date(DateUtils.DateToStr(courseHomeWorkStudent.getHomeWorkTime(),"date"),DateUtils.DateToStr(courseHomeWorkStudent.getClassTime(),"date"));
                if(flag>0)
                {
                    courseHomeWorkStudentDTOS.add(courseHomeWorkStudent);
                }
            }
        }
        return courseHomeWorkStudentDTOS;
    }*/

    public List<CourseHomeWorkStudentDTO> getStudentCourseMissionByDate(StudentDTO studentDTO,Date courseDate)
    {
        CourseHomeWorkStudentDTO courseHomeWorkStudentDTO = new CourseHomeWorkStudentDTO();
        courseHomeWorkStudentDTO.setClassId(studentDTO.getClassId());
        Calendar c = Calendar.getInstance();
        c.setTime(courseDate);
        int week = c.get(Calendar.DAY_OF_WEEK)-1;
        courseHomeWorkStudentDTO.setWeek(week+"");
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = studentDao.getStudentCourseHomeWork(courseHomeWorkStudentDTO);
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOs = new ArrayList<>();
        for(CourseHomeWorkStudentDTO temp:courseHomeWorkStudentDTOList){
            String coursePlace = temp.getCoursePlace();
            for(String place:coursePlace.split(",")){
                CourseHomeWorkStudentDTO dto = new CourseHomeWorkStudentDTO();
                BeanUtils.copyProperties(temp,dto);
                dto.setCoursePlace(place);
                dto.setClassTime(courseDate);
                List<CourseHomeWorkStudentDTO> hl = studentDao.getHomeWorkInfo(dto);
                if(hl!=null && hl.size()>0){
                    dto.setHomeWorkFlag("1");
                }else{
                    dto.setHomeWorkFlag("0");
                }
                courseHomeWorkStudentDTOs.add(dto);
            }
        }

        return courseHomeWorkStudentDTOs;
    }

    public List<StudentCourseCommentDTO> getCourseMissionComment(StudentCourseCommentDTO studentCourseCommentDTO){
        List<StudentCourseCommentDTO> list = studentDao.getCourseMissionComment(studentCourseCommentDTO);
        return list;
    }

    public MissionBaseInfoDTO getStudentCourseMissionDetail(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO){
        SchoolDTO schoolDTO = studentDao.getSchoolInfo(courseHomeWorkStudentDTO.getClassId());
        Date startSchoolDate = schoolDTO.getStartSchoolDate();
        int weekIndex=1;
        try {
            int days = (int) ((courseHomeWorkStudentDTO.getHomeWorkTime().getTime() - startSchoolDate.getTime()) / (1000*3600*24));
            Calendar c = Calendar.getInstance();
            int week = 1;
            c.setTime(startSchoolDate);
            for(int i=0;i<days;i++){
                c.add(Calendar.DATE,1);
                week = c.get(Calendar.DAY_OF_WEEK)-1;
                if(c.getTime().getTime()>=new Date().getTime()){
                    break;
                }
                if(week==1){
                    weekIndex++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MissionBaseInfoDTO classCourseInfo = studentDao.getClassCourseInfo(courseHomeWorkStudentDTO);
        MissionBaseInfoDTO missionBaseInfoDTO = studentDao.getStudentCourseMissionDetail(courseHomeWorkStudentDTO);
        if(missionBaseInfoDTO!=null){
            classCourseInfo.setMissionDescription(missionBaseInfoDTO.getMissionDescription());
            classCourseInfo.setMissionId(missionBaseInfoDTO.getMissionId());
            classCourseInfo.setMissionName(missionBaseInfoDTO.getMissionName());
            classCourseInfo.setMissionEndDate(missionBaseInfoDTO.getMissionEndDate());
            classCourseInfo.setClassCourseId(missionBaseInfoDTO.getClassCourseId());
            classCourseInfo.setCreateDate(missionBaseInfoDTO.getCreateDate());
            classCourseInfo.setTeacherId(missionBaseInfoDTO.getTeacherId());
            missionBaseInfoDTO.setWeekIndex(weekIndex+"");
        }
        return classCourseInfo;
    }

    public CourseClassInfoDTO getStudentCourseClassInfo(String classId,String courseId){
        return studentDao.getStudentCourseBaseInfo(classId,courseId);
    }

    public List<StudentDTO> getStudentInfo(StudentDTO studentDTO) {
        return studentDao.getStudentInfo(studentDTO);
    }

    public List<ClassCircleMessageDTO> GetStudentClassCircle(PageParamDTO<String> pageParamDTO, String studentId) {

        List<ClassCircleMessageDTO> classCircleMessageDTOList = new ArrayList<>();
        List<StudentCourseCommentDTO> studentCourseCommentDTOList = new ArrayList<>();
        List<StudentVacationApplyDTO> studentVacationApplyDTOList = new ArrayList<>();
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = new ArrayList<>();

        if(("all").equals(pageParamDTO.getRequestData()))
        {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(studentId);
            List<StudentDTO> studentDTOS = studentDao.getStudentInfo(studentDTO);

            if(studentDTOS.size()>0)
            {
                //查找所有这个学生下面的课堂点评信息
                studentCourseCommentDTOList =
                        studentDao.getTeacherCommentStudentListByClassId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentDTOS.get(0).getClassId());

                //查找所有的这个老师处理的休假信息
                studentVacationApplyDTOList =
                        studentDao.getTeacherVacationApplyListByClassId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentDTOS.get(0).getClassId());

                //查找所有的这个老师的作业批改信息
                courseHomeWorkStudentDTOList =
                        studentDao.getCourseStudentHomeWorkListByClassId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentDTOS.get(0).getClassId());
            }
        }
        else if(("mine").equals(pageParamDTO.getRequestData()))
        {
            //查找所有这个学生下面的课堂点评信息
            studentCourseCommentDTOList =
                    studentDao.getTeacherCommentStudentListByStudentId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentId);

            //查找所有的这个老师处理的休假信息
            studentVacationApplyDTOList =
                    studentDao.getTeacherVacationApplyListByStudentId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentId);

            //查找所有的这个老师的作业批改信息
            courseHomeWorkStudentDTOList =
                    studentDao.getCourseStudentHomeWorkListByStudentId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),studentId);
        }

        for(StudentCourseCommentDTO studentCourseCommentDTO:studentCourseCommentDTOList)
        {
            ClassCircleMessageDTO classCircleMessageDTO = new ClassCircleMessageDTO();
            classCircleMessageDTO.setMessageType(ClassCircleMessage.COURSE_COMMENT);
            if(studentCourseCommentDTO.getCourseCommentCreateDate()!=null)
            {
                classCircleMessageDTO.setCreateDate(studentCourseCommentDTO.getCourseCommentCreateDate());
                classCircleMessageDTO.setMessage(studentCourseCommentDTO);
                classCircleMessageDTOList.add(classCircleMessageDTO);
            }
        }

        for(StudentVacationApplyDTO studentVacationApplyDTO:studentVacationApplyDTOList)
        {
            ClassCircleMessageDTO classCircleMessageDTO = new ClassCircleMessageDTO();
            classCircleMessageDTO.setMessageType(ClassCircleMessage.VACATION_APPLY);
            if(studentVacationApplyDTO.getApplyDate()!=null)
            {
                classCircleMessageDTO.setCreateDate(studentVacationApplyDTO.getApplyDate());
                classCircleMessageDTO.setMessage(studentVacationApplyDTO);
                classCircleMessageDTOList.add(classCircleMessageDTO);
            }
        }

        for(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO:courseHomeWorkStudentDTOList)
        {
            ClassCircleMessageDTO classCircleMessageDTO = new ClassCircleMessageDTO();
            classCircleMessageDTO.setMessageType(ClassCircleMessage.HOMEWORK_COMMENT);
            if(courseHomeWorkStudentDTO.getHomeWorkCreateDate()!=null)
            {
                classCircleMessageDTO.setCreateDate(courseHomeWorkStudentDTO.getHomeWorkCreateDate());
                classCircleMessageDTO.setMessage(courseHomeWorkStudentDTO);
                classCircleMessageDTOList.add(classCircleMessageDTO);
            }
        }

        Collections.sort(classCircleMessageDTOList,
                new Comparator<ClassCircleMessageDTO>() {
                    @Override
                    public int compare(ClassCircleMessageDTO classCircleMessageDTO1, ClassCircleMessageDTO classCircleMessageDTO2) {
                        int flag = classCircleMessageDTO2.getCreateDate().compareTo(classCircleMessageDTO1.getCreateDate());
                        return flag;
                    }
                });

        return classCircleMessageDTOList;

    }
}
