package com.api.backend_java.domain.dto;

import java.time.LocalDate;

public record DebitCardDTO(
        String id,
        String number,
        LocalDate expirationDate,
        String cvv,
        AccountDTO account
) {
}
