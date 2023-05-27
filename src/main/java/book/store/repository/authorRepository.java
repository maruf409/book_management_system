package book.store.repository;

import book.store.model.authorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorRepository extends JpaRepository<authorModel, Integer> {

}
