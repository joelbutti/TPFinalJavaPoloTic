
package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.Juego;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletActualizarHoraEntrada", urlPatterns = {"/ServletActualizarHoraEntrada"})
public class ServletActualizarHoraEntrada extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String hora = request.getParameter("nuevaHora");
        String fecha = request.getParameter("nuevaFecha");
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        
        Controladora control = new Controladora();
        
        Entrada ent = control.buscarEntrada(id);
        
        ent.setFecha(fecha);
        ent.setHorario(hora);
        
        
        try {
            control.actualizarEntrada(ent);
        } catch (Exception ex) {
            Logger.getLogger(ServletActualizarHoraEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("misEntradas.jsp");
    }

   @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
