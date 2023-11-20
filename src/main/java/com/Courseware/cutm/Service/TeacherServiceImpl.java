package com.Courseware.cutm.Service;

import com.Courseware.cutm.ExceptionHandling.ResourceNotFoundException;
import com.Courseware.cutm.model.Teacher;
import com.Courseware.cutm.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherDetailsById(long id) {
        return (Teacher)this.teacherRepository.findById((int) id).orElseThrow(() -> {
            return new ResourceNotFoundException("Teacher", "id", id);
        });
    }

    @Override
    public Teacher updateTeacherDetails(Teacher teacher, long id) {
        Teacher existingTeacher = (Teacher)this.teacherRepository.findById((int) id).orElseThrow(() -> {
            return new ResourceNotFoundException("Teacher", "id", id);
        });
        existingTeacher.setName(teacher.getName());
        existingTeacher.setAddress(teacher.getAddress());
        this.teacherRepository.save(existingTeacher);
        return existingTeacher;
    }

    @Override
    public Teacher deleteTeacherDetails(Teacher teacher, int id) {
        if (!this.teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher", "id", id);
        } else {
            this.teacherRepository.deleteById(id);
            return (Teacher) this.teacherRepository.save(teacher);
        }
    }
}
