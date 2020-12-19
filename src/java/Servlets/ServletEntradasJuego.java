
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletEntradasJuego", urlPatterns = {"/ServletEntradasJuego"})
public class ServletEntradasJuego extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idJuego = Integer.parseInt(request.getParameter("juego"));
        
        Controladora control = new Controladora();
        
        HttpSession sesionActiva = request.getSession(true);
        sesionActiva.setAttribute("juegoABuscar", idJuego);
        
        response.sendRedirect("entradasSegunJuego.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
