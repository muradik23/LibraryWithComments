package web.and.mobile.midterm.library.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.and.mobile.midterm.library.controller.BooksWS;
import web.and.mobile.midterm.library.model.entity.Books;
import web.and.mobile.midterm.library.model.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class BooksWSImpl implements BooksWS {

    @Autowired
    private BooksService booksService;



    @Override
    @RequestMapping(value = "/searchByName", method = RequestMethod.GET)

    public ResponseEntity ByName(@RequestParam("book") String name) {
        return ResponseEntity.ok(booksService.byName(name));
    }

    @Override
    @RequestMapping(value = "/searchByCategory", method = RequestMethod.GET)

    public ResponseEntity ByCategory(@RequestParam("category") String category) {

        return ResponseEntity.ok(booksService.byCategory(category));
    }

    @Override
    @RequestMapping(value = "/bookByAuthor", method = RequestMethod.GET)

    public ResponseEntity ByAuthor(@RequestParam("author") String author) {

        return ResponseEntity.ok(booksService.byAuthor(author));
    }

    @Override
    @RequestMapping(value = "/list", method = RequestMethod.GET)

    public ResponseEntity listOfBooks() {
        return ResponseEntity.ok(booksService.allBooks());
    }

    @Override
    @PostMapping("/comment/{studentid}/{bookid}/{content}")
    @ResponseBody

    public ResponseEntity comment(@PathVariable("studentid") Integer studentId, @PathVariable("bookid") Integer bookId, @PathVariable("content") String content) {
        Integer result = booksService.comment(studentId, bookId, content);
        return result == 1 ? new ResponseEntity("Commented successfully", HttpStatus.OK)
                : new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/{bookid}")
    @ResponseBody

    public ResponseEntity getBookById(@PathVariable("bookid") Integer bookId) {
        Books books = booksService.findBookById(bookId);
        return books == null ? new ResponseEntity("Error", HttpStatus.BAD_REQUEST)
                : new ResponseEntity(books, HttpStatus.BAD_REQUEST);
    }
}
