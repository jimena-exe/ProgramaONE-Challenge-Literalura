package literalura.challenge.repository;

import literalura.challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibrosRepository extends JpaRepository<Libro,Long> {
//    List<Libro> findByIdioma(List<String> idioma);

    Optional<Libro> findByTituloContainingIgnoreCase(String titulo);
}
