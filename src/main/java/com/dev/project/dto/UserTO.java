package com.dev.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserTO {
    private Long id;
    private String name;
    private String email;
}
