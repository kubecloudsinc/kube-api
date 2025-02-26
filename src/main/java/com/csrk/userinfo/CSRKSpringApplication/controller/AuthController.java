package com.csrk.userinfo.CSRKSpringApplication.controller;

import com.csrk.userinfo.CSRKSpringApplication.entity.Employees;
import com.csrk.userinfo.CSRKSpringApplication.entity.User;
import com.csrk.userinfo.CSRKSpringApplication.service.EmployeesService;
import com.csrk.userinfo.CSRKSpringApplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent() && passwordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            // Send email with reset link (implementation not shown)
            return ResponseEntity.ok("Password reset link sent");
        } else {
            return ResponseEntity.status(404).body("Email not found");
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody User user, @RequestParam String newPassword) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            userService.updatePassword(existingUser.get(), newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employees>> getAllEmployees(
            @PageableDefault(sort = {"lastName"}, direction = Sort.Direction.ASC) Pageable pageable) {
        logger.debug("Fetching all employees with pagination and sorting");
        Page<Employees> employees = employeesService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }
}
