package Journal.Application.Pintilie.Victor.Controllers;

import Journal.Application.Pintilie.Victor.Services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Journal.Application.Pintilie.Victor.Entities.Journal;

import java.util.List;

@Controller
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping("/create")
    public String createJournalForm(Model model) {
        model.addAttribute("journal", new Journal());
        return "create_journal";
    }

    @PostMapping("/create")
    public String createJournal(@ModelAttribute("journal") Journal journal) {
        journalService.createJournal(journal);
        return "redirect:/journals";
    }

    @GetMapping("/edit/{id}")
    public String editJournalForm(@PathVariable Long id, Model model) {
        Journal journal = journalService.getJournalById(id);
        model.addAttribute("journal", journal);
        return "edit_journal";
    }

    @PostMapping("/edit/{id}")
    public String editJournal(@ModelAttribute("journal") Journal journal) {
        journalService.updateJournal(journal);
        return "redirect:/journals";
    }

    @GetMapping("/delete/{id}")
    public String deleteJournal(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return "redirect:/journals";
    }

    @GetMapping
    public String listJournals(Model model) {
        List<Journal> journals = journalService.getAllJournals();
        model.addAttribute("journals", journals);
        return "journal_list";
    }
}

