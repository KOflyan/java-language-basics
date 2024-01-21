package com.lesson7;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StudentDto(
    @NotBlank
    String name,
    @Min(16)
    Integer age
) {}
