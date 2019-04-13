package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private  String lastname;
    @ManyToMany(mappedBy = "authors")
    private Set<Book>  books= new HashSet<Book>();


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Set<Book> getBooks() {
        return books;
    }




    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }



    public Author(String firstname, String lastname, Set<Book> books) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }



    public Author()
    {

    }

}
