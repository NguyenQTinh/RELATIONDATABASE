package com.DemoRelationDatabase.Repositories;

import com.DemoRelationDatabase.Entities.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long> {

    ApplicantEntity findByIdAndName(Long id, String name);

}
