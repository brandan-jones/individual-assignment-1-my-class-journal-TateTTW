package edu.uc.cech.soit.myclassjournal.dao;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class JournalEntryDAOStub implements IJournalEntryDAO {

    HashMap<Integer, JournalEntry> journalEntries = new HashMap<>();
    /**
     * @param journalEntry JournalEntry object to be saved as a record in the database
     */
    @Override
    public void save(JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getEntryId(), journalEntry);
    }

    /**
     * @param entryId integer used as a unique identifier for a Journal Entry record
     */
    @Override
    public void delete(int entryId) {
        journalEntries.remove(entryId);
    }

    /**
     * @param entryId integer used as a unique identifier for a Journal Entry record
     * @return JournalEntry object for the given entryId
     */
    @Override
    public JournalEntry fetch(int entryId) {
        return journalEntries.get(entryId);
    }

    /**
     * @return List of all JournalEntry objects in the database
     */
    @Override
    public List<JournalEntry> fetchAll() {
        return new ArrayList(journalEntries.values());
    }
}
