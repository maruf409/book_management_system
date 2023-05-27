package book.store.service;

import book.store.model.authorModel;
import book.store.repository.authorRepository;
import book.store.repository.bookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@SuppressWarnings("all")
public class authorService {

    @Autowired
    private authorRepository authorRepository;

    @Autowired
    private bookRepository bookRepository;

    public void saveBookAuthor(authorModel authorModel, Integer bookId) {
        try {
            bookRepository.findById(bookId).map(book -> {
                book.getAuthorModelSet().add(authorModel);
                return authorRepository.save(authorModel);
            }).orElseThrow(() -> new IllegalStateException("Not found Tutorial with id = " + bookId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
