package book.store.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@SuppressWarnings("all")
@Table(name = "author_list")
public class authorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String authorName;
    @Email(message = "invalid email address")
    private String authorEmail;
    private String authorBiography;

}
