package book.store.service;

import book.store.model.bookModel;
import book.store.repository.authorRepository;
import book.store.repository.bookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@SuppressWarnings("all")
public class bookService {

    @Autowired
    private bookRepository bookRepository;

    @Autowired
    private authorRepository authorRepository;

    public bookModel saveSingleBook(bookModel model) {
        try {
            bookRepository.save(model);
        } catch (Exception e) {
            log.error("invalid data input", model);
        }
        return model;
    }

    public List<bookModel> saveMultipleBooks(List<bookModel> bookLists) {
        try {
            bookRepository.saveAll(bookLists);
        } catch (Exception e) {
            log.error("invalid data input", bookLists);
        }
        return bookLists;
    }

    public Optional<bookModel> viewSingleBook(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public void deleteSingleBook(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public bookModel updateBookDescription(bookModel bookModel, Integer bookId) {

        bookModel book = bookModel;
        bookModel serchBook = bookRepository.findById(bookId).get();

        if (serchBook.getTitle() != book.getTitle()) {
            serchBook.setTitle(book.getTitle());
        } else if (serchBook.getPrice() != book.getPrice()) {
            serchBook.setPrice(book.getPrice());
        } else if (serchBook.getPublicationYear() != book.getPublicationYear()) {
            serchBook.setPublicationYear(book.getPublicationYear());
        } else if (serchBook.getIsbn() != book.getIsbn()) {
            serchBook.setIsbn(book.getIsbn());
        }
        return bookRepository.save(serchBook);
    }

}
