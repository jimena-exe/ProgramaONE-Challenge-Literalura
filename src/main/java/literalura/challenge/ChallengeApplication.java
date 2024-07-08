package literalura.challenge;

import literalura.challenge.principal.Menu;
import literalura.challenge.repository.AutorRepository;
import literalura.challenge.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	@Autowired
	private LibrosRepository repository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nBienvenido/a a la biblioteca llamada LiterAlura.");
		Menu menu = new Menu(repository,autorRepository);
		//autorRepository
		menu.mostrarMenu();

	}
}
