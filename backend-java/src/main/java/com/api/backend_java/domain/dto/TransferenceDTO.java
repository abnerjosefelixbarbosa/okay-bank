package com.api.backend_java.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDTO {
    private String id;
    private LocalDateTime dateTime;
    private BigDecimal valueTransference;
    private AccountDTO account;
    private RecipientDTO recipient;
}