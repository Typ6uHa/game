package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
