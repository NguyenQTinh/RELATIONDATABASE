package com.DemoRelationDatabase.Repositories;

import com.DemoRelationDatabase.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends JpaRepository<StudentEntity, Long> {
}
