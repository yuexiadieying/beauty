package com.meixiang.beauty.webapp.education.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.StringUtils;
import com.meixiang.beauty.webapp.education.annotation.EducationLoginRequired;
import com.meixiang.beauty.webapp.education.dao.TeacherDao;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.service.StudentService;
import com.meixiang.beauty.webapp.education.service.TeacherService;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@RequestMapping(value = "educationTeacher")
public class EducationTeacherController {


    @Autowired
    TeacherDao teacherDao;

    @Autowired
    private TeacherService teacherService;

    //获取一个老师自己的审批课程任务
    @RequestMapping(value = "teacherMissionList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<TeacherMissionDTO>> teacherMissionList() {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<List<TeacherMissionDTO>> responseDTO = new ResponseDTO<>();

        //通过业务层的代码书写
        List<TeacherMissionDTO> teacherMissionDTOList = teacherService.getTeacherMissionList(teacherDTO.getTeacherId());

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(teacherMissionDTOList);
        return responseDTO;
    }

    //todo 获取登录老师，自己的备课任务
    @RequestMapping(value = "teacherCoursePrepareList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CourseClassInfoDTO>> teacherCoursePrepareList() {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<List<CourseClassInfoDTO>> responseDTO = new ResponseDTO<>();
        List<CourseClassInfoDTO> courseClassInfoDTOList = new ArrayList<>();

        //通过业务层的代码书写
        courseClassInfoDTOList = teacherService.getCoursePrepareList(teacherDTO);

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(courseClassInfoDTOList);
        return responseDTO;
    }


    //老师获取自己课表基本信息
    //weekIndex 3表示第3周，5表示第5周，若weekIndex为空，没有值，则表示为当前周，例如当前是第8周
    @RequestMapping(value = "teacherCourseTableBaseInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<HashMap<String,Object>> teacherCourseTableBaseInfo() {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<HashMap<String,Object>> responseDTO = new ResponseDTO<>();
        HashMap<String,Object> hashMap = new HashMap<String,Object>();

        SchoolDTO schoolDTO = teacherDao.getSchoolInfo(teacherDTO.getTeacherId());
        Date startSchoolDate = schoolDTO.getStartSchoolDate();
        Integer weekIndex = 0;
        weekIndex = EducationUtil.getCurrentWeekIndex(startSchoolDate,weekIndex);

        Calendar calendar = Calendar.getInstance();
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month = calendar.get(Calendar.MONTH)+1;

        hashMap.put("weekIndex",weekIndex);

        hashMap.put("month",month);

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


    //老师获取自己的课程表
    //weekIndex 3表示第3周，5表示第5周，若weekIndex为空，没有值，则表示为当前周，例如当前是第8周
    @RequestMapping(value = "teacherCourseTableList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<TeacherCourseTableDTO>> teacherCourseTableList(@RequestParam(required = false) Integer weekIndex) {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<List<TeacherCourseTableDTO>> responseDTO = new ResponseDTO<>();
        List<TeacherCourseTableDTO> teacherCourseTableDTOList = new ArrayList<>();

        //通过业务层的代码书写，获取老师weekDate所属周的课程表
        teacherCourseTableDTOList = teacherService.getTeacherCourseTableList(teacherDTO,weekIndex);

        responseDTO.setResponseData(teacherCourseTableDTOList);
        return responseDTO;
    }

    //老师获取自己学生的请假申请
    @RequestMapping(value = "getTeacherVacationApplyList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentVacationApplyDTO>> getTeacherVacationApplyList(@RequestParam String vacationStatus) {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<List<StudentVacationApplyDTO>> responseDTO = new ResponseDTO<>();
        List<StudentVacationApplyDTO> studentVacationApplyDTOS = new ArrayList<>();

        //通过业务层的代码书写，获取老师下面所有的教课的班级
        if(vacationStatus.equals("history"))
        {
            studentVacationApplyDTOS = teacherService.getTeacherVacationApplyList(teacherDTO.getTeacherId(),"1");
            studentVacationApplyDTOS.addAll(teacherService.getTeacherVacationApplyList(teacherDTO.getTeacherId(),"2"));
        }
        else
        {
            studentVacationApplyDTOS = teacherService.getTeacherVacationApplyList(teacherDTO.getTeacherId(),vacationStatus);
        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(studentVacationApplyDTOS);
        return responseDTO;
    }

    //老师处理学生的请假申请
    @RequestMapping(value = "processVacationApply", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO processVacationApply(@RequestParam String vacationId,@RequestParam String status) {
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        ResponseDTO responseDTO = new ResponseDTO<>();
        teacherService.processVacationApply(vacationId,status);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师获取自己下面的班级
    @RequestMapping(value = "teacherClassList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<ClassInfoDTO>> teacherClassList() {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        ResponseDTO<List<ClassInfoDTO>> responseDTO = new ResponseDTO<>();
        List<ClassInfoDTO> classInfoDTOList = new ArrayList<>();

        //通过业务层的代码书写，获取老师下面所有的教课的班级
        classInfoDTOList = teacherService.getTeacherClassList(teacherDTO.getTeacherId());

        responseDTO.setResponseData(classInfoDTOList);
        return responseDTO;
    }

    //获取老师的某个课程任务下，某个学生提交的作业详情
    @RequestMapping(value = "teacherCourseMissionDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<CourseHomeWorkStudentDTO> teacherCourseMissionDetail(@RequestParam String missionId,@RequestParam String studentId) {

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        ResponseDTO<CourseHomeWorkStudentDTO> responseDTO = new ResponseDTO<>();

        //通过业务层的代码书写，获取老师某个课程任务下班级的所有学生提交情况
        CourseHomeWorkStudentDTO studentCourseMissionDTO = teacherService.getTeacherCourseMissionDetail(missionId,studentId);

        responseDTO.setResponseData(studentCourseMissionDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师对某个学生作业完成的情况进行点评
    @RequestMapping(value = "teacherPushHomeWorkComment", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO teacherPushHomeWorkComment(@RequestBody CourseHomeWorkStudentDTO courseHomeWorkStudentDTO) {

        ResponseDTO responseDTO = new ResponseDTO<>();

        //通过业务层的代码书写，获取老师某个课程任务下班级的所有学生提交情况
        teacherService.saveTeacherHomeWorkComment(courseHomeWorkStudentDTO);

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取老师的某个课程任务下的学生提交列表
    @RequestMapping(value = "teacherCourseMissionList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CourseHomeWorkStudentDTO>> teacherCourseMissionList(@RequestParam String courseMissionId) {

        ResponseDTO<List<CourseHomeWorkStudentDTO>> responseDTO = new ResponseDTO<>();

        //通过业务层的代码书写，获取老师下面所有的学生申请的请假
        List<CourseHomeWorkStudentDTO> studentCourseMissionDTOList = teacherService.getTeacherCourseMissionList(courseMissionId);

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(studentCourseMissionDTOList);
        return responseDTO;
    }

    //获取老师针对某个任务提交针对此学生的点评
    @RequestMapping(value = "courseMissionComment", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO courseMissionComment(@RequestBody CourseHomeWorkStudentDTO studentCourseMissionDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        //老师点评的数据，放在了studentCourseMissionDTO中，通过业务层在数据库中保存下来。
        studentCourseMissionDTO.setTeacherId(teacherDTO.getTeacherId());
        StudentCourseCommentDTO studentCourseCommentDTO = teacherService.getCourseMissionComment(studentCourseMissionDTO);
        responseDTO.setResponseData(studentCourseCommentDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师针对某个班级的下属课程，布置任务
    @RequestMapping(value = "teacherPushMission", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO teacherPushMission(@RequestBody List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOS) {

        ResponseDTO responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        //老师针对某个班级的下属课程，布置任务，通过业务层在数据库中保存下来。
        teacherService.teacherPushMission(teacherDTO,courseHomeWorkStudentDTOS);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 获取老师下面某个班级课程的信息
    @RequestMapping(value = "teacherCourseBaseInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<CourseClassInfoDTO> teacherCourseBaseInfo(@RequestParam String classId,@RequestParam String courseId) {

        ResponseDTO responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        CourseClassInfoDTO courseClassInfoDTO = new CourseClassInfoDTO();

        //获取老师下面某个班级课程的信息

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(courseClassInfoDTO);
        return responseDTO;
    }

    //获取老师下面某个班级下的某个课程的历史任务列表
    @RequestMapping(value = "teacherCourseMissionHistoryList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CourseHomeWorkStudentDTO>> teacherCourseMissionHistoryList(@RequestParam String classId,@RequestParam String classCourseId) {

        ResponseDTO<List<CourseHomeWorkStudentDTO>> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        //获取老师下面某个班级下的某个课程的历史任务列表。
        CourseHomeWorkStudentDTO studentCourseMissionDTO = new CourseHomeWorkStudentDTO();
        studentCourseMissionDTO.setTeacherId(teacherDTO.getTeacherId());
        studentCourseMissionDTO.setClassCourseId(classCourseId);
        List<CourseHomeWorkStudentDTO> missionBaseInfoDTOList = teacherService.getTeacherCourseMissionHistoryList(studentCourseMissionDTO);

        responseDTO.setResponseData(missionBaseInfoDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //获取某个老师某个班级下，某个课程下的学生的点评情况
    @RequestMapping(value = "teacherCommentStudentList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentCourseCommentDTO>> teacherCommentStudentList(@RequestParam String classId,@RequestParam String courseId) {

        ResponseDTO<List<StudentCourseCommentDTO>> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        //获取老师下面某个班级下的某个课程的历史任务列表。
        List<StudentCourseCommentDTO> studentCourseCommentDTOList = teacherService.getTeacherCommentStudentList(classId,courseId,teacherDTO.getTeacherId());
        responseDTO.setResponseData(studentCourseCommentDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师提交对学生课堂的表现点评
    @RequestMapping(value = "teacherPushCommentStudent", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO teacherPushCommentStudent(@RequestBody List<StudentCourseCommentDTO> studentCourseCommentDTOS) {

        ResponseDTO responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        //老师提交对某个学生课堂的表现点评，并存入数据库中。
        for(StudentCourseCommentDTO studentCourseCommentDTO:studentCourseCommentDTOS)
        {
            studentCourseCommentDTO.setId(UUID.randomUUID().toString());
            studentCourseCommentDTO.setTeacherId(teacherDTO.getTeacherId());
            studentCourseCommentDTO.setCourseCommentCreateDate(new Date());
            teacherService.saveTeacherCourseComment(studentCourseCommentDTO);
        }
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 班级圈，老师获取所有与自己有关的班级圈信息
    @RequestMapping(value = "teacherClassMessageList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<ClassMessageDTO>> teacherClassMessageList() {

        ResponseDTO<List<ClassMessageDTO>> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        //老师获取所有与自己有关的班级圈信息
        List<ClassMessageDTO> classMessageDTOList = new ArrayList<>();

        responseDTO.setResponseData(classMessageDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //老师获取自己个人信息
    @RequestMapping(value = "teacherInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<TeacherDTO> teacherInfo() {

        ResponseDTO<TeacherDTO> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        responseDTO.setResponseData(teacherDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 老师给学生的德育量化评分
    @RequestMapping(value = "teacherMoralStudent", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<String> teacherMoralStudent(@RequestBody StudentMoralityDTO studentMoralityDTO) {

        ResponseDTO<String> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

       //老师给学生的德育量化评分
        teacherService.saveTeacherMoralStudent(studentMoralityDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 获取某个课程任务下学生的完成情况
    @RequestMapping(value = "teacherDiscussStudentList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<StudentCourseCommentDTO>> teacherDiscussStudentList(@RequestParam String classId,
                                                                          @RequestParam String courseId,
                                                                          @RequestParam String weekIndex) {

        ResponseDTO<List<StudentCourseCommentDTO>> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        List<StudentCourseCommentDTO> studentCourseCommentDTOList = teacherService.getTeacherDiscussStudentList(classId,courseId,weekIndex,teacherDTO.getTeacherId());

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(studentCourseCommentDTOList);
        return responseDTO;
    }

    @RequestMapping(value = "teacherClassCircle", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<ClassCircleMessageDTO>> GetTeacherClassCircle(@RequestBody PageParamDTO pageParamDTO) {

        ResponseDTO<List<ClassCircleMessageDTO>> responseDTO = new ResponseDTO();
        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        List<ClassCircleMessageDTO> classCircleMessageDTOS = teacherService.GetTeacherClassCircle(pageParamDTO,teacherDTO.getTeacherId());

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(classCircleMessageDTOS);
        return responseDTO;
    }
}
