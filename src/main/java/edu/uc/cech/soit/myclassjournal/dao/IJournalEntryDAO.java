package edu.uc.cech.soit.myclassjournal.dao;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;

import java.util.List;

/**
 * DAO used for accessing Journal Entry records in the underlying database
 */
public interface IJournalEntryDAO {
    /**
     * @param journalEntry JournalEntry object to be saved as a record in the database
     */
    void save(JournalEntry journalEntry);

    /**
     * @param entryId integer used as a unique identifier for a Journal Entry record
     */
    void delete(int entryId);

    /**
     * @param entryId integer used as a unique identifier for a Journal Entry record
     * @return JournalEntry object for the given entryId
     */
    JournalEntry fetch(int entryId);

    /**
     * @return List of all JournalEntry objects in the database
     */
    List<JournalEntry> fetchAll();
}
