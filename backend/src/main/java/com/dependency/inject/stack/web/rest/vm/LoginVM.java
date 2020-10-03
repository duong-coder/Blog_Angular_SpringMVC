package com.dependency.inject.stack.web.rest.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * The type Login vm.
 */
@Data
public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String phone;

    private String password;

    private Boolean rememberMe;

}
