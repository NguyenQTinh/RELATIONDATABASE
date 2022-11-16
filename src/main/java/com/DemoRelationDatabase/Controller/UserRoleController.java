package com.DemoRelationDatabase.Controller;

import com.DemoRelationDatabase.Entities.RoleEntity;
import com.DemoRelationDatabase.Entities.UserEntity;
import com.DemoRelationDatabase.Repositories.RoleRepository;
import com.DemoRelationDatabase.Repositories.UserRepository;
import com.DemoRelationDatabase.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @PostMapping("/saveUser")
    public UserEntity saveUser(@RequestBody UserRequestDto user){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setNameUser(user.getNameUser());

        List<RoleEntity> roleEntities = new ArrayList<>();

        user.getRoleNames().forEach(x -> {
            RoleEntity role = new RoleEntity();
            role.setNameRole(x);

            roleRepository.save(role);

            RoleEntity role1 = roleRepository.findById(role.getId()).orElse(null);

            /**lam sao tu thang nay co the set lai duoc vao User
             * Đang có thắc mắc, khi thêm mới thằng Many nó sẽ add vào thằng One
             * Thì Table "Many" sẽ có FK_"One"
             *
             * Thường là sẽ thêm mới thằng Many, rồi sau đó sẽ add vào thằng One
             * Bây giờ ngược lại muốn thêm mới thằng One rồi add vào Many
             * */
            roleEntities.add(role1);
        });
        userEntity.setRoleEntities(roleEntities);


        return userRepository.save(userEntity);


        /** OneToMany
         * Thì nó sẽ ko tự động lưu sang thằng Many
         *  ta sẽ phải tự lưu
         * */

        /** ManyToMany
         *  Nó sẽ tự động lưu sang bảng
         *
         * */

    }

    @PostMapping("/saveRole")
    public RoleEntity saveRole(@RequestBody RoleEntity role){
        System.out.println(role.getNameRole());


        return roleRepository.save(role);
    }

}

/**
 Kết luận với ManyToMany:
    Student (n)--(n) Course:
 Khi ở thêm mới ở thằng Student, ta thêm cả những course ko có thì nó cũng sẽ tự động thêm vào

 Student
 {
    "nameStudent": "student-1",
    "courseSet" : [
        {
            "courseName": "course-1"
         },
        {
            "courseName": "course-2"
        }
    ]
 }

 Khi thêm mới thằng Student thằng courseSet có các course sẽ tự động lưu vào thằng Table Course. Đó là sự khác nhau giữa thằng ManyToMany vs OneToMany

 ==========================================================
 Kết luận với thằng One-To-Many
 User (1)---(n) Role

 {
    "nameUser": "user-1",
    "roleSet" : [
        {
            "roleName": "role-1"
        },
        {
            "roleName": "role-2"
        }
    ]
 }

 Khi thêm mới thằng User: thằng roleSet có các roleName: sẽ ko tự động lưu vào Table Role, mà chúng ta sẽ phải tự lưu vào thằng role



 * */
