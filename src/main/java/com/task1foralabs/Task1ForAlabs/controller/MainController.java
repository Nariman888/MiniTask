package com.task1foralabs.Task1ForAlabs.controller;

import com.task1foralabs.Task1ForAlabs.entity.Role;
import com.task1foralabs.Task1ForAlabs.entity.Users;
import com.task1foralabs.Task1ForAlabs.service.RoleService;
import com.task1foralabs.Task1ForAlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/")
    public String home(Model model){
        return "home";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/adminpage")
    public String admin(){
        return "adminpage";
    }
    @PreAuthorize("hasAnyRole('ROLE_CANDIDATE')")
    @GetMapping(value = "/candidate")
    public String candidate(){
        return "candidate";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    @GetMapping(value = "/hrpage")
    public String hr(){
        return "HRpage";
    }

    @GetMapping(value = "/signup")
    public String signup(Model model) {
        return "signup";
    }
    @PostMapping(value = "/signup")
    public String signup(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_re_password") String rePassword,
                         @RequestParam(name = "user_full_name") String fullName) {
        List<Role> roles = new ArrayList<>();
        Role role = roleService.addRole("ROLE_CANDIDATE");
        roles.add(role);
        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setRoles(roles);
        if (userService.addUser(user, rePassword) != null) {
            return "redirect:/login";
        }
        return "redirect:signup?error";
    }
}
