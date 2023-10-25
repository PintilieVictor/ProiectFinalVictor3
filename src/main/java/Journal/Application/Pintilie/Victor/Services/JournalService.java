package Journal.Application.Pintilie.Victor.Services;

import Journal.Application.Pintilie.Victor.Entities.Journal;
import Journal.Application.Pintilie.Victor.Entities.User;

import java.util.List;

public interface JournalService {
    Journal createJournal(Journal journal);
    Journal updateJournal(Journal journal);
    void deleteJournal(Long journalId);
    Journal getJournalById(Long journalId);
    List<Journal> getJournalsByUser(User user);
    List<Journal> getAllJournals();
}
