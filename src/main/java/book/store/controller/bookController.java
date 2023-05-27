package book.store.controller;

import book.store.model.bookModel;
import book.store.service.bookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@Slf4j
@RequestMapping(value = "/book")
@SuppressWarnings("all")
public class bookController {

    Map<String, Object> response = new HashMap<>();

    @Autowired
    private bookService bookService;

    @GetMapping("/view/{bookId}")
    private Optional<bookModel> getSingleBook(@PathVariable(value = "bookId") Integer bookId) {
        return bookService.viewSingleBook(bookId);

    }

    @PostMapping("/single/savebook")
    private ResponseEntity<?> saveBook(@RequestBody @Valid bookModel bookModel) {
        bookService.saveSingleBook(bookModel);
        response.put("single book", bookModel);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/multiple/saveebook")
    private ResponseEntity<List<bookModel>> saveMultipleBook(@RequestBody @Valid List<bookModel> bookModel) {
        bookService.saveMultipleBooks(bookModel);
        return ResponseEntity.ok().body(bookModel);
    }

    @DeleteMapping("/delete/{bookId}")
    private ResponseEntity<?> deleteBook(@PathVariable(value = "bookId") Integer bookId) {
        bookService.deleteSingleBook(bookId);
        return ResponseEntity.ok().body("Successfully deleted" + " " + bookId);
    }

    @PutMapping("/update/{bookId}")
    private ResponseEntity<?> updateSingleBook(@PathVariable(value = "bookId") Integer bookId, @RequestBody @Valid bookModel bookModel) {
        bookService.updateBookDescription(bookModel, bookId);
        response.put("update Book Sucessfully", bookId);
        return ResponseEntity.ok().body(response);
    }


}
