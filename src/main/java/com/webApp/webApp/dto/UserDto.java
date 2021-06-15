package com.webApp.webApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String nif;

    private String cardNumber;
}
