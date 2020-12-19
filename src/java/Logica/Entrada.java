
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Entrada implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idEntrada;
    
    @Basic
    String fecha;
    String horario;
    
    @OneToOne
    Juego jueg;

    public Entrada() {
    }

    public Entrada(int idEntrada, String horario, String fecha, Juego jueg) {
        this.idEntrada = idEntrada;
        this.horario = horario;
        this.fecha = fecha;
        this.jueg = jueg;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Juego getJueg() {
        return jueg;
    }

    public void setJueg(Juego jueg) {
        this.jueg = jueg;
    }
    
    
}
