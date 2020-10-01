package by.hay.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import by.hay.sarafan.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
