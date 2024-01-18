package com.lesson7.lesson7;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(
        @NotNull
        String name,
        @Min(16)
        @Max(116)
        Integer age
) {
}
