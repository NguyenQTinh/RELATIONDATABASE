package com.DemoRelationDatabase.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameUser;

    @OneToMany(mappedBy = "userEntity" )
    private List<RoleEntity> roleEntities;

}

/**

 * */
