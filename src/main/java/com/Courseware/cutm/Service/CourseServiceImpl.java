package com.Courseware.cutm.Service;


import com.Courseware.cutm.ExceptionHandling.ResourceNotFoundException;
import com.Courseware.cutm.model.Course;
import com.Courseware.cutm.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourseDetail() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseDetailById(long id) {
        return (Course) this.courseRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Course", "id", id);
        });
    }

    @Override
    public Course updateCourseDetails(Course course, long id) {
        Course existingCourse = (Course)this.courseRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Course", "id", id);
        });
        existingCourse.setCoursename(course.getCoursename());
        existingCourse.setCoursecategory(course.getCoursecategory());
        return existingCourse;
    }

    @Override
    public Course deleteCourseDetails(Course course, long id) {
        if (!this.courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course", "id", id);
        } else {
            this.courseRepository.deleteById(id);
            return (Course) this.courseRepository.save(course);
        }
    }
}
