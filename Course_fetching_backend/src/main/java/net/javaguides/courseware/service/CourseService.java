package net.javaguides.courseware.service;

import java.util.List;

import net.javaguides.courseware.entity.course;

public interface CourseService {
	
	List<course> readAll();
	course saveCourse(course co);

}
