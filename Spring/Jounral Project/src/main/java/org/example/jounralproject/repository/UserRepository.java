package org.example.jounralproject.repository;

import org.bson.types.ObjectId;
import org.example.jounralproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
