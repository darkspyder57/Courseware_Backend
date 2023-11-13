package com.Courseware.cutm.controller;


import com.Courseware.cutm.Service.LoginService;
import com.Courseware.cutm.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Login> saveLogin(@RequestBody Login login){
        return new ResponseEntity<Login>(loginService.saveLogin(login), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Login> getAllLoginDetails(){
        return loginService.getAllLoginDetail();
    }

    @GetMapping("{id}")
    public ResponseEntity<Login> getLoginDetailById(@PathVariable("id") long LoginId){
        return new ResponseEntity<Login>(loginService.getLoginDetailById(LoginId),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Login> updateLoginDetails(@PathVariable("id") long id,@RequestBody Login loginCourseware)
    {
        return new ResponseEntity<Login>(loginService.updateLoginDetails(loginCourseware,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Login> deleteLoginDetails(@PathVariable("id") long id,@RequestBody Login login){
        return new ResponseEntity<Login>(loginService.deleteLoginDetails(login,id),HttpStatus.OK);
    }
}
