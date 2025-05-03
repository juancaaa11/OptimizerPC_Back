package com.example.optimizerpc.models.entities.User;

import com.github.ksuid.Ksuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Builder.Default
    @Column(nullable = false, updatable = false, unique = true, length = 60)
    private String id = "user_" + Ksuid.newKsuid().toString();

    @Builder.Default
    @NotNull
    private String name = "";

    @Builder.Default
    @NotNull
    private String firstLastName = "";

    @Builder.Default
    private String secondLastName = "";

    @Builder.Default
    @NotNull
    private String email = "";

    @Builder.Default
    @NotNull
    private String username = "";

    @Builder.Default
    private String phone = "";

    @Builder.Default
    @NotNull
    private String address = "";

    @Column(nullable = false)
    private String password;

}
