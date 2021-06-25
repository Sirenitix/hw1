package org.example.repository;

import java.util.List;

public interface ProjectRepository<T>   {
    List<T> retreiveAll();

    List<T> retreiveSrch();

    void store(T book);


    boolean removeItemByTag(String bookTagToRemove);
    boolean removeItemByID(Integer bookIDToRemove);
    boolean searchItem(String findbook);
    boolean searchItemByID(Integer findbook);

}
