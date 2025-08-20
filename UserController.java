package com.example.Library_system.Controller;


import com.example.Library_system.DTO.UserDTO;
import com.example.Library_system.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    {
    }

    @GetMapping
    public List<UserDTO> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) { return userService.getById(id); }
}