package literalura.challenge.principal;

import literalura.challenge.model.DatosGenerales;
import literalura.challenge.service.ConsumoAPI;
import literalura.challenge.service.ConvierteDatos;

import java.util.Scanner;

public class Menu {
    //variables
    private Scanner teclado = new Scanner(System.in);
    public final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();


    //método para mostrar el menú
    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0){

            System.out.println("\n++++ Elija una de las opciones del menú ++++");
            String menu = """
                1~ Buscar libro por título.
                2~ Quiero listar los libros por idioma.
                3~ Quiero listar los libros registrados.
                4~ Quiero listar los autores registrados.
                5~ Quiero listar los autores vivos en un determinado año.
                
                6. TODOS LOS LIBROS
                
                0~ _Salir de la aplicación_
                """;
            System.out.println(menu);
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
//                case 1: mostrarLibroPorTitulo();
//                    break;
//                case 2: mostrarLibrosPorIdioma();
//                break;
//                case 3: mostrarLibrosRegistrados();
//                break;
//                case 4: mostrarLosAutoresRegistrados();
//                break;
//                case 5: mostrarAutoresVivosPorAnio();
//                break;
                case 6: mostrarTodosLosLibros();
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

    public void mostrarTodosLosLibros(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, DatosGenerales.class);
        System.out.println(datos);

    }
}
