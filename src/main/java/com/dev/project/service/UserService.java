package com.dev.project.service;

import com.dev.project.exception.ResourceNotFoundException;
import com.dev.project.repository.UserRepository;
import com.dev.project.convertions.AbstractConversion;
import com.dev.project.domain.User;
import com.dev.project.dto.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private AbstractConversion conversion;

    @Autowired
    private  UserRepository repository;
    public UserTO save(UserTO dto, HttpServletRequest request) {
        User user = (User) conversion.convert(dto, new User());
        UserTO response = (UserTO) conversion.convert(repository.save(user), new UserTO());
        return response;
    }
    public void delete(Long id, HttpServletRequest request) {
        repository.deleteById(id);
    }


    public List<UserTO> getAll() {
        return (List<UserTO>) conversion.convertList(repository.findAll(), new ArrayList<UserTO>(), "com.dev.project.dto.UserTO");
    }

    public UserTO getById(Long id) {
        return (UserTO) conversion.convert(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found.")), new UserTO());
    }
    public UserTO update(UserTO dto, HttpServletRequest request) {
        User user = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        user = (User) conversion.convert(dto, user);

        return (UserTO) conversion.convert(repository.save(user), new UserTO());
    }




}
