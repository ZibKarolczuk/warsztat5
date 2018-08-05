package pl.coderslab.warsztat5.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztat5.model.Book;
import pl.coderslab.warsztat5.service.MemoryBookService;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService mbs;


    @GetMapping("/hello")
    public String hello(){
        return "{msg: hello}";
    }


    @GetMapping("/hellobook")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming" );
    }


    @GetMapping("")
    public List<Book> bookList(){
        return this.mbs.getList();
    }


    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable long id){
        this.mbs.deleteBook(id);
        return "{\"status\" : \"ok\"}";
    }


    @PostMapping("/add")
    public String doSomething(@RequestBody Book book) {
        this.mbs.addBook(book);
        return "{\"status\" : \"ok\"}";
    }


    @GetMapping("/IDs")
    public List<Long> listAllId(){
        return this.mbs.listAllID();
    }


}
