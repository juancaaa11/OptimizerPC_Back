package com.example.optimizerpc.controllers.User;

import com.example.optimizerpc.models.adapters.User.UserAdapter;
import com.example.optimizerpc.models.dtos.User.UserCreateDTO;
import com.example.optimizerpc.models.dtos.User.UserDTO;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.mappers.User.UserMapper;
import com.example.optimizerpc.models.services.User.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Tag(name = "User API")
@RequestMapping("/v0")
public class UserCommandController {

    private final IUserService userService;
    private final UserAdapter userAdapter;
    private final UserMapper mapper;

    public UserCommandController(IUserService userService, UserAdapter userAdapter, UserMapper mapper) {
        this.userService = userService;
        this.userAdapter = userAdapter;
        this.mapper = mapper;
    }

    @PutMapping("/user")
    @Operation(summary = "Create a new user" , description = "Create a new user")
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO request){

        UserDTO user = mapper.mapDTO(userAdapter.create(request));

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    @Operation(summary = "Delete an user.", description = "Delete an user.")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")String id){

        User user = userService.findById(id);

        userService.delete(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
