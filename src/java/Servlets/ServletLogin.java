
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


@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean admin = false;
        boolean ok = false;
        int id = 0;
        
        Controladora control = new Controladora();
        admin = control.comprobarAdmin(request.getParameter("usuario"), request.getParameter("contrasenia"));
        int idlogueado = control.getIdLogin(request.getParameter("usuario"), request.getParameter("contrasenia"));
        ok = control.comprobarIngreso(request.getParameter("usuario"), request.getParameter("contrasenia"));
        
        if(admin == true){
            
            HttpSession sesionActiva = request.getSession(true);
            
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            String empleado = "Cuenta con permiso";
            
            sesionActiva.setAttribute("usuario", usuario);
            sesionActiva.setAttribute("control", control);
            sesionActiva.setAttribute("admin", empleado);
            
            response.sendRedirect("indexEmpleado.jsp");
        }else if(ok == true){
            
            HttpSession sesionActiva = request.getSession(true);
            
            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("contrasenia");
            
            sesionActiva.setAttribute("usuario", usuario);
            sesionActiva.setAttribute("control", control);
            sesionActiva.setAttribute("idActivo", idlogueado);
            
            response.sendRedirect("index.jsp");
            
        }
        else{
            
            response.sendRedirect("sinLogin.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
