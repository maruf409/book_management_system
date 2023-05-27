package book.store.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@SuppressWarnings("all")
@Table(name = "book_store")
public class bookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "title shouldn`t be empty")
    private String title;
    @NotNull(message = "isbn shouldn`t be empty")
    private Integer isbn;
    @NotEmpty
    private Date publicationYear;
    @Min(500)
    @Max(5000)
    private double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private Set<authorModel> authorModelSet = new HashSet<>();

}
