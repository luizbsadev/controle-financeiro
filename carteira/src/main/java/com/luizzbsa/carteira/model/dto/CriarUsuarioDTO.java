package com.luizzbsa.carteira.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarUsuarioDTO(
        @Email
        @NotNull
        String email,

        @Size(min = 6)
        @NotNull
        String senha) {
}
