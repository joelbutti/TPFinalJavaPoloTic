
package Persistencia;

import Logica.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;


public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    EntradaJpaController entradaJPA = new EntradaJpaController();
    JuegoJpaController juegoJPA = new JuegoJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    
    public void crearEmpleado(Empleado emp){
        
        empleadoJPA.create(emp);
    }
    
    public void crearEntrada(Entrada ent){
        
        entradaJPA.create(ent);
    }
    
    public void crearJuego(Juego jueg){
        
        System.out.println("aca llego 3");
        juegoJPA.create(jueg);
    }
    
    public void crearPersona(Persona pers){
        
        personaJPA.create(pers);
    }
    
    public void crearUsuario(Usuario usu){
        
        usuarioJPA.create(usu);
    }

    public List<Usuario> getListaUsuarios() {
        
        List<Usuario> listaUsuarios;
        listaUsuarios= usuarioJPA.findUsuarioEntities();
        
        return listaUsuarios;
    }

    public List<Entrada> getListaEntradas() {
        
        List<Entrada> listaEntradas;
        listaEntradas = entradaJPA.findEntradaEntities();
        
        return listaEntradas;
    }

    public List<Empleado> getListaEmpleados() {
        
        List<Empleado> listaEmpleados;
        listaEmpleados = empleadoJPA.findEmpleadoEntities();
        
        return listaEmpleados;
    }

    public List<Juego> getJuegos() {
        
        List<Juego> listaJuegos;
        listaJuegos = juegoJPA.findJuegoEntities();
        
        return listaJuegos;
    }

    public Juego buscarJuego(int id) {
        
        Juego jue = juegoJPA.findJuego(id);
        
        return jue;
    }

    public Entrada buscarEntrada(int id) {
        
        Entrada ent = entradaJPA.findEntrada(id);
        
        return ent;
    }

    public void actualizarEntrada(Entrada ent) throws Exception {
        
        entradaJPA.edit(ent);
    }

    public void eliminarEntrada(int id) throws NonexistentEntityException {
        
        entradaJPA.destroy(id);
    }

    public void actualizarJuego(Juego jue) {
       
        try {
            juegoJPA.edit(jue);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarJuego(int id) {
        
        try {
            juegoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Persona> getPersonas() {
        
        List<Persona> listaPersonas;
        listaPersonas = personaJPA.findPersonaEntities();
        
        return listaPersonas;
        
    }

    public Persona buscarPersona(int id) {
        
        Persona pers = personaJPA.findPersona(id);
        
        return pers;
    }

    public void actualizarPersona(Persona pers)  {
        
        try {
            personaJPA.edit(pers);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        
        Empleado emple = empleadoJPA.findEmpleado(idEmpleado);
        
        return emple;
        
    }

    
    
}
