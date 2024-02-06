package ru.fsv67.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssuanceString {
    private final long id;
    private final String bookName;
    private final String readerName;
    private final String issuance_at;
    private final String returned_at;
}
