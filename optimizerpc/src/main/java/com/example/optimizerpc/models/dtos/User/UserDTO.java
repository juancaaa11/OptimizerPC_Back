package com.example.optimizerpc.models.dtos.User;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name ;

    private String firstLastName;

    private String secondLastName;

    private String email;

    private String username ;

    private String phone ;

    private String address;
}
