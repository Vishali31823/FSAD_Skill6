package klu.Skill_6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome";
    }

    @GetMapping("/count")
    public int Count() {
        return 70;
    }

    @GetMapping("/price")
    public double price() {
        return 140.00;
    }

    @GetMapping("/books")
    public List<String> displayBooks() {
        return List.of("Java","Spring Boot","Python");
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int bid) {
        for(Book b : bookList) {
            if(b.getId() == bid) {
                return b;
            }
        }
        return null;
    }
    @GetMapping("/search")
    public Book searchBook(@RequestParam("title") String t) {
    	for(Book b:bookList) {
    		if(b.getTitle().equalsIgnoreCase(t)) {
    			return b;
    		}
    	}
    	return null;
    }

    @GetMapping("/author/{name}")
    public Book authorName(@PathVariable("name") String a) {

        for(Book b : bookList) {
            if(b.getAuthor().equalsIgnoreCase(a)) {
                return b;
            }
        }

        return null;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book b) {
        bookList.add(b);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }

}