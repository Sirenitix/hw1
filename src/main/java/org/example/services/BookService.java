package org.example.services;

import org.example.entity.Book;
import org.example.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class BookService  {

    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(LoginService.class);


    @Autowired
    public BookService(@Qualifier("bookRepository") ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public List<Book> getAllsearches(){
        logger.info("so bookRepoSrch contein the next:" + bookRepo.retreiveAll());
        return bookRepo.retreiveSrch();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookByTag(String bookTagToRemove) { return bookRepo.removeItemByTag(bookTagToRemove);
    }

    public boolean removeBookByID(Integer bookIDToRemove) {  return bookRepo.removeItemByID(bookIDToRemove); }

    public boolean searchItem(String findbook) {return bookRepo.searchItem(findbook);}

    public boolean searchItemByID(Integer findbook) {return bookRepo.searchItemByID(findbook);}


}
