package com.DemoRelationDatabase.Repositories;

import com.DemoRelationDatabase.Entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByNameRole(String role);
}
