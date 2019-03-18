package com.meixiang.beauty.webapp.education.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.education.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2018/6/20.
 */
@MyBatisDao
@Repository
public interface StudentDao {

    List<CourseInfoDTO> getStudentCourseTableList(@Param("classId") String classId, @Param("week")Integer week);

    SchoolDTO getSchoolInfo(@Param("classId")String classId);

    List<StudentVacationApplyDTO> getStudentVacationApplyList(@Param("studyNo")String studyNo);

    StudentVacationApplyDTO getStudentApplyVacationDetail(@Param("vacationId")String vacationId);

    void saveStudentApplyVacation(StudentVacationApplyDTO studentVacationApplyDTO);

    void updateStudentHomeworkRel(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    ShortMessageDTO getStudentShortMessage(@Param("studentId")String studentId);

    List<StudentMoralityDTO> getStudentMoralityList(@Param("studentId")String studentId);

    List<CourseHomeWorkStudentDTO> getStudentCourseHomeWork(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    MissionBaseInfoDTO getStudentCourseMissionDetail(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);
    MissionBaseInfoDTO getClassCourseInfo(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    List<StudentCourseCommentDTO> getCourseMissionComment(StudentCourseCommentDTO studentCourseCommentDTO);

    List<String> getStudentIdByClassId(@Param("classId")String classId);

    CourseClassInfoDTO getStudentCourseBaseInfo(@Param("classId")String classId,@Param("courseId")String courseId);

    StudentCourseCommentDTO getStudentCourseCommentByClassCourseId(@Param("classCourseId") String classCourseId,@Param("studentId") String studentId);

    List<StudentDTO> getStudentInfo(StudentDTO studentDTO);

    List<StudentCourseCommentDTO> getTeacherCommentStudentListByStudentId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("studentId") String studentId);

    List<StudentVacationApplyDTO> getTeacherVacationApplyListByStudentId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("studentId") String studentId);

    List<CourseHomeWorkStudentDTO> getCourseStudentHomeWorkListByStudentId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("studentId") String studentId);

    List<StudentCourseCommentDTO> getTeacherCommentStudentListByClassId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("classId") String classId);

    List<StudentVacationApplyDTO> getTeacherVacationApplyListByClassId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("classId") String classId);

    List<CourseHomeWorkStudentDTO> getCourseStudentHomeWorkListByClassId(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize, @Param("classId") String classId);

    List<CourseHomeWorkStudentDTO>getHomeWorkInfo(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);
}
