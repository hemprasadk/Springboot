package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intData();
    }

    private void  intData()
    {
        Author eric = new Author("Eric","Evans");
        Publisher p1 = new Publisher("Haper collins","123 XYZ");
        Book ddd = new  Book("Domain Driven Design","123",p1);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        publisherRepository.save(p1);
        bookRepository.save(ddd);


        Author rod  = new Author("Rod","Johnson");
        Publisher p2 = new Publisher("SHSFH collins","123 XYZ");
        Book noEJB = new  Book("J2EE gn","234",p2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        publisherRepository.save(p2);
        bookRepository.save(noEJB);



    }
}
