package com.galetedanilo.site.controllers;

import com.galetedanilo.site.requests.NewAccountRequest;
import com.galetedanilo.site.responses.NewAccountResponse;
import com.galetedanilo.site.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/v1/public/signup/registration")
public class SignUpController {
    @Autowired
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @PostMapping
    public ResponseEntity<NewAccountResponse> registerNewAccount(@RequestBody @Valid NewAccountRequest newAccountRequest) {
        NewAccountResponse newAccountResponse = this.signUpService.registerNewAccount(newAccountRequest);

        return new ResponseEntity<>(newAccountResponse, HttpStatus.CREATED);
    }
}
