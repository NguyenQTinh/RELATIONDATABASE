package com.DemoRelationDatabase.services;

import com.DemoRelationDatabase.Entities.ApplicantEntity;
import com.DemoRelationDatabase.Entities.EducationEntity;
import com.DemoRelationDatabase.Repositories.ApplicantRepository;
import com.DemoRelationDatabase.Repositories.EducationRepository;
import com.DemoRelationDatabase.dto.ApplicantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl {
    private final ApplicantRepository applicantRepository;
    private final EducationRepository educationRepository;


    @Transactional
    public ApplicantEntity saveApplicant(ApplicantDto dto) {
        ApplicantEntity saved = new ApplicantEntity();

        ApplicantEntity newApplicant = new ApplicantEntity();
        ApplicantEntity currentApplicant = new ApplicantEntity();
        Long id = dto.getId();

        if (id == null) {
            //TODO: CREATE
            newApplicant.setName(dto.getName());
            newApplicant.setEmail(dto.getEmail());
            newApplicant.setPassword(dto.getPassword());

            saved = applicantRepository.save(newApplicant);
        } else {
            //TODO: UPDATE

            ApplicantEntity a1 = applicantRepository.findById(id).orElse(null);

            currentApplicant.setId(dto.getId());
            currentApplicant.setName(dto.getName());
            currentApplicant.setEmail(dto.getEmail());
            currentApplicant.setPassword(dto.getPassword());

            //TODO: Create Education with id_Applicant
            List<EducationEntity> educationEntityList = new ArrayList<>();

            dto.getEducationDtoList().forEach(x -> {
                EducationEntity education = new EducationEntity();
                education.setName(x.getName());
                education.setApplicant(a1);// case id_applicant: has already in database

                educationRepository.save(education);

                educationEntityList.add(education);
            });
            currentApplicant.setEducationEntities(educationEntityList);

            saved = applicantRepository.save(currentApplicant);
        }
        return saved;
    }


    public ApplicantEntity getApplicantId(Long id) {
        return applicantRepository.findById(id).orElse(null);
    }

    public List<ApplicantEntity> getAllApplicant() {
        return applicantRepository.findAll();
    }

    public EducationEntity getEducationId(Long id) {
        return educationRepository.findById(id).orElse(null);
    }


    public List<EducationEntity> getAllEducation() {
        return educationRepository.findAll();
    }
}
