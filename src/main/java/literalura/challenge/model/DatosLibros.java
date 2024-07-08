package literalura.challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(@JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<DatosAutor> autores,
                          @JsonAlias("languages") List <String> idioma,
                          @JsonAlias("download_count") Integer numeroDeDescargas) {
//    //----- ToString
//    @Override
//    public String toString() {
//        String mensaje = String.format("""
//                ++++++++ Libro ++++++++
//                Titulo: %s
//                Autor: %s
//                Idioma: %s
//                Número de descargas: %s
//                ++++++++++++++++++++++++
//                """, titulo, autores,idioma,numeroDeDescargas);
//        return mensaje;
//    }

}
