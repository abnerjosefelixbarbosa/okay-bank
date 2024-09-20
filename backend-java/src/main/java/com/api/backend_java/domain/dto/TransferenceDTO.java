package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenceDTO {
    private String id;
    private LocalDateTime dateTime;
    private BigDecimal valueTransference;
    private AccountDTO account;
    private RecipientDTO recipient;
}