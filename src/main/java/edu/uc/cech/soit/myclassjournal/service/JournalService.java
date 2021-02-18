package edu.uc.cech.soit.myclassjournal.service;

import edu.uc.cech.soit.myclassjournal.dao.IJournalEntryDAO;
import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService implements IJournalService {
    @Autowired
    IJournalEntryDAO journalEntryDAO;
    /**
     * Save a new Journal Entry
     *
     * @param journalEntry the entry to save.
     */
    @Override
    public void save(JournalEntry journalEntry) {
        journalEntryDAO.save(journalEntry);
    }

    /**
     * Return all journal entries.
     *
     * @return a collection of all journal entries.
     */
    @Override
    public List<JournalEntry> fetchAll() {
        return journalEntryDAO.fetchAll();
    }
}
