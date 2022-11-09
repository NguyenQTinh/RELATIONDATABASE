package com.DemoRelationDatabase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSource;
    private String priceSource;

    @ManyToMany(mappedBy = "courceEntitySet", fetch = FetchType.LAZY)
    private Set<StudentEntity> studentEntitySet = new HashSet<>();
}
