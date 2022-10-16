package com.galetedanilo.site.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class NewAccountRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "User name is required")
    @Size(min = 5, max = 40, message = "User name  must be between 5 to 40 characters")
    private String name;
    @NotBlank(message = "User email is required")
    @Email(message = "User email is not valid")
    @Size(min = 5, max = 40, message = "User email must be between 5 to 40 characters")
    private String email;
    @NotBlank(message = "User password is required")
    @Size(min = 5, max = 15, message = "User password must be between 5 to 15 characters")
    private String password;

    public NewAccountRequest() {}

    public NewAccountRequest(String name, String email, String password) {
        this.name = name;
        this. email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
