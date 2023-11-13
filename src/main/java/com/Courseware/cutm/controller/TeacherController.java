package com.Courseware.cutm.controller;

import com.Courseware.cutm.Service.TeacherService;
import com.Courseware.cutm.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "New Teacher is added";
    }

    @GetMapping("/getAll")
    public List<Teacher> getAllStudents(){
        return teacherService.getAllTeachers();
    }
}
