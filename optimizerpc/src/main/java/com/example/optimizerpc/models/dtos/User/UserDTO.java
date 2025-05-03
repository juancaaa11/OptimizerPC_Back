package com.example.optimizerpc.models.dtos.User;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String firstLastName = "";

    @Builder.Default
    private String secondLastName = "";

    @Builder.Default
    private String email = "";

    @Builder.Default
    private String username = "";

    @Builder.Default
    private String phone = "";

    @Builder.Default
    private String address = "";
}
