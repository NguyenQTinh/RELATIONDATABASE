package com.DemoRelationDatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<EducationDto> educationDtoList;
}
