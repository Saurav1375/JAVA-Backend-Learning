package org.example.notesbackend.service;

import org.bson.types.ObjectId;
import org.example.notesbackend.model.Notes;
import org.example.notesbackend.model.User;
import org.example.notesbackend.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserService userService;

    public void saveNotes(Notes notes, String userName) {
        try {
            User user = userService.findByUserName(userName);
            notes.setDate(LocalDateTime.now());
            Notes saved = notesRepository.save(notes);
            user.getNotes().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entry.", e);
        }
        notesRepository.save(notes);
    }

    public void saveNotes(Notes notes) {
        notesRepository.save(notes);
    }
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }
    public Optional<Notes> getNotesById(ObjectId id) {
        return notesRepository.findById(id);
    }
    public boolean deleteNotes(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getNotes().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                notesRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }
}
