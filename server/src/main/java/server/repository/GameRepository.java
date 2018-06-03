package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
