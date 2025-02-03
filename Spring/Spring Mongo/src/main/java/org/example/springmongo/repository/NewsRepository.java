package org.example.springmongo.repository;

import org.bson.types.ObjectId;
import org.example.springmongo.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRepository extends MongoRepository<News, ObjectId> {
}
