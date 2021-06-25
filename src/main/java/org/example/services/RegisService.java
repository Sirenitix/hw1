package org.example.services;


import org.example.entity.RegisForm;
import org.example.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisService {


        private final ProjectRepository<RegisForm> userRepo;



        @Autowired
        public RegisService(ProjectRepository<RegisForm> userRepo) {
            this.userRepo = userRepo;
        }

        public List<RegisForm> getAllUsers() {
            return userRepo.retreiveAll();
        }

        public void saveUser(RegisForm regisForm) {
            userRepo.store(regisForm);
        }




    }
