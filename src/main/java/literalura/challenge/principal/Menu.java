package literalura.challenge.principal;

import literalura.challenge.model.Autor;
import literalura.challenge.model.DatosGenerales;
import literalura.challenge.model.DatosLibros;
import literalura.challenge.model.Libro;
import literalura.challenge.repository.AutorRepository;
import literalura.challenge.repository.LibrosRepository;
import literalura.challenge.service.ConsumoAPI;
import literalura.challenge.service.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    //variables
    private Scanner teclado = new Scanner(System.in);
    public final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository repositorioLibros;
    private Optional<Libro> libroBuscado;

    private AutorRepository repositorioAutores;


    public Menu(LibrosRepository repository, AutorRepository autorRepository){
        //, AutorRepository autorRepository
        this.repositorioLibros = repository;
        this.repositorioAutores = autorRepository;
    }


    //método para mostrar el menú
    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0){

            System.out.println("\n++++ Elija una de las opciones del menú ++++");
            String menu = """
                1~ Buscar libros en la web.
                2~ Buscar libro por título.
                3~ Quiero listar los libros por idioma.
                4~ Quiero listar los libros registrados.
                5~ Quiero listar los autores registrados.
                6~ Quiero listar los autores vivos en un determinado año.
                
                6. TODOS LOS LIBROS
                
                0~ _Salir de la aplicación_
                """;
            System.out.println(menu);
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1: getLibroPorTitulo();
                break;
                case 2: mostrarLibroPorTitulo();
                    break;
                case 3: mostrarLibrosPorIdioma();
                break;
                case 4: mostrarLibrosRegistrados();
                break;
                case 5: mostrarLosAutoresRegistrados();
                break;
//                case 6: mostrarAutoresVivosPorAnio();
//                break;
                case 7: mostrarTodosLosLibros();
                break;
                case 0:
                    System.out.println("Cerrando la aplicación de la Biblioteca...");
                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }

        }

    }

    //mostrar todos los datos = Consumo inicial de API
    public void mostrarTodosLosLibros(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, DatosGenerales.class);
        System.out.println(datos);

    }

    //Traer libros por título de la API, buscar serie web ------ FALTA GUARDAR CADA LIBRO EN EL REPO
    public void getLibroPorTitulo(){
        System.out.println("Ingresa el nombre del libro que deseas encontrar: ");
        var tituloLibro = teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ","+"));


        try{
            //Convertir el Json en un objeto
            DatosGenerales datosGenerales = conversor.obtenerDatos(json,DatosGenerales.class);

            //Busca el libro con el título
            Optional<DatosLibros> libroBuscado = datosGenerales.resultados().stream()
                    .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                    .findFirst();

            if(libroBuscado.isPresent()){
                DatosLibros datosLibros = libroBuscado.get();

                //crea objeto del tipo Libro
                Libro libro = new Libro(datosLibros);

                //imprimir datos del libro
                System.out.println("Libro Encontrado ");
                System.out.println(libro.toString());
//            System.out.println(datosLibros);

                //Guardar libro en la BD
                repositorioLibros.save(libro);
                System.out.println("Libro guardado en la Base de datos.");

            }else {
                System.out.println("Libro no encontrado");
            }

        }catch (Exception e){
            System.out.println("--- Ha ocurrido un ERROR ---" + e.getMessage());
        }


    }

    //Mostrar libros por título guardado en la BD
    public void mostrarLibroPorTitulo(){
        System.out.println("\nEscribe el nombre del libro que deseas buscar en nuestro repositorio de Libros: ");
        var nombreLibro = teclado.nextLine();
        libroBuscado = repositorioLibros.findByTituloContainingIgnoreCase(nombreLibro);

        if (libroBuscado.isPresent()) {
            System.out.println("El libro buscado es: \n"+ libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

    }

    //Traer libros por idioma  ---- ARREGLAR VISTA DE NOMBRE DE AUTOR
    public void mostrarLibrosPorIdioma(){
        System.out.println("""
                \n¿En qué idioma deseas buscar los libros?
                 1. Escribe "es" para Español
                 2. Escribe "en" para Inglés
                 3. Escribe "fr" para Francés
                 4. Escribe "it" para Italiano""");

        System.out.print("\nEscibre tu opción aquí: ");
        var idiomaSeleccionado = teclado.nextLine();

        //API
        String json = consumoAPI.obtenerDatos(URL_BASE+"/?languages=" + idiomaSeleccionado.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, DatosGenerales.class);

        System.out.println(datosBusqueda.resultados());

    }

    //Traer todos los libros registrados en la BD
    public void mostrarLibrosRegistrados(){
        // Recuperar los libros almacenados en la base de datos y almacenarlos en la lista libros
        List<Libro> libros = repositorioLibros.findAll();
        libros.forEach(System.out::println);

    }

    //Traer autores registrados  --- FALLA
    public void mostrarLosAutoresRegistrados(){
        List<Autor> autores = repositorioAutores.findAll();
        autores.forEach(System.out::println);

    }


}
