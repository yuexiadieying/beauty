package com.meixiang.beauty.webapp.education.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.utils.ReceiveXmlProcess;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.sys.entity.ReceiveXmlEntity;
import com.meixiang.beauty.sys.utils.UUIDUtil;
import com.meixiang.beauty.webapp.education.dao.SystemDao;
import com.meixiang.beauty.webapp.education.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SystemService {

    @Autowired
    SystemDao systemDao;

    public static MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    public String processRobotWeixinRequest(HttpServletRequest request, HttpServletResponse response) {
        String respMessage = null;

        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(WeixinUtil.getXmlDataFromWeixin(request));
        String msgType = xmlEntity.getMsgType();
        return respMessage;
    }

    public List<RenrenDTO> getRenrenList(String userType){
        List<RenrenDTO> list = systemDao.getRenrenList(userType);
        return list;
    }

    public void saveRenren(RenrenDTO renrenDTO){
        renrenDTO.setId(UUIDUtil.getUUID());
        systemDao.saveRenren(renrenDTO);
    }

    public void saveRenrenDiscuss(RenrenDiscussDTO renrenDiscussDTO){
        renrenDiscussDTO.setId(UUIDUtil.getUUID());
        systemDao.saveRenrenDiscuss(renrenDiscussDTO);
    }

    public RenrenDTO getRenrenDetail(String renrenId){
        RenrenDTO renrenDTO = systemDao.getRenrenDetail(renrenId);
        renrenDTO.setRenrenDiscussList(systemDao.getRenrenDiscussList(renrenId));
        return renrenDTO;
    }

    public void updateStudentPassword(StudentDTO studentDTO){
        systemDao.updateStudentPassword(studentDTO);
    }

    public void updateTeacherPassword(TeacherDTO teacherDTO){
        systemDao.updateTeacherPassword(teacherDTO);
    }

    public StudentDTO getStudentInfo(StudentDTO studentDTO){
        return systemDao.getStudentInfo(studentDTO);
    }

    public TeacherDTO getTeacherInfo(TeacherDTO teacherDTO){
        return systemDao.getTeacherInfo(teacherDTO);
    }

    public SchoolDTO getSchoolInfoById(String schoolId){
        return systemDao.getSchoolInfoById(schoolId);
    }

    public List<SchoolNewsDTO> getSchoolNewsList(String schoolId) {
        return systemDao.getSchoolNewsList(schoolId,"1");
    }

    public SchoolNewsDTO getSchoolNewsDetail(String newsId) {
        return  systemDao.getSchoolNewsDetail(newsId);
    }

    public void submitMasterMail(MasterMessageDTO masterMessageDTO) {
        systemDao.saveMasterMessage(masterMessageDTO);
    }
}
