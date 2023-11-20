package com.Courseware.cutm.controller;

import com.Courseware.cutm.Service.TeacherService;
import com.Courseware.cutm.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "New Teacher is added";
    }

    @GetMapping("/getAll")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getAllTeachersById(@PathVariable("id") long Teacherid){
        return new ResponseEntity<Teacher>(teacherService.getTeacherDetailsById(Teacherid), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacherDetails(@PathVariable("id") long id, @RequestBody Teacher teacher)
    {
        return new ResponseEntity<Teacher>(teacherService.updateTeacherDetails(teacher,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Teacher> deleteTeacherDetails(@PathVariable("id") long id,@RequestBody Teacher teacher){
        return new ResponseEntity<Teacher>(teacherService.deleteTeacherDetails(teacher, (int) id),HttpStatus.OK);
    }

}
