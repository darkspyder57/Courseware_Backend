package com.Courseware.cutm.controller;

import com.Courseware.cutm.Service.CourseService;
import com.Courseware.cutm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Course course){
        courseService.saveCourse(course);
        return "New Course is added";
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourseDetails(){
        return courseService.getAllCourseDetail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getAllCoursesById(@PathVariable("id") long Courseid){
        return new ResponseEntity<Course>(courseService.getCourseDetailById(Courseid), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourseDetails(@PathVariable("id") long id, @RequestBody Course course)
    {
        return new ResponseEntity<Course>(courseService.updateCourseDetails(course,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Course> deleteCourseDetails(@PathVariable("id") long id,@RequestBody Course course){
        System.out.println("Course is deleted from the database");
        return new ResponseEntity<Course>(courseService.deleteCourseDetails(course,id),HttpStatus.OK);
    }
}
