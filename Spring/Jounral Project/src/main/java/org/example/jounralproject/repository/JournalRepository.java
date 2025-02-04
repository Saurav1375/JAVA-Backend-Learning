package org.example.jounralproject.repository;

import org.bson.types.ObjectId;
import org.example.jounralproject.model.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId> {

}
