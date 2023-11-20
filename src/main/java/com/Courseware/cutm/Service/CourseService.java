package com.Courseware.cutm.Service;

import com.Courseware.cutm.model.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getAllCourseDetail();

    Course getCourseDetailById(long id);

    Course updateCourseDetails(Course course, long id);

    Course deleteCourseDetails(Course course, long id);
}
