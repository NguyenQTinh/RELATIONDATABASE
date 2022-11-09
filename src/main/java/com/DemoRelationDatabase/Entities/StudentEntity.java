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
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameStudent;
    private String ageStudent;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_cource",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "cource_id")}
    )
    private Set<CourceEntity> courceEntitySet = new HashSet<>();
}

/**
 Thêm mơi Student

 Student (1) -- (n) course

 Vd1:
  course: chua co data

 Them moi Student: cu them moi








 * */
