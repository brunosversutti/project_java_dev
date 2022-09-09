package com.dev.project.controller;


import com.dev.project.dto.UserTO;
import com.dev.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserTO save(@RequestBody UserTO dto, HttpServletRequest request) {
        return service.save(dto, request);
    }

    @PutMapping
    public UserTO update(@RequestBody UserTO dto, HttpServletRequest request) {
        return service.update(dto, request);
    }


    @GetMapping
    public List<UserTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id, HttpServletRequest request) {
        service.delete(id, request);
    }


}
