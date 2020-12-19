
package Servlets;

import Logica.Controladora;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEliminarJuego", urlPatterns = {"/ServletEliminarJuego"})
public class ServletEliminarJuego extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
  
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Controladora control = new Controladora();
        
        try {
            control.eliminarJuego(id);
        } catch (Exception ex) {
            Logger.getLogger(ServletEliminarEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("verJuegos.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
