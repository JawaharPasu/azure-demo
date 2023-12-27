package com.jawa.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {

    @NotNull
    @NotEmpty
    private String courseName;
    @NotNull
    @NotEmpty
    private String instructor;
    @NotNull
    @NotEmpty
    @Email
    private String email;
}
