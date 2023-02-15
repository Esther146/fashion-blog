package com.esther.fashion_ecommerce.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Enter your firstname")
    private String firstname;
    @NotBlank(message = "Enter your lastname")
    private  String lastname;
    @Email(message = "Add a valid email")
    private String email;

    @Size(min = 4, max = 8)
    private String password;

    @Size(max = 13)
    private String phoneNumber;

}
