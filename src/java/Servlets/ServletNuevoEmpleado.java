
package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletNuevoEmpleado", urlPatterns = {"/ServletNuevoEmpleado"})
public class ServletNuevoEmpleado extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("pass");
        
        Controladora control = new Controladora();
        
        int existeUsuario=0;
        
        List<Usuario>listaUsuarios = control.getListaUsuarios();
        
        for(Usuario usu : listaUsuarios){
            
            if(usu.getUsuario().equals(usuario)){
                
                existeUsuario++;
            }
            
        }
        
        try {
            
            int validarDni = Integer.parseInt(dni);
            
            if(existeUsuario == 0){
                
                if(validarDni>=11111111 && validarDni<=60000000){
            
                control.crearEmpleado(dni, nombre, apellido, usuario, contrasenia);
        
                response.sendRedirect("indexEmpleado.jsp");
                
                }
            }
            
            
        } catch (Exception e) {
            
        }
        
        response.sendRedirect("nuevoEmpleado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
