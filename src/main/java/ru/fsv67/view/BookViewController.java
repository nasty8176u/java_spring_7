package ru.fsv67.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fsv67.services.BookService;

@Controller
@RequestMapping("/ui/book")
public class BookViewController {
    private final BookService bookService;

    public BookViewController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBookList(Model model) {
        model.addAttribute("bookList", bookService.getBooksList());
        return "book-list";
    }
}
