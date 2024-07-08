package literalura.challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    //----- variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    //restablece el constructor predeterminado
    public Autor() {
    }

    //----- constructor
    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaDeFallecimiento = datosAutor.fechaDeFallecimiento();

    }

    //----- Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }
    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }


    //----- toString
    @Override
    public String toString() {
        if (fechaDeFallecimiento == null || fechaDeFallecimiento == null){
            return "No hay registro de las fechas de este autor";
        }else {
            String mensaje = String.format("""
                +++++ Autor +++++
                Autor: %s
                Fecha de Nacimiento: %s
                Fecha de fallecimiento: %s
                Libros: %s
                """, nombre, fechaDeNacimiento,fechaDeNacimiento,libros);
            return mensaje;
        }
    }
}
