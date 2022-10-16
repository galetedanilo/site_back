package com.galetedanilo.site.mappers;

import com.galetedanilo.site.entities.User;
import com.galetedanilo.site.requests.NewAccountRequest;
import com.galetedanilo.site.responses.NewAccountResponse;

public class SignUpMapper {

    public static void mapperUserToNewAccountResponse(User user, NewAccountResponse newAccountResponse) {
        newAccountResponse.setId(user.getId());
        newAccountResponse.setName(user.getName());
        newAccountResponse.setEmail(user.getEmail());
    }

    public static void mapperNewAccountRequestToUser(NewAccountRequest newAccountRequest, User user) {
        user.setName(newAccountRequest.getName());
        user.setEmail(newAccountRequest.getEmail());
        user.setPassword(newAccountRequest.getPassword());
    }

}
