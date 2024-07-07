package literalura.challenge;

import literalura.challenge.principal.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nBienvenido/a a la biblioteca llamada LiterAlura.");
		Menu menu = new Menu();
		menu.mostrarMenu();

	}
}
