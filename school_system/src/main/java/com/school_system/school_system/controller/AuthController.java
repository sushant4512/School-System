package com.school_system.school_system.controller;

import com.school_system.school_system.entities.Attendance;
import com.school_system.school_system.entities.User;
import com.school_system.school_system.model.JwtRequest;
import com.school_system.school_system.model.JwtResponse;
import com.school_system.school_system.security.JwtHelper;
import com.school_system.school_system.service.AttendanceService;
import com.school_system.school_system.service.UserService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    private Logger logger= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AttendanceService attendanceService;



    @PostMapping("/login")
    public ResponseEntity<JwtResponse>login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails=userDetailsService.loadUserByUsername(request.getEmail());
        String token= this.helper.generateToken(userDetails);

        JwtResponse response=JwtResponse.builder()
                .JwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private  void doAuthenticate (String email, String password){
        UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid UserName or Password");
        }


    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return  "Credential Inavalid !!";

    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return userService.creteUser(user);

    }



}
