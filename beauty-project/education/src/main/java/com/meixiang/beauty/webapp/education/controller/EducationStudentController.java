package com.meixiang.beauty.webapp.education.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.webapp.education.annotation.EducationLoginRequired;
import com.meixiang.beauty.webapp.education.dao.StudentDao;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.service.StudentService;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping(value = "educationStudent")
public class EducationStudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    //学生获取自己最新的未读的通知消息
    @RequestMapping(value = "studentShortMessage", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<ShortMessageDTO> studentShortMessage() {

        ResponseDTO<ShortMessageDTO> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //学生获取自己最新的未读的通知消息
        ShortMessageDTO shortMessageDTO = studentService.getStudentShortMessage(studentDTO.getStudentId());

        responseDTO.setResponseData(shortMessageDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生获取自己某天的所有课程任务
    /*@RequestMapping(value = "studentCourseMissionList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CourseHomeWorkStudentDTO>> studentCourseMissionList(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date courseDate) {

        ResponseDTO<List<CourseHomeWorkStudentDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //学生获取自己当天的所有课程任务
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = studentService.getStudentCourseMissionByDate(studentDTO,courseDate);

        responseDTO.setResponseData(courseHomeWorkStudentDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }*/

    //学生获取自己某天的所有课程任务
    @RequestMapping(value = "studentCourseMissionList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CourseHomeWorkStudentDTO>> studentCourseMissionList(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date courseDate) {

        ResponseDTO<List<CourseHomeWorkStudentDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //学生获取自己当天的所有课程任务
        List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList = studentService.getStudentCourseMissionByDate(studentDTO,courseDate);

        responseDTO.setResponseData(courseHomeWorkStudentDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生获取德育量化分数列表，按日期由近到远的排序
    @RequestMapping(value = "studentMoralityList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentMoralityDTO>> studentMoralityList() {

        ResponseDTO<List<StudentMoralityDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //学生获取德育量化分数列表，按日期由近到远的排序,查询的一般是学生本学期的德育量化分
        List<StudentMoralityDTO> studentCourseMissionDTOList = studentService.getStudentMoralityList(studentDTO.getStudentId());

        responseDTO.setResponseData(studentCourseMissionDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师获取自己课表基本信息
    //weekIndex 3表示第3周，5表示第5周，若weekIndex为空，没有值，则表示为当前周，例如当前是第8周
    @RequestMapping(value = "studentCourseTableBaseInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<HashMap<String,Object>> studentCourseTableBaseInfo(@RequestParam Integer weekIndex) {

        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        ResponseDTO<HashMap<String,Object>> responseDTO = new ResponseDTO<>();
        HashMap<String,Object> hashMap = new HashMap<String,Object>();

        SchoolDTO schoolDTO = studentDao.getSchoolInfo(studentDTO.getClassId());
        Date startSchoolDate = schoolDTO.getStartSchoolDate();

        if(weekIndex==0)
        {
            weekIndex = EducationUtil.getCurrentWeekIndex(startSchoolDate,weekIndex);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startSchoolDate);
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month = calendar.get(Calendar.MONTH)+1;

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

        responseDTO.setResponseData(hashMap);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生获取某周的课程表
    //weekIndex 3表示第3周，5表示第5周，若weekIndex为空，没有值，则表示为当前周，例如当前是第8周
    @RequestMapping(value = "studentCourseTableList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentCourseTableDTO>> studentCourseTableList(@RequestParam Integer weekIndex) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();
        Map map = new HashMap();

        //获取学生某个周的课程列表信息
        map = studentService.studentCourseTableList(studentDTO,weekIndex);

        responseDTO.setResponseData(map);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生获取自己在本课程的某天任务
    @RequestMapping(value = "studentCourseMissionDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<CourseHomeWorkStudentDTO> studentCourseMissionDetail(@RequestParam String classCourseId, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date courseDate) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        CourseHomeWorkStudentDTO courseHomeWorkStudentDTO = new CourseHomeWorkStudentDTO();
        courseHomeWorkStudentDTO.setStudentId(studentDTO.getStudentId());
        courseHomeWorkStudentDTO.setClassId(studentDTO.getClassId());
        courseHomeWorkStudentDTO.setHomeWorkTime(courseDate);
        courseHomeWorkStudentDTO.setClassCourseId(classCourseId);

        //学生获取自己在本课程的某天任务
        MissionBaseInfoDTO missionBaseInfoDTO = studentService.getStudentCourseMissionDetail(courseHomeWorkStudentDTO);

        responseDTO.setResponseData(missionBaseInfoDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生获取自己在本课程的某天任务
    @RequestMapping(value = "getCourseMissionComment", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<CourseHomeWorkStudentDTO> getCourseMissionComment(@RequestParam String classCourseId) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        StudentCourseCommentDTO studentCourseCommentDTO = new StudentCourseCommentDTO();
        studentCourseCommentDTO.setClassCourseId(classCourseId);
        studentCourseCommentDTO.setStudentId(studentDTO.getStudentId());
        //学生获取自己在本课程的某天任务
        List<StudentCourseCommentDTO> list = studentService.getCourseMissionComment(studentCourseCommentDTO);

        responseDTO.setResponseData(list);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取学生的某个班级课程的信息
    @RequestMapping(value = "studentcourseClassInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<CourseClassInfoDTO> studentcourseClassInfo(@RequestParam String classId,@RequestParam String courseId) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //获取老师下面某个班级课程的信息
        CourseClassInfoDTO courseClassInfoDTO = studentService.getStudentCourseClassInfo(classId,courseId);
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(courseClassInfoDTO);
        return responseDTO;

    }

    //学生提交某个课程老师布置的任务
    @RequestMapping(value = "studentPushCourseMission", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO studentPushCourseMission(@RequestBody CourseHomeWorkStudentDTO courseHomeWorkStudentDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //学生提交某个课程老师布置的任务，通过业务层存入数据库中
        studentService.saveStudentMission(courseHomeWorkStudentDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 获取学生在此班级的所有可见的信息（有些信息可被用户设置成不可见，则看不到）
    @RequestMapping(value = "studentClassMessageList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<ClassMessageDTO>> studentClassMessageList() {

        ResponseDTO<List<ClassMessageDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //获取学生在此班级的所有可见的信息


        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取学生的基本信息
    @RequestMapping(value = "studentInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<StudentDTO> studentInfo() {

        ResponseDTO<StudentDTO> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        responseDTO.setResponseData(studentDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //学生提交请假申请
    @RequestMapping(value = "studentApplyVacation", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO studentApplyVacation(@RequestBody StudentVacationApplyDTO studentVacationApplyDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        studentVacationApplyDTO.setStudyNo(studentDTO.getStudyNo());
        studentVacationApplyDTO.setApplyDate(new Date());
        studentVacationApplyDTO.setVacationStatus("0");
        //新建学生的休假申请
        studentService.saveStudentApplyVacation(studentVacationApplyDTO);

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取学生的请假申请列表
    @RequestMapping(value = "studentVacationApplyList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO studentVacationApplyList() {

        ResponseDTO<List<StudentVacationApplyDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //获取学生的休假申请列表
        List<StudentVacationApplyDTO> studentVacationApplyDTOList = studentService.getStudentVacationApplyList(studentDTO.getStudyNo());
        responseDTO.setResponseData(studentVacationApplyDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取学生的某个请假详情情况
    @RequestMapping(value = "studentApplyVacationDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<StudentVacationApplyDTO> studentApplyVacationDetail(@RequestParam String vacationId) {

        ResponseDTO<StudentVacationApplyDTO> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        //获取学生的休假申请列表
        StudentVacationApplyDTO studentVacationApplyDTO = studentService.getStudentApplyVacationDetail(vacationId);

        responseDTO.setResponseData(studentVacationApplyDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 学生获取德育量化评分
    @RequestMapping(value = "studentMoralInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentMoralityDTO>> studentMoralInfo() {

        ResponseDTO<List<StudentMoralityDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();
        List<StudentMoralityDTO> studentMoralityDTOList = new ArrayList<>();

        //学生获取德育量化评分

        responseDTO.setResponseData(studentMoralityDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    @RequestMapping(value = "studentClassCircle", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<ClassCircleMessageDTO>> studentClassCircle(@RequestBody PageParamDTO<String> pageParamDTO) {

        ResponseDTO<List<ClassCircleMessageDTO>> responseDTO = new ResponseDTO();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        List<ClassCircleMessageDTO> classCircleMessageDTOS = studentService.GetStudentClassCircle(pageParamDTO,studentDTO.getStudentId());

        responseDTO.setResponseData(classCircleMessageDTOS);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

}
