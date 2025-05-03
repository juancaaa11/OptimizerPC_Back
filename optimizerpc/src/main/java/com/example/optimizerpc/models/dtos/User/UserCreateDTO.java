package com.example.optimizerpc.models.dtos.User;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    @NotNull
    private String name;

    @NotNull
    private String firstLastName;

    private String secondLastName;

    @NotNull
    private String email;

    @NotNull
    private String username;

    private String phone;

    @NotNull
    private String address;

    @NotNull
    private String password;
}
