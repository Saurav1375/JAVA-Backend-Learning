package org.example.notesbackend.repository;

import org.bson.types.ObjectId;
import org.example.notesbackend.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Notes, ObjectId> {

}
