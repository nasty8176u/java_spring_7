package ru.fsv67.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fsv67.models.Book;
import ru.fsv67.repositories.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Класс описывает логику взаимодействия пользователя с хранилищем книг
 */
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Первоначальные тестовые данные
     */
    @PostConstruct
    void generateData() {
        bookRepository.saveAll(
                List.of(
                        new Book("Чистый код"),
                        new Book("Паттерны проектирования"),
                        new Book("Совершенный код"),
                        new Book("Программист-прагматик"),
                        new Book("Идеальный программист"),
                        new Book("Карьера программиста")
                )
        );
    }

    /**
     * Метод проверки информации о книге
     *
     * @param id идентификатор книги
     * @return если данные не пусты, то метод возвращает книгу по идентификатору, иначе исключение
     */
    public Book getBookById(long id) {
        Book book = bookRepository.findById(id).get();
        if (Objects.isNull(book)) {
            throw new NoSuchElementException("Книга с ID = " + id + " не найдена");
        }
        return book;
    }

    /**
     * Метод обрабатывает получение списка книг
     *
     * @return если список не пуст, то метод возвращает список книг, иначе исключение
     */
    public List<Book> getBooksList() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NoSuchElementException("Список книг в библиотеке пуст");
        }
        return books;
    }

    /**
     * Метод обрабатывает данные введенные пользователем для записи
     *
     * @param book данные о книге, введенные пользователем
     * @return информацию о книге подлежащие записи
     */
    public Book addNewBook(Book book) {
        if (book.getName().isEmpty()) {
            throw new RuntimeException("Название книги не задано");
        }
        return bookRepository.save(book);
    }

    /**
     * Метод проверяет информацию перед удалением книги
     *
     * @param id идентификатор книги подлежащей удалению
     * @return описание удаленной книги
     */
    public Book deleteBookById(long id) {
        Book book = getBookById(id);
        bookRepository.deleteById(id);
        if (Objects.isNull(book)) {
            throw new NoSuchElementException("Книга с ID = " + id + " не найдена");
        }
        return book;
    }
}
