package org.example.jounralproject.service;


import org.example.jounralproject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

}
