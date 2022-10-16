package com.galetedanilo.site.services;

import com.galetedanilo.site.entities.User;
import com.galetedanilo.site.mappers.SignUpMapper;
import com.galetedanilo.site.repositories.UserRepository;
import com.galetedanilo.site.requests.NewAccountRequest;
import com.galetedanilo.site.responses.NewAccountResponse;
import com.galetedanilo.site.enums.SignUpError;
import com.galetedanilo.site.exceptions.SignUpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;

@Service
public class SignUpService implements Serializable, com.galetedanilo.site.interfaces.SignUpService {
    private static final long serialVersionUID = 1L;

    @Autowired
    private final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public NewAccountResponse registerNewAccount(NewAccountRequest newAccountRequest) {
        User user = new User();
        NewAccountResponse newAccountResponse = new NewAccountResponse();

        SignUpMapper.mapperNewAccountRequestToUser(newAccountRequest, user);

        user.setCreatedAt(Instant.now());
        user.setActivated(false);

        this.userEmailExists(newAccountRequest.getEmail());

        user = this.userRepository.save(user);

        SignUpMapper.mapperUserToNewAccountResponse(user, newAccountResponse);

        return newAccountResponse;
    }

    private void userEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new SignUpException("The provided email is already being used by another user: " + email, SignUpError.EMAIL_ALREADY_EXISTS);
        }
    }

}
