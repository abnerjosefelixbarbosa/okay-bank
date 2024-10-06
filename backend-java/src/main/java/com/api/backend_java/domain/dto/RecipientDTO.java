package com.api.backend_java.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDTO {
    private String id;
    private String name;
    private String account;
    private String agency;
    private String bank;
}
