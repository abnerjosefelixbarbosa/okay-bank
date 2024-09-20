package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardDTO {
    private String id;
    private String number;
    private LocalDate expirationDate;
    private String cvv;
    private AccountDTO account;
}
