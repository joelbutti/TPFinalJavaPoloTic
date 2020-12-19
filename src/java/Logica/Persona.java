
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    int idPersona;
    
    @Basic
    String dni;
    String nombre;
    String apellido;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    Usuario usu;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Entrada>listaEntradas;

    public Persona() {
    }

    public Persona(int idPersona, String dni, String nombre, String apellido, Usuario usu, List<Entrada> listaEntradas) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usu = usu;
        this.listaEntradas = listaEntradas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsuario(Usuario usu) {
        this.usu = usu;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }
    
    
}
