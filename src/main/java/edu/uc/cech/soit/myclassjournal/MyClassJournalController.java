package edu.uc.cech.soit.myclassjournal;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import edu.uc.cech.soit.myclassjournal.service.IJournalService;
import edu.uc.cech.soit.myclassjournal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

@Controller
public class MyClassJournalController {
    @Autowired
    IJournalService journalService;

    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale( Locale.US ).withZone(ZoneId.systemDefault());

    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @PostMapping("/addJournalEntry/{entryText}")
    public ResponseEntity addJournalEntry(@PathVariable("entryText") String entryText) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JournalEntry entry = new JournalEntry();
        entry.setNotes(entryText);
        entry.setDate(formatter.format(Instant.now()));

        journalService.save(entry);

        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @GetMapping("/getAllJournalEntries")
    public ResponseEntity getAllJournalEntries() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity(journalService.fetchAll(), headers, HttpStatus.OK);
    }

}
