package com.meixiang.beauty.webapp.education.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.Sha1Util;
import com.meixiang.beauty.webapp.education.annotation.EducationLoginRequired;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.service.StudentService;
import com.meixiang.beauty.webapp.education.service.SystemService;
import com.meixiang.beauty.webapp.education.service.TeacherService;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.meixiang.beauty.webapp.education.util.EducationUtil.getHeadersInfo;


@Controller
@RequestMapping(value = "educationSystem")
public class EducationSystemController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private TeacherService teacherService;

    private Gson gson = new Gson();

    //todo 根据新闻的ID号，获取新闻详情
    @RequestMapping(value = "schoolNews", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<SchoolNewsDTO> schoolNews(@RequestParam String schoolNewsId){

        ResponseDTO<SchoolNewsDTO> responseDTO = new ResponseDTO<>();
        SchoolNewsDTO schoolNewsDTO = new SchoolNewsDTO();

        //通过业务层的代码，实现新闻ID，获取新闻的详细内容。

        responseDTO.setResponseData(schoolNewsDTO);
        return  responseDTO;
    }

    //todo 获取学校的的新闻列表
    @RequestMapping(value = "schoolNewsList", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<SchoolNewsDTO>> schoolNewsList(@RequestParam String schoolId){

        ResponseDTO<List<SchoolNewsDTO>> responseDTO = new ResponseDTO<>();

        List<SchoolNewsDTO> schoolNewsDTOList = new ArrayList<>();
        //通过业务层的代码，实现根据用户的学校ID，获取新闻的列表
        schoolNewsDTOList = systemService.getSchoolNewsList(schoolId);

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(schoolNewsDTOList);
        return responseDTO;
    }

    @RequestMapping(value = "schoolNewsDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<SchoolNewsDTO> schoolNewsDetail(@RequestParam String newsId){

        ResponseDTO<SchoolNewsDTO> responseDTO = new ResponseDTO<>();

        //通过业务层的代码，实现根据用户的学校ID，获取新闻的列表
        SchoolNewsDTO schoolNewsDTO = systemService.getSchoolNewsDetail(newsId);

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(schoolNewsDTO);
        return responseDTO;
    }

    @RequestMapping(value = "submitMasterMail", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO submitMasterMail(@RequestBody MasterMessageDTO masterMessageDTO){

        ResponseDTO responseDTO = new ResponseDTO<>();

        masterMessageDTO.setId(UUID.randomUUID().toString());
        masterMessageDTO.setCreateDate(new Date());

        TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
        StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        if(teacherDTO!=null)
        {
            masterMessageDTO.setSchoolId(teacherDTO.getSchoolId());
            masterMessageDTO.setTeacherId(teacherDTO.getTeacherId());

        }else if(studentDTO!=null)
        {
            masterMessageDTO.setSchoolId(studentDTO.getSchoolId());
            masterMessageDTO.setStudentId(studentDTO.getStudentId());
        }

        //通过业务层的代码，实现根据用户的学校ID，获取新闻的列表
        systemService.submitMasterMail(masterMessageDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 根据学校的ID，来获取这个学校的信息
    @RequestMapping(value = "schoolInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @EducationLoginRequired
    public
    @ResponseBody
    ResponseDTO<SchoolDTO> schoolInfo(@RequestParam String schoolId){
        ResponseDTO<SchoolDTO> responseDTO = new ResponseDTO<>();
        //根据学校的ID，来获取这个学校的信息
        SchoolDTO schoolDTO = systemService.getSchoolInfoById(schoolId);
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(schoolDTO);
        return responseDTO;
    }

    //todo 学生或者老师登录，userType为student，teacher两种类型
    @RequestMapping(value = "educationLogin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> educationLogin(@RequestParam String educationNumber,
                                       @RequestParam String educationPassword,
                                       @RequestParam String schoolId,
                                       @RequestParam String userType){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        String loginToken = UUID.randomUUID().toString();

        //学生或者老师登录，userType为student，teacher两种类型
        if("student".equals(userType))
        {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudyNo(educationNumber);
            studentDTO.setSchoolId(schoolId);

            List<StudentDTO> studentDTOS = studentService.getStudentInfo(studentDTO);

            if(studentDTOS.size()>0&&!schoolId.equals(studentDTOS.get(0).getSchoolId()))
            {
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("学校地址不对");
                return responseDTO;
            }
            else if(studentDTOS.size()>0&&educationPassword.equals(studentDTOS.get(0).getPassword()))
            {
                String userInfoStr = gson.toJson(studentDTOS.get(0));
                JedisUtils.set(loginToken,userInfoStr, ConfigConstant.logintokenPeriod);
                responseDTO.setResult(StatusConstant.SUCCESS);
                responseDTO.setResponseData(loginToken);
            }
            else
            {
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("密码或者学工号不对");
                return responseDTO;
            }
        }
        else if("teacher".equals(userType))
        {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setTeacherNo(educationNumber);
            teacherDTO.setSchoolId(schoolId);

            List<TeacherDTO> teacherDTOS = teacherService.getTeacherInfo(teacherDTO);

            if(teacherDTOS.size()>0&&!schoolId.equals(teacherDTOS.get(0).getSchoolId()))
            {
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("学校地址不对");
                return responseDTO;
            }
            else if(teacherDTOS.size()>0&&educationPassword.equals(teacherDTOS.get(0).getPassword()))
            {
                String userInfoStr = gson.toJson(teacherDTOS.get(0));
                JedisUtils.set(loginToken,userInfoStr, ConfigConstant.logintokenPeriod);
                responseDTO.setResult(StatusConstant.SUCCESS);
                responseDTO.setResponseData(loginToken);
            }
            else
            {
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("密码或者工号不对");
                return responseDTO;
            }
        }

        return responseDTO;
    }

    //todo 学生或者老师修改他们的登录密码
    @RequestMapping(value = "educationPasswordChange", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO educationPasswordChange(@RequestParam String educationNumber,
                                                @RequestParam String oldPassword,
                                                @RequestParam String newPassword,
                                                @RequestParam String schoolId,
                                                @RequestParam String userType){
        ResponseDTO responseDTO = new ResponseDTO();

       //学生或者老师登录，userType为student，teacher两种类型
        if(userType.equals("student"))
        {
            //修改学生的登录密码
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudyNo(educationNumber);
            studentDTO.setSchoolId(schoolId);
            studentDTO.setPassword(newPassword);
            StudentDTO oldDto = systemService.getStudentInfo(studentDTO);
            if(Sha1Util.validatePassword(oldPassword,oldDto.getPassword())){
                studentDTO.setStudentId(oldDto.getStudentId());
                systemService.updateStudentPassword(studentDTO);
            }else{
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("原密码错误！");
            }
        }
        else if(userType.equals("teacher"))
        {
            //修改老师的登录密码
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setSchoolId(schoolId);
            teacherDTO.setTeacherNo(educationNumber);
            teacherDTO.setPassword(Sha1Util.entryptPassword(newPassword));
            TeacherDTO oldDto = systemService.getTeacherInfo(teacherDTO);
            if(Sha1Util.validatePassword(oldPassword,oldDto.getPassword())){
                teacherDTO.setTeacherId(oldDto.getTeacherId());
                systemService.updateTeacherPassword(teacherDTO);
            }else{
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("原密码错误！");
            }
        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 获取校园的人人通信息列表
    @RequestMapping(value = "renrenList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<RenrenDTO>> renrenList(@RequestParam String userType){

        ResponseDTO<List<RenrenDTO>> responseDTO = new ResponseDTO();
        List<RenrenDTO> renrenDTOList = new ArrayList<>();

        //todo 获取校园的人人通信息列表
        if(userType.equals("student"))
        {
            StudentDTO studentDTO = EducationUtil.getStudentFromRedis();

        }
        else if(userType.equals("teacher"))
        {
            TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();

        }
        renrenDTOList = systemService.getRenrenList(userType);
        responseDTO.setResponseData(renrenDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;

    }

    //todo 学生或者老师获取某条人人信息详情
    @RequestMapping(value = "renrenDetail", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<RenrenDTO> renrenDetail(@RequestParam String renrenId){

        ResponseDTO<RenrenDTO> responseDTO = new ResponseDTO();
        RenrenDTO renrenDTO = new RenrenDTO();
        renrenDTO = systemService.getRenrenDetail(renrenId);
        responseDTO.setResponseData(renrenDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;

    }

    //todo 学生或者老师对某条人人通消息发表评论
    @RequestMapping(value = "renrenDiscuss", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> renrenDiscuss(@RequestBody RenrenDiscussDTO renrenDiscussDTO){

        ResponseDTO<String> responseDTO = new ResponseDTO();
        String userId = "";

        //todo 学生或者老师获对某条人人通消息点评
        if(renrenDiscussDTO.getUserType().equals("student"))
        {
            StudentDTO studentDTO = EducationUtil.getStudentFromRedis();
            userId = studentDTO.getStudentId();
        }
        else if(renrenDiscussDTO.getUserType().equals("teacher"))
        {
            TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
            userId = teacherDTO.getTeacherId();
        }

        renrenDiscussDTO.setUserId(userId);
        systemService.saveRenrenDiscuss(renrenDiscussDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;

    }

    //todo 学生或者老师发布新的人人通消息
    @RequestMapping(value = "renrenSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> renrenSubmit(@RequestBody RenrenDTO renrenDTO){

        ResponseDTO<String> responseDTO = new ResponseDTO();
        String userId = "";
        //todo 学生或者老师发布新的人人通消息
        if(renrenDTO.getUserType().equals("student"))
        {
            StudentDTO studentDTO = EducationUtil.getStudentFromRedis();
            userId = studentDTO.getStudentId();
        }
        else if(renrenDTO.getUserType().equals("teacher"))
        {
            TeacherDTO teacherDTO = EducationUtil.getTeacherFromRedis();
            userId = teacherDTO.getTeacherId();
        }
        renrenDTO.setUserId(userId);
        systemService.saveRenren(renrenDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;

    }

}
