package ru.fsv67.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fsv67.models.Issuance;
import ru.fsv67.services.BookService;
import ru.fsv67.services.IssuanceService;
import ru.fsv67.services.ReaderService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/reader")
public class ReaderViewController {
    private final ReaderService readerService;
    private final BookService bookService;
    private final IssuanceService issuanceService;

    public ReaderViewController(ReaderService readerService, IssuanceService issuanceService, BookService bookService) {
        this.readerService = readerService;
        this.issuanceService = issuanceService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getReaderList(Model model) {
        model.addAttribute("readerList", readerService.getReaderList());
        return "reader-list";
    }

    @GetMapping("/{id}")
    public String getReader(@PathVariable long id, Model model) {
        model.addAttribute("reader", readerService.getReaderById(id));
        model.addAttribute("bookListReader",
                getIssuanceBookName(issuanceService.getIssuanceByIdReader(id)));
        return "reader";
    }

    private List<String> getIssuanceBookName(List<Issuance> issuanceList) {
        List<String> list = new ArrayList<>();
        for (Issuance issuance : issuanceList) {
            list.add(bookService.getBookById(issuance.getBookId()).getName());
        }
        return list;
    }
}