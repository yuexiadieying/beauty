package com.meixiang.beauty.webapp.education.service;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.sys.utils.UUIDUtil;
import com.meixiang.beauty.webapp.education.dao.StudentDao;
import com.meixiang.beauty.webapp.education.dao.TeacherDao;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.util.ClassCircleMessage;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    public List<ClassInfoDTO> getTeacherClassList(String teacherId){
        return teacherDao.getTeacherClassList(teacherId);
    }

    public List<TeacherCourseTableDTO> getTeacherCourseTableList(TeacherDTO teacherDTO,Integer weekIndex){

        SchoolDTO schoolDTO = teacherDao.getSchoolInfo(teacherDTO.getTeacherId());
        Date startSchoolDate = schoolDTO.getStartSchoolDate();
        weekIndex = EducationUtil.getCurrentWeekIndex(startSchoolDate,weekIndex);

        List<TeacherCourseTableDTO> l = new ArrayList<>();
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
            List<CourseInfoDTO> courseList = teacherDao.getTeacherCourseTableList(teacherDTO.getTeacherId(),week);
            TeacherCourseTableDTO teacherCourseTableDTO = new TeacherCourseTableDTO();
            teacherCourseTableDTO.setWeekIndex(weekIndex);
            if(week == 0)
            {
                teacherCourseTableDTO.setWeekName("周日");
            }
            else
            {
                teacherCourseTableDTO.setWeekName("周"+week);
            }

            String dates[] = f.format(c.getTime()).split("-");
            teacherCourseTableDTO.setWeekMonth(dates[1]);
            teacherCourseTableDTO.setWeekDate(dates[2]+"号");

            List<CourseInfoDTO> courseInfoDTOList = new ArrayList<>();
            for(CourseInfoDTO courseInfoDTO:courseList)
            {
                String[] places = courseInfoDTO.getCoursePlace().split(",");
                for(int j=0;j<places.length;j++)
                {
                    CourseInfoDTO courseInfoDTO1 = new CourseInfoDTO();
                    courseInfoDTO1.setClassName(courseInfoDTO.getClassName());
                    courseInfoDTO1.setClassId(courseInfoDTO.getClassId());
                    courseInfoDTO1.setCourseId(courseInfoDTO.getCourseId());
                    courseInfoDTO1.setCourseName(courseInfoDTO.getCourseName());
                    courseInfoDTO1.setCoursePlace(places[j]);
                    courseInfoDTOList.add(courseInfoDTO1);
                }
            }
            teacherCourseTableDTO.setCourseList(courseInfoDTOList);
            l.add(teacherCourseTableDTO);
        }
        return l;
    }

    public void saveTeacherCourseComment(StudentCourseCommentDTO studentCourseCommentDTO){
        teacherDao.saveTeacherCourseComment(studentCourseCommentDTO);
    }

    public List<StudentCourseCommentDTO> getTeacherCommentStudentList(String classId,String courseId,String teacherId){
        return teacherDao.getTeacherCommentStudentList(classId,courseId,teacherId);
    }

    public List<TeacherMissionDTO> getTeacherMissionList(String teacherId){
        return teacherDao.getTeacherHomePageMissionList(teacherId);
    }

    public CourseHomeWorkStudentDTO getTeacherCourseMissionDetail(@Param("missionId")String missionId,@Param("studentId")String studentId){
        return teacherDao.getTeacherCourseMissionDetail(missionId,studentId);
    }

    public List<CourseHomeWorkStudentDTO> getTeacherCourseMissionList(String missionId){
        return teacherDao.getTeacherCourseMissionList(missionId);
    }

    public void teacherPushMission(TeacherDTO teacherDTO,List<CourseHomeWorkStudentDTO> missionBaseInfoDTOS){
        for(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO:missionBaseInfoDTOS)
        {
            //todo 将作业信息存入sys_homework中
            String classCourseId = teacherDao.getClassCourseRelId(
                    teacherDTO.getTeacherId(),
                    courseHomeWorkStudentDTO.getClassId(),
                    courseHomeWorkStudentDTO.getCourseId(),
                    courseHomeWorkStudentDTO.getWeekIndex());
            String homeWorkId = UUID.randomUUID().toString();
            courseHomeWorkStudentDTO.setHomeWorkId(homeWorkId);
            courseHomeWorkStudentDTO.setTeacherId(teacherDTO.getTeacherId());
            courseHomeWorkStudentDTO.setHomeWorkCreateDate(new Date());
            courseHomeWorkStudentDTO.setClassCourseId(classCourseId);
            teacherDao.createHomeWork(courseHomeWorkStudentDTO);

            //todo 批量创建学生和作业关联
            List<StudentDTO> studentDTOList = teacherDao.getStudentListByClassId(courseHomeWorkStudentDTO.getClassId());
            List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = new ArrayList<>();
            String homeWorkDesc = courseHomeWorkStudentDTO.getHomeWorkDesc();
            String homeWorkName = courseHomeWorkStudentDTO.getHomeWorkName();
            String weekIndex = courseHomeWorkStudentDTO.getWeekIndex();
            for(StudentDTO studentDTO:studentDTOList)
            {
                CourseHomeWorkStudentDTO courseHomeWorkStudentDTO1 = new CourseHomeWorkStudentDTO();
                courseHomeWorkStudentDTO1.setHomeWorkDesc(homeWorkDesc);
                courseHomeWorkStudentDTO1.setHomeWorkName(homeWorkName);
                courseHomeWorkStudentDTO1.setHomeWorkId(homeWorkId);
                courseHomeWorkStudentDTO1.setWeekIndex(weekIndex);
                courseHomeWorkStudentDTO1.setStudentId(studentDTO.getStudentId());
                courseHomeWorkStudentDTO1.setHomeWorkStudentRelId(UUID.randomUUID().toString());
                courseHomeWorkStudentDTOList.add(courseHomeWorkStudentDTO1);
            }
            teacherDao.createStudentHomeRelBatch(courseHomeWorkStudentDTOList);

            int t = 0;
        }
    }

    public StudentCourseCommentDTO getCourseMissionComment(CourseHomeWorkStudentDTO studentCourseMissionDTO){
        return teacherDao.getCourseMissionComment(studentCourseMissionDTO);
    }

    public List<CourseHomeWorkStudentDTO> getTeacherCourseMissionHistoryList(CourseHomeWorkStudentDTO studentCourseMissionDTO){
        return teacherDao.getTeacherCourseMissionHistoryList(studentCourseMissionDTO);
    }

    public List<CourseClassInfoDTO> getCoursePrepareList(TeacherDTO teacherDTO) {

        List<CourseClassInfoDTO> courseClassInfoDTOS = teacherDao.getCoursePrepareList(teacherDTO.getTeacherId());

        List<CourseClassInfoDTO> courseClassInfoDTOList = new ArrayList<>();

        for(CourseClassInfoDTO courseClassInfoDTO:courseClassInfoDTOS)
        {
            int weekIndex = DateUtils.getWeekIndex(new Date());
            if(courseClassInfoDTO.getWeekIndex().equals(String.valueOf(weekIndex+1)))
            {
                courseClassInfoDTOList.add(courseClassInfoDTO);
            }
        }
        return courseClassInfoDTOList;
    }

    public void saveTeacherMoralStudent(StudentMoralityDTO studentMoralityDTO){
        teacherDao.saveTeacherMoralStudent(studentMoralityDTO);
    }

    public List<TeacherDTO> getTeacherInfo(TeacherDTO teacherDTO) {
        return teacherDao.getTeacherInfo(teacherDTO);
    }

    public List<StudentVacationApplyDTO> getTeacherVacationApplyList(String teacherId, String status) {
        return teacherDao.getTeacherVacationApplyList(teacherId, status);
    }

    public void processVacationApply(String vacationId, String status) {
        teacherDao.processVacationApply(vacationId, status);
    }

    public List<StudentCourseCommentDTO> getTeacherDiscussStudentList(String classId, String courseId, String weekIndex, String teacherId) {
        //todo 查询作业下的学生提交情况
        return teacherDao.getTeacherDiscussStudentList(classId,courseId,weekIndex,teacherId);
    }

    public void saveTeacherHomeWorkComment(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO) {

        courseHomeWorkStudentDTO.setHomeWorkCommentCreateDate(new Date());
        courseHomeWorkStudentDTO.setHomeWorkCommentId(UUID.randomUUID().toString());

        teacherDao.saveTeacherHomeWorkStatus(courseHomeWorkStudentDTO);
        teacherDao.saveTeacherHomeWorkComment(courseHomeWorkStudentDTO);
    }

    public List<ClassCircleMessageDTO> GetTeacherClassCircle(PageParamDTO pageParamDTO,String teacherId) {

        List<ClassCircleMessageDTO> classCircleMessageDTOList = new ArrayList<>();

        //查找所有这个老师下面的课堂点评信息
        List<StudentCourseCommentDTO> studentCourseCommentDTOList =
                teacherDao.getTeacherCommentStudentListByTeacherId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),teacherId);

        //查找所有的这个老师处理的休假信息
        List<StudentVacationApplyDTO> studentVacationApplyDTOList =
                teacherDao.getTeacherVacationApplyListByTeacherId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),teacherId);

        //查找所有的这个老师的作业批改信息
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList =
                teacherDao.getCourseStudentHomeWorkListByTeacherId(pageParamDTO.getPageNo(),pageParamDTO.getPageSize(),teacherId);

        for(StudentCourseCommentDTO studentCourseCommentDTO:studentCourseCommentDTOList)
        {
            ClassCircleMessageDTO classCircleMessageDTO = new ClassCircleMessageDTO();
            classCircleMessageDTO.setMessageType(ClassCircleMessage.COURSE_COMMENT);
            classCircleMessageDTO.setTeacherId(teacherId);
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
            classCircleMessageDTO.setTeacherId(teacherId);
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
            classCircleMessageDTO.setTeacherId(teacherId);
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
