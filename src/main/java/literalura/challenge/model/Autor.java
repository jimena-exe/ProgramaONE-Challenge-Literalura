package literalura.challenge.model;

import java.util.List;

public class Autor {

    //----- variables
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;
//    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    //restablece el constructor predeterminado
    public Autor() {
    }

    //----- constructor
    public Autor(DatosAutor datosAutor){

    }

    //----- Getters y setters

    //----- toString


}
