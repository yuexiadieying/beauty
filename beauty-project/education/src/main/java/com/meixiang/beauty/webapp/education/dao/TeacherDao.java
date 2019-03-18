package com.meixiang.beauty.webapp.education.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.education.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by sunxiao on 2018/6/20.
 */
@MyBatisDao
@Repository
public interface TeacherDao {

    List<ClassInfoDTO> getTeacherClassList(@Param("teacherId") String teacherId);

    List<CourseInfoDTO> getTeacherCourseTableList(@Param("teacherId")String teacherId, @Param("week")Integer week);

    SchoolDTO getSchoolInfo(@Param("teacherId") String teacherId);

    void saveTeacherCourseComment(StudentCourseCommentDTO studentCourseCommentDTO);

    List<StudentCourseCommentDTO> getTeacherCommentStudentList(String classId,String courseId,String teacherId);

    List<TeacherMissionDTO> getTeacherHomePageMissionList(@Param("teacherId") String teacherId);

    CourseHomeWorkStudentDTO getTeacherCourseMissionDetail(@Param("missionId")String missionId,@Param("studentId")String studentId);

    List<CourseHomeWorkStudentDTO> getTeacherCourseMissionList(@Param("missionId") String missionId);

    void saveSysHomework(CourseHomeWorkStudentDTO missionBaseInfoDTO);

    void saveTeacherHomeworkRel(CourseHomeWorkStudentDTO studentCourseMissionDTO);

    StudentCourseCommentDTO getCourseMissionComment(CourseHomeWorkStudentDTO studentCourseMissionDTO);

    List<CourseHomeWorkStudentDTO> getTeacherCourseMissionHistoryList(CourseHomeWorkStudentDTO studentCourseMissionDTO);

    List<CourseClassInfoDTO> getCoursePrepareList(@Param("teacherId") String teacherId);

    void saveTeacherMoralStudent(StudentMoralityDTO studentMoralityDTO);

    List<TeacherDTO> getTeacherInfo(TeacherDTO teacherDTO);

    List<StudentVacationApplyDTO> getTeacherVacationApplyList(@Param("teacherId") String teacherId, @Param("vacationStatus") String status);

    void processVacationApply(@Param("vacationId") String vacationId, @Param("status") String status);

    List<StudentDTO> getStudentListByClassId(@Param("classId") String classId);

    void createHomeWork(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    void createStudentHomeRelBatch(List<CourseHomeWorkStudentDTO> courseHomeWorkStudentDTOList);

    List<StudentCourseCommentDTO> getTeacherDiscussStudentList(@Param("classId") String classId,
                                                                @Param("courseId") String courseId,
                                                                @Param("weekIndex") String weekIndex,
                                                                @Param("teacherId") String teacherId);

    String getClassCourseRelId(@Param("teacherId") String teacherId,
                               @Param("classId") String classId,
                               @Param("courseId") String courseId,
                               @Param("weekIndex") String weekIndex);

    void saveTeacherHomeWorkComment(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    void saveTeacherHomeWorkStatus(CourseHomeWorkStudentDTO courseHomeWorkStudentDTO);

    List<StudentCourseCommentDTO> getTeacherCommentStudentListByTeacherId(@Param("pageNo") int pageNo,
                                                                          @Param("pageSize") int pageSize,
                                                                          @Param("teacherId") String teacherId);


    List<StudentVacationApplyDTO> getTeacherVacationApplyListByTeacherId(@Param("pageNo") int pageNo,
                                                                         @Param("pageSize") int pageSize,
                                                                         @Param("teacherId") String teacherId);


    List<CourseHomeWorkStudentDTO> getCourseStudentHomeWorkListByTeacherId(@Param("pageNo") int pageNo,
                                                                           @Param("pageSize") int pageSize,
                                                                           @Param("teacherId") String teacherId);

}
