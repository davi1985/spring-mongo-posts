package dev.dsilva.workshopspringmongo.repositories;

import dev.dsilva.workshopspringmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
