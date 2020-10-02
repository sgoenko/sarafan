package by.hay.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import by.hay.sarafan.domain.User;

public interface UserRepo extends JpaRepository<User, String> {

}
