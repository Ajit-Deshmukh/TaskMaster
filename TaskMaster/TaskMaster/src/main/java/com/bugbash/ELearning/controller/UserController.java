package com.bugbash.ELearning.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugbash.ELearning.model.Users;
import com.bugbash.ELearning.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Users> login(@PathVariable String email, @PathVariable String password) {
        List<Users> users = service.findUser();
        for (Users n : users) {
            if (email.equals(n.getEmail()) && password.equals(n.getPassword())) {
                System.out.println("Valid");
                return new ResponseEntity<>(n, HttpStatus.OK);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/profile/{username}")
    public Users login(@PathVariable String username) {
        List<Users> users = service.findUser();
        for (Users n : users) {
            if (username.equals(n.getName())) {
                System.out.println("Valid");
                return n;
            }
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        List<Users> users = service.findUser();
        for (Users n : users) {
            if (n.getEmail() != null && n.getEmail().equals(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User already exists");
            }
        }

        service.addUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Registration Successful");
    }


    @PostMapping("/forgetpass/{username}/{email}/{newpass}")
    public void forgetpassword(@PathVariable String username, @PathVariable String email, @PathVariable String newpass) {
        List<Users> users = service.findUser();
        System.out.println(username);
        System.out.println(email);
        System.out.println(newpass);
        for (Users n : users) {
            if (username.equals(n.getName()) && email.equals(n.getEmail())) {
                System.out.println("matched");
                service.forget(n, newpass);
            } else {
                System.out.println("unmatched" + ":" + n.getContact() + ":" + n.getName());
            }
        }
    }
}
