
package Servlets;

import Logica.Controladora;
import Logica.Juego;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEditarJuego", urlPatterns = {"/ServletEditarJuego"})
public class ServletEditarJuego extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String inicio = request.getParameter("nuevoInicio");
        String cierre = request.getParameter("nuevoCierre");
        String nombre = request.getParameter("nuevoNombre");
        Controladora control = new Controladora();
        
        Juego jue = null;
        
        
        
        
        try {
            
            int nuevoId = Integer.parseInt(request.getParameter("id"));
            jue = control.buscarJuego(nuevoId);
            
            
        } catch (Exception e) {
        }
         
        
        if(nombre!= null){
            jue.setNombre(nombre);
        }
       
        if(inicio!= null){
            jue.setHoraInicio(inicio);
        }
        if(cierre!= null){
            jue.setHoraFin(cierre);
        }
        
        control.actualizarJuego(jue);
        
        response.sendRedirect("verJuegos.jsp");
                
    }

 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
