package net.javaguides.courseware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.courseware.entity.course;
import net.javaguides.courseware.service.CourseService;

@CrossOrigin("*")
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<course> getcourses(){
		return courseService.readAll();
		}
	
	@PostMapping("/courses")
	public course saveCourse(@RequestBody course co){
		return courseService.saveCourse(co);
	}
	
}
