package com.api.backend_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferenceDTO(
        String id,
        LocalDateTime dateTime,
        BigDecimal valueTransference,
        AccountDTO account,
        RecipientDTO recipient
) {
}