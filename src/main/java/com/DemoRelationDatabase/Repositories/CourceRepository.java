package com.DemoRelationDatabase.Repositories;

import com.DemoRelationDatabase.Entities.CourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourceRepository extends JpaRepository<CourceEntity, Long> {
}
