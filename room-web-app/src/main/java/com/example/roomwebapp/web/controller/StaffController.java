package com.example.roomwebapp.web.controller;


import com.example.roomwebapp.service.StaffService;
import com.example.roomwebapp.web.model.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/protected")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {this.staffService = staffService;}
    @GetMapping("/staff")
    public ResponseEntity<?> getStaff()
    {
        List<Staff> staff = staffService.getAllStaff();
        return ResponseEntity.ok(staff);


    }




}
