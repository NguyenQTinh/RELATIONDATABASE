package com.DemoRelationDatabase.Controller;

import com.DemoRelationDatabase.Entities.CourceEntity;
import com.DemoRelationDatabase.Entities.StudentEntity;
import com.DemoRelationDatabase.Repositories.CourceRepository;
import com.DemoRelationDatabase.Repositories.StudentRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentCourceController {

    private final StudentRepositories studentRepositories;
    private final CourceRepository courceRepository;

    @PostMapping("/save/student")
    public StudentEntity saveStudent(@RequestBody StudentEntity student) {
        System.out.println(student.getCourceEntitySet());
        return studentRepositories.save(student);
    }

    @PostMapping("/save/cource")
    public CourceEntity saveCource(@RequestBody CourceEntity cource) {
        return courceRepository.save(cource);
    }

    @GetMapping("/findcource/{id}")
    public CourceEntity findCourseId(@PathVariable Long id){
        return courceRepository.findById(id).orElse(null);
    }

    @GetMapping("/findstudent/{id}")
    public StudentEntity findStudentId(@PathVariable Long id){
        return studentRepositories.findById(id).orElse(null);
    }
}

