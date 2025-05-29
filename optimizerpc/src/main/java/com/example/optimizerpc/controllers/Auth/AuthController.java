package com.example.optimizerpc.controllers.Auth;

import com.example.optimizerpc.models.dtos.AuthRequest;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.services.Auth.JwtService;
import com.example.optimizerpc.models.services.User.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v0")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final IUserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, IUserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = jwtService.generateToken(authentication);

            Optional<User> user = userService.findByUsername(authentication.getName());

            return user.<ResponseEntity<?>>map(value -> ResponseEntity.ok(Map.of(
                    "token", token,
                    "username", authentication.getName(),
                    "id", value.getId()
            ))).orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Usuario no encontrado tras autenticación")));

        } catch (BadCredentialsException ex) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Usuario o contraseña incorrectos"));
        }
    }

    @GetMapping("/auth/check")
    public ResponseEntity<?> checkAuth(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).body(Map.of("authenticated", false));
        }

        return ResponseEntity.ok(Map.of("authenticated", true));
    }

}
