package Journal.Application.Pintilie.Victor.Services;

import Journal.Application.Pintilie.Victor.Entities.User;
import Journal.Application.Pintilie.Victor.Repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Journal.Application.Pintilie.Victor.Entities.Journal;


import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public Journal updateJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public void deleteJournal(Long journalId) {
        journalRepository.deleteById(journalId);
    }

    @Override
    public Journal getJournalById(Long journalId) {
        return journalRepository.findById(journalId).orElse(null);
    }

    @Override
    public List<Journal> getJournalsByUser(User user) {
        return journalRepository.findByUser(user);
    }

    @Override
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}
