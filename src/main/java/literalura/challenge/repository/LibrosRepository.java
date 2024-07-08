package literalura.challenge.repository;

import literalura.challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libro,Long> {
//    List <Libro>;
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
}
