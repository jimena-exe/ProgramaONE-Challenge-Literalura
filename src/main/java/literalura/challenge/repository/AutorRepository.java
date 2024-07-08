package literalura.challenge.repository;

import literalura.challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
//    List<Autor> findByNombreContainingIgnoreCase(String nombre);
//
//    @Query("SELECT DISTINCT a FROM Autor a")
//    List<Autor> findAllWithoutDuplicates();

    Autor findByNombreIgnoreCase(String nombre);

}
