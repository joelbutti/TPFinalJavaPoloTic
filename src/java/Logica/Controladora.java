
package Logica;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private List<Usuario> listaUsuarios;
    private List<Persona> listaPersonas;
    private List<Empleado> listaEmpleados;
    
    public void crearEmpleado(String dni, String nombre, String apellido, String usuario, String contrasenia) {
        
        Empleado emple = new Empleado();
        
        emple.setApellido(apellido);
        emple.setNombre(nombre);
        emple.setDni(dni);
        
        Usuario usu = this.crearUsuario(usuario, contrasenia);
        
        emple.setUsu(usu);
        
        controlPersis.crearEmpleado(emple);
        
    }
    
    public void crearEntrada(Entrada ent){
        
        
        
        controlPersis.crearEntrada(ent);
        
        
        
    }
    
    public void crearJuego(String nombre, String horaInicio, String horaFin, List<Empleado>listaEmpleados ){
        
        Juego jue = new Juego();
        
        jue.setHoraFin(horaFin);
        jue.setHoraInicio(horaInicio);
        jue.setNombre(nombre);
        jue.setListaEmpleados(listaEmpleados);
        
        controlPersis.crearJuego(jue);
        
    }
    
    public void crearPersona(String dni, String nombre, String apellido, String usuario, String contrasenia, List<Entrada>listaEntradas){
        
        Persona pers = new Persona();
        
        pers.setDni(dni);
        pers.setNombre(nombre);
        pers.setApellido(apellido);
        pers.setListaEntradas(listaEntradas);
        
        Usuario usu = this.crearUsuario(usuario, contrasenia);
        
        pers.setUsuario(usu);
        
        controlPersis.crearPersona(pers);
        
    }
    
    public Usuario crearUsuario(String usuario, String contrasenia){
        
        Usuario usu = new Usuario();
        
        usu.setUsuario(usuario);
        usu.setContrasenia(contrasenia);
        
        controlPersis.crearUsuario(usu);
        
        return usu;
        
    }
    
    public Date stringToDate(String fecha){
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try{
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        }catch(ParseException ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public static String DateToString(Date fecha){
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
        
    }
    
    public Date stringToTime(String hora) throws ParseException{
        
        DateFormat tf = new SimpleDateFormat("HH:mm");
        Date horaEnviar= null;
        
        
        try{
            horaEnviar =tf.parse(hora);
            return horaEnviar;
        }catch(ParseException ex){
            
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String TimeToString(Time hora){
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        return formatoHora.format(hora);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        
        boolean siONo = false;
        
        listaUsuarios = controlPersis.getListaUsuarios();
        
        for(Usuario usu : listaUsuarios){
            
            if(usu.getUsuario().equals(usuario)&& usu.getContrasenia().equals(contrasenia)){
                
                siONo = true;
                return siONo;
            }
        }
        
        return siONo;
        
    }
    
    public List<Entrada> getListaEntradas(){
        
        List<Entrada>listaEntradas = controlPersis.getListaEntradas();
        
        return listaEntradas;
    }

    public boolean comprobarAdmin(String usuario, String contrasenia) {
        
        boolean admin = false;
        
        listaUsuarios = controlPersis.getListaUsuarios();
        
        listaEmpleados = controlPersis.getListaEmpleados();
        
        Usuario usu = new Usuario();
        
        for(Empleado emple : listaEmpleados){
          
            usu = emple.getUsu();
            
            if(usu.getUsuario().equals(usuario)){
                    
                if(usu.getUsuario().equals(usuario)&& usu.getContrasenia().equals(contrasenia)){
                        
                    admin = true;
                        
                    return admin;
                        
                }
            }
        }
        
        return admin;
    }
    
    public List<Empleado> getListaEmpleados(){
        
        List<Empleado>listaEmpleados = controlPersis.getListaEmpleados();
        
        return listaEmpleados;
    }
    
    public List<Juego> getListaJuegos(){
        
        List<Juego>listaJuegos = controlPersis.getJuegos();
        
        return listaJuegos;
    }
    
    public Juego buscarJuego(int id){
        
        Juego jue = controlPersis.buscarJuego(id);
        
        return jue;
    }

    public Entrada buscarEntrada(int id) {
        Entrada ent = controlPersis.buscarEntrada(id);
        
        return ent;
    }

    public void actualizarEntrada(Entrada ent) throws Exception {
        
        controlPersis.actualizarEntrada(ent);
    }

    public void eliminarEntrada(int id) throws NonexistentEntityException {
        
        controlPersis.eliminarEntrada(id);
    }

    public void actualizarJuego(Juego jue) {
        
        controlPersis.actualizarJuego(jue);
    }

    public void eliminarJuego(int id) {
        
        controlPersis.eliminarJuego(id);
    }

    public int getIdLogin(String usuario, String contrasenia) {
        
        int id = 0;
        
        listaPersonas = controlPersis.getPersonas();
        listaUsuarios = controlPersis.getListaUsuarios();
        Usuario usu;
        
        for(Persona pers : listaPersonas){
            
            
            usu = pers.getUsu();
            
            if(usu.getUsuario().equals(usuario)&& usu.getContrasenia().equals(contrasenia)){
                
                id = pers.getIdPersona();
                
                return id;
            }
            
        }
        
        
        
        return id;
    }
    
    public Persona buscarPersona(int id) {
        
        Persona pers = controlPersis.buscarPersona(id);
        
        return pers;
    }

    public void actualizarPersona(Persona pers) {
        
        controlPersis.actualizarPersona(pers);
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        
        Empleado emple = controlPersis.buscarEmpleado(idEmpleado);
        
        return emple;
        
    }

    public List<Usuario> getListaUsuarios() {
        
        List<Usuario>listaUsuarios = controlPersis.getListaUsuarios();
        
        return listaUsuarios;
    }
}
