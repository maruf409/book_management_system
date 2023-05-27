package book.store.repository;

import book.store.model.bookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<bookModel,Integer> {

}
