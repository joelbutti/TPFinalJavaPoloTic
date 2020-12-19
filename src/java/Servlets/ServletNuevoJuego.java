
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletNuevoJuego", urlPatterns = {"/ServletNuevoJuego"})
public class ServletNuevoJuego extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String inicio = request.getParameter("horarioInicio");
        String cierre = request.getParameter("horarioCierre");
        List<Empleado>listaEmpleados = new ArrayList<Empleado>();
        Date horaFin = null;
        Date horaInicio = null;
        
        Controladora control = new Controladora();
        
        try {
            
            horaInicio = control.stringToTime(inicio);
            horaFin = control.stringToTime(cierre);
            
        } catch (Exception e) {
        }
        
        if(horaInicio.before(horaFin)){
            
            control.crearJuego(nombre, inicio , cierre, listaEmpleados);
        }
       
        
        response.sendRedirect("indexEmpleado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
