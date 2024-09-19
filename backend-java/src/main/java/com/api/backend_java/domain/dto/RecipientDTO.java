package com.api.backend_java.domain.dto;

public record RecipientDTO(
        String id,
        String name,
        String account,
        String agency,
        String bank
) {
}
