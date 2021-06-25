package org.example.repository;


import org.apache.log4j.Logger;
import org.example.entity.RegisForm;
import org.example.repository.BookRepository;
import org.example.repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo implements ProjectRepository<RegisForm> {
    private final List<RegisForm> userrepo = new ArrayList<>();
    private final Logger logger = Logger.getLogger(BookRepository.class);


    @Override
    public List<RegisForm> retreiveAll() {
        return new ArrayList<>(userrepo);
    }

    @Override
    public List<RegisForm> retreiveSrch() { return null; }

    @Override
    public void store(RegisForm regisForm) {
        userrepo.add(regisForm);
    }

    @Override
    public boolean removeItemByTag(String bookTagToRemove) {
        return false;
    }

    @Override
    public boolean removeItemByID(Integer bookIDToRemove) {
        return false;
    }

    @Override
    public boolean searchItem(String findbook) { return false; }

    @Override
    public boolean searchItemByID(Integer findbook) {
        return false;
    }


}
