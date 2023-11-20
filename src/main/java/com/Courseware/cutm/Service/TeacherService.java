package com.Courseware.cutm.Service;

import com.Courseware.cutm.model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public List<Teacher> getAllTeachers();
    public Teacher getTeacherDetailsById(long id);

    public Teacher updateTeacherDetails(Teacher teacher,long id);

    public Teacher deleteTeacherDetails(Teacher teacher, int id);
}
