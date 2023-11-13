package com.Courseware.cutm.Service;

import com.Courseware.cutm.model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public List<Teacher> getAllTeachers();
}
