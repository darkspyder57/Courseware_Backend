package net.javaguides.courseware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.courseware.entity.course;

public interface CourseRepository extends JpaRepository<course, Long> {

}
