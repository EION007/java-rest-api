package com.eion.restapi.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CommentDto {
    private long id;


    @NotEmpty(message = "name should not be null or empty")
    @Size(min = 4, message = "name should be greater than 4 characters")
    private String name;

    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Comment body should not be null or empty")
    @Size(min = 10, message = "Comment body should be greater than 10 characters")
    private String body;
}
