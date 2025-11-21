package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.model.Trilha;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
}
