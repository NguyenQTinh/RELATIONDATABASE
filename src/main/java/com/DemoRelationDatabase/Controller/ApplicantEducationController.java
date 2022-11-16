package com.DemoRelationDatabase.Controller;

import com.DemoRelationDatabase.Entities.ApplicantEntity;
import com.DemoRelationDatabase.Entities.EducationEntity;
import com.DemoRelationDatabase.dto.ApplicantDto;
import com.DemoRelationDatabase.services.ApplicantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApplicantEducationController {

    private final ApplicantServiceImpl applicantService;

    @PostMapping("/applicant/save")
    public ApplicantEntity saveApplicant(@RequestBody ApplicantDto dto){
        return applicantService.saveApplicant(dto);
    }

    @GetMapping("/applicant/{id}")

    public ApplicantEntity getApplicantId(@PathVariable long id) {
        return applicantService.getApplicantId(id);
    }

    @GetMapping("/applicant/all")
    public List<ApplicantEntity> getAllApplicant() {
        return applicantService.getAllApplicant();
    }

    @GetMapping("/education/{id}")
    public EducationEntity getEducationId(@PathVariable long id) {
        return applicantService.getEducationId(id);
    }

    @GetMapping("/education/all")
    public List<EducationEntity> getAllEducation() {
        return applicantService.getAllEducation();
    }
}
