package Journal.Application.Pintilie.Victor.Controllers;

import Journal.Application.Pintilie.Victor.Entities.User;
import Journal.Application.Pintilie.Victor.Services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Journal.Application.Pintilie.Victor.Entities.Journal;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @PostMapping("/create")
    public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
        Journal createdJournal = journalService.createJournal(journal);
        return new ResponseEntity<>(createdJournal, HttpStatus.CREATED);
    }

    @PutMapping("/update/{journalId}")
    public ResponseEntity<Journal> updateJournal(@PathVariable Long journalId, @RequestBody Journal journal) {
        journal.setId(journalId); // Ensure the ID in the URL matches the ID in the request body
        Journal updatedJournal = journalService.updateJournal(journal);
        return new ResponseEntity<>(updatedJournal, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{journalId}")
    public ResponseEntity<Void> deleteJournal(@PathVariable Long journalId) {
        journalService.deleteJournal(journalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{journalId}")
    public ResponseEntity<Journal> getJournalById(@PathVariable Long journalId) {
        Journal journal = journalService.findJournalById(journalId);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Journal>> getJournalsByUser(@PathVariable Long userId) {
        User user = new User(); // Create a user object with the given userId
        List<Journal> journals = journalService.findJournalsByUser(user);
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> journals = journalService.findAllJournals();
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    // Other journal-related endpoints
}


