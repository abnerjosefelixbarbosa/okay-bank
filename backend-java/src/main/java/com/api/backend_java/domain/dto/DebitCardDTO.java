package com.api.backend_java.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardDTO {
    private String id;
    private String number;
    private LocalDate expirationDate;
    private String cvv;
    private AccountDTO account;
}
