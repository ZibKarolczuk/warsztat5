package pl.coderslab.warsztat5.service;

import org.springframework.stereotype.Service;
import pl.coderslab.warsztat5.model.Book;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class MemoryBookService {

    private List<Book> list;

    public MemoryBookService() {

        list = new ArrayList<>();

        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void deleteBook(long id) {
        Iterator<Book> itBook = this.list.iterator();
        while (itBook.hasNext()){
            Book b = itBook.next();
            if(b.getId() == id){
                itBook.remove();
                break;
            }
        }
    }

    public void addBook(Book book){
        this.list.add(book);
    }


    public List<Long> listAllID(){
        List<Long> result = new ArrayList<>();
        for (Book book: list) {
            result.add(book.getId());
        }
        Collections.sort(result);
        return  result;
    }

}
