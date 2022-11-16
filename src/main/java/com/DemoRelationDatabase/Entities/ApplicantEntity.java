package com.DemoRelationDatabase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applicant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    private String password;


    @OneToMany(mappedBy = "applicant")
    private List<EducationEntity> educationEntities;
}
