package ru.fsv67.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fsv67.models.Issuance;
import ru.fsv67.models.IssuanceString;
import ru.fsv67.services.BookService;
import ru.fsv67.services.IssuanceService;
import ru.fsv67.services.ReaderService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/issuance")
public class IssuanceViewController {
    private final IssuanceService issuanceService;
    private final BookService bookService;
    private final ReaderService readerService;

    public IssuanceViewController(IssuanceService issuanceService, BookService bookService, ReaderService readerService) {
        this.issuanceService = issuanceService;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @GetMapping
    public String getIssuanceList(Model model) {
        model.addAttribute("issuanceList", listConversion(issuanceService.getIssuanceList()));
        return "issuance-table";
    }

    private List<IssuanceString> listConversion(List<Issuance> issuanceList) {
        List<IssuanceString> viewList = new ArrayList<>();
        String dataFormatter = "dd.MM.yyyy HH:mm:ss";
        for (Issuance issuance : issuanceService.getIssuanceList()) {
            String returned_at = "";
            if (issuance.getReturned_at() != null) {
                returned_at = issuance.getReturned_at().format(DateTimeFormatter.ofPattern(dataFormatter));
            }
            viewList.add(
                    new IssuanceString(
                            issuance.getId(),
                            bookService.getBookById(issuance.getBookId()).getName(),
                            readerService.getReaderById(issuance.getReaderId()).getName(),
                            issuance.getIssuance_at().format(DateTimeFormatter.ofPattern(dataFormatter)),
                            returned_at

                    )
            );
        }
        return viewList;
    }
}
