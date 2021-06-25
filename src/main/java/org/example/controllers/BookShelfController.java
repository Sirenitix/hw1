package org.example.controllers;


import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.example.services.BookService;
import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/books")
public class BookShelfController{

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;




    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    Integer init = 1;

    @GetMapping("/shelf")
    public String books(Model model) {

        if(init == 1){
            addtorepository();
            init = 0;
        }else{
           //hmm....
        }



        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @GetMapping("/searchresult")
    public String searchitem(Model model) {


        logger.info("findbook equal to:");
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllsearches());

        return "book_shelf";
    }



    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        logger.info("current repository size: " + bookService.getAllBooks().size());
        return "redirect:/books/shelf";
    }


    @PostMapping("/remove")
    public String removeBook(@RequestParam(value = "bookTagToRemove" )  String bookTagToRemove) {

        if (NumberUtils.isCreatable(bookTagToRemove)){
            bookService.removeBookByID(Integer.valueOf(bookTagToRemove));
            return "redirect:/books/shelf";
        }
        else if (true) {
            bookService.removeBookByTag(bookTagToRemove);
            return "redirect:/books/shelf";
        } else {
            return "redirect:book_shelf";
        }
    }

    @PostMapping("/clear")
    public String clear(){
        return "redirect:/books/shelf";
    }

    @PostMapping("/search")
    public String findBook(@RequestParam(value = "findbook" )  String findbook) {

        if(findbook.isEmpty()){
            return "redirect:/books/shelf";
        }

        if (NumberUtils.isCreatable(findbook)){
            bookService.searchItemByID(Integer.valueOf(findbook));


            return "redirect:/books/searchresult";
        }
        if (bookService.searchItem(findbook)) {
            return "redirect:/books/searchresult";
        }

        else {
            return "redirect:/books/searchresult";
        }
    }

    public void addtorepository(){

        Book fbook = new Book();
        fbook.setAuthor("Robert");
        fbook.setTitle("The end");
        fbook.setSize(500);

        bookService.saveBook(fbook);


        Book sbook = new Book();
        sbook.setAuthor("Mickle");
        sbook.setTitle("The beginig");
        sbook.setSize(450);

        bookService.saveBook(sbook);

    }

}


