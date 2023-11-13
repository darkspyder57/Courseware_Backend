package net.javaguides.courseware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.courseware.entity.course;
import net.javaguides.courseware.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<course> readAll(){
		
		return courseRepository.findAll();
	}

	@Override
	public course saveCourse(course co) {
		
		return courseRepository.save(co);
	}

}
