package de.max.letterboard.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class ApiError {
    private String exception;
    private String message;
}
