package edu.uc.cech.soit.myclassjournal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JournalEntry {
    private int entryId;
    private String notes;
    private String date;
}
