package com.luizzbsa.carteira.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginDto(
        @Email
        @NotNull
        String email,
        @NotNull
        String senha) {
}
