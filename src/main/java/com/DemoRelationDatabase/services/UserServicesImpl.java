package com.DemoRelationDatabase.services;

import com.DemoRelationDatabase.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl {

    private final UserRepository userRepository;

}
