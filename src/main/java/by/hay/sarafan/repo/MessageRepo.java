package by.hay.sarafan.repo;

import org.springframework.data.repository.CrudRepository;

import by.hay.sarafan.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {

}
