package book.store.controller;

import book.store.model.authorModel;
import book.store.service.authorService;
import book.store.service.bookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/${author.url}")
@Slf4j
@SuppressWarnings("all")
public class authorController {

    @Autowired
    private authorService authorService;

    @Autowired
    private bookService bookService;

    Map<String, Object> response = new HashMap<>();


    @PostMapping("/book/{bookId}")
    public ResponseEntity<?> saveAuthors(@PathVariable(value = "bookId") Integer bookId, @RequestBody @Valid authorModel authorModel) {
        authorService.saveBookAuthor(authorModel, bookId);
        response.put("list", authorModel);
        return ResponseEntity.ok().body(response);
    }

}
