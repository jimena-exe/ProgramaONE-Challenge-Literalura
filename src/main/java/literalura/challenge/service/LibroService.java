//package literalura.challenge.service;
//
//import jakarta.annotation.PostConstruct;
//import literalura.challenge.model.DatosGenerales;
//import literalura.challenge.model.DatosLibros;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.Scanner;
//
//@Service
//public class LibroService {
//    @Autowired
//    private ConvierteDatos conversorDatos;
//
//    public void buscarLibroPorTitulo(String tituloLibro, String json){
//
//        //Convertir el Json en un objeto
//        DatosGenerales datosGenerales = conversorDatos.obtenerDatos(json,DatosGenerales.class);
//
//        //Busca el libro con el título
//        Optional<DatosLibros> libroBuscado = datosGenerales.resultados().stream()
//                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
//                .findFirst();
//
//        if(libroBuscado.isPresent()){
//            DatosLibros datosLibros = libroBuscado.get();
//            System.out.println("Libro Encontrado ");
////            System.out.println(libroBuscado.get());
//            System.out.println(datosLibros);
//        }else {
//            System.out.println("Libro no encontrado");
//        }
//
//        //Para guardar en la BD
////        if (libroBuscado.isPresent()){
////            // Obtiene el objeto DatosLibros del Optional
////            DatosLibros datosLibros = libroBuscado.get();
////
////            //Crear el objteto libro
////
////
////        }
//
//    }
//
//}
