package Journal.Application.Pintilie.Victor.Services;

import Journal.Application.Pintilie.Victor.Entities.Journal;
import Journal.Application.Pintilie.Victor.Entities.User;
import Journal.Application.Pintilie.Victor.Exceptions.JournalNotFoundException;
import Journal.Application.Pintilie.Victor.Repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public Journal updateJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteJournal(Long journalId) {
        journalRepository.deleteById(journalId);
    }

    public Journal findJournalById(Long journalId) {
        return journalRepository.findById(journalId)
                .orElseThrow(() -> new JournalNotFoundException("Journal not found"));
    }

    public List<Journal> findJournalsByUser(User user) {
        return journalRepository.findByUser(user);
    }

    public List<Journal> findAllJournals() {
        return journalRepository.findAll();
    }

    // Other journal-related methods
}
