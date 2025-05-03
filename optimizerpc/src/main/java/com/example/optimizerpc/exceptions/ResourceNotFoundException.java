package com.example.optimizerpc.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@Setter
@Builder
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    @Builder.Default
    private String resourceName = "";

    @Builder.Default
    private String fieldName = "";

    @Builder.Default
    private String fieldValue = "";

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s was not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
