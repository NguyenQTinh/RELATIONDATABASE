package com.DemoRelationDatabase.dto;


import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDto {
    private Long id;

    private String nameUser;

    private Set<String> roleNames;
}
