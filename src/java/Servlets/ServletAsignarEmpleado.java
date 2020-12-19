
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Juego;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joel
 */
@WebServlet(name = "ServletAsignarEmpleado", urlPatterns = {"/ServletAsignarEmpleado"})
public class ServletAsignarEmpleado extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idJuego = Integer.parseInt(request.getParameter("idJuego"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        
        Controladora control = new Controladora();
        
         
        
        Juego jue = control.buscarJuego(idJuego);
        Empleado emple = control.buscarEmpleado(idEmpleado);
        
        List<Empleado>listaEmpleados = jue.getListaEmpleados();
        
        List<Juego>listaJuegos = control.getListaJuegos();
        
        List<Empleado>listaEmplea= new ArrayList<Empleado>();
        
        int idRemover=999;
        
        
        Juego juegoNuevo= new Juego();
        
        for(Juego juego : listaJuegos){
            
            listaEmplea= juego.getListaEmpleados();
            
           for(Empleado empleado : listaEmplea){
               
               if(empleado.getIdEmpleado() == idEmpleado){
                   
                   idRemover = listaEmplea.indexOf(empleado);
                   juegoNuevo = juego;
               }
               
           }
           
           
        }
        
        
        if(idRemover!=999){
            List<Empleado> nuevalista= juegoNuevo.getListaEmpleados();
            nuevalista.remove(idRemover);
            juegoNuevo.setListaEmpleados(nuevalista);
            control.actualizarJuego(juegoNuevo);
        }
        
        
        listaEmpleados.add(emple);
        
        jue.setListaEmpleados(listaEmpleados);
        
        control.actualizarJuego(jue);
        
        response.sendRedirect("verJuegos.jsp");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
