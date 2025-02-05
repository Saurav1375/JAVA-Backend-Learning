package org.example.jounralproject.service;


import org.example.jounralproject.model.JournalEntry;
import org.example.jounralproject.model.User;
import org.example.jounralproject.repository.JournalRepository;
import org.example.jounralproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;

    public void saveJournal(JournalEntry journalEntry, String userName) {
        journalEntry.setCreationDate(LocalDateTime.now());
        User user = userService.getUserByUserName(userName);
        List<JournalEntry> userJournals = user.getJournalEntries();
        userJournals.add(journalEntry);
        user.setJournalEntries(userJournals);
        userService.saveUser(user);
        journalRepository.save(journalEntry);
    }







}
