package org.example.repository;

import org.apache.log4j.Logger;
import org.example.entity.Book;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;



@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private List<Book> srchrepp  = new ArrayList<>();
    private List<Book> emptyrepo = new ArrayList<>();






    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public List<Book> retreiveSrch() {
        return new ArrayList<>(srchrepp);
    }




    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        if(!StringUtils.isEmpty(book.getAuthor())  || !StringUtils.isEmpty(book.getTitle()) || book.getSize() != null)

        {
            repo.add(book);
            logger.info("Done(Title): "+ book.getTitle());
        }

    }




    @Override
    public boolean removeItemByTag(String bookTagToRemove) {

        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(bookTagToRemove) || book.getAuthor().equals(bookTagToRemove)) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
            }
        }
        return true;
    }

    @Override
    public boolean removeItemByID(Integer bookIDToRemove) {
        logger.info("bookIDToRemove: "+bookIDToRemove);
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIDToRemove) || book.getSize().equals(bookIDToRemove)) {
                logger.info("remove book completed: " + book);
                repo.remove(book);
            }
        }
        return true;
    }

    @Override
    public boolean searchItem(String findbook) {
        int bookcounter = 0;
        srchrepp = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(findbook) || book.getAuthor().equals(findbook)) {
                bookcounter++;
                logger.info("book is found: " + book);
                if ((srchrepp.isEmpty())) {
                    logger.info("new repo: " + srchrepp.add(book));
                }
                else if (bookcounter == 1)
                {
                    srchrepp = new ArrayList<>();
                    logger.info("new repo: " + srchrepp.add(book));
                }
                else if(bookcounter <= 2){
                    logger.info("new repo: " + srchrepp.add(book));
                }



            }
        }
        return true;
    }



    @Override
    public boolean searchItemByID(Integer findbook) {
        int bookcounter = 0;
        logger.info("book find by id: "+ findbook);
        srchrepp = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (book.getId().equals(findbook) || book.getSize().equals(findbook)) {
                bookcounter++;
                logger.info("book is found: " + book);
                if (srchrepp.isEmpty()) {
                    logger.info("new repo: " + srchrepp.add(book));
                }
                else if(bookcounter == 1)
                {
                    srchrepp = new ArrayList<>();
                    logger.info("new repo: " + srchrepp.add(book));
                }
                else if(bookcounter <= 2){
                    logger.info("new repo: " + srchrepp.add(book));
                }




            }
        }
        return true;
    }


}
