package org.example.jounralproject.controller;

import org.example.jounralproject.model.JournalEntry;
import org.example.jounralproject.model.User;
import org.example.jounralproject.service.JournalService;
import org.example.jounralproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getJournalEntriesByUserName(@PathVariable String userName) {
        User user = userService.getUserByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all!= null && !all.isEmpty()) {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/{username}")
    public ResponseEntity<?> createJournalEntry(@PathVariable String username, @RequestBody JournalEntry journalEntry) {
        try {
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            journalService.saveJournal(journalEntry, username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
