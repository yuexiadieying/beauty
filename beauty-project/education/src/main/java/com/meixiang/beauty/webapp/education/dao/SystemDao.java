package com.meixiang.beauty.webapp.education.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.education.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by sunxiao on 2018/8/27.
 */
@MyBatisDao
@Repository
public interface SystemDao {

    List<RenrenDTO> getRenrenList(String userType);

    void saveRenren(RenrenDTO renrenDTO);

    void saveRenrenDiscuss(RenrenDiscussDTO renrenDiscussDTO);

    RenrenDTO getRenrenDetail(String renrenId);

    List<RenrenDiscussDTO> getRenrenDiscussList(String renrenId);

    void updateStudentPassword(StudentDTO studentDTO);

    void updateTeacherPassword(TeacherDTO teacherDTO);

    StudentDTO getStudentInfo(StudentDTO studentDTO);

    TeacherDTO getTeacherInfo(TeacherDTO teacherDTO);

    SchoolDTO getSchoolInfoById(String schoolId);

    List<SchoolNewsDTO> getSchoolNewsList(@Param("schoolId") String schoolId,
                                          @Param("status") String status);

    SchoolNewsDTO getSchoolNewsDetail(@Param("newsId") String newsId);

    void saveMasterMessage(MasterMessageDTO masterMessageDTO);
}
