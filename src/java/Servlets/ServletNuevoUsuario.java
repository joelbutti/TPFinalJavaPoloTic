/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletNuevoUsuario", urlPatterns = {"/ServletNuevoUsuario"})
public class ServletNuevoUsuario extends HttpServlet {

    
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
        List<Entrada>listaEntradas= new ArrayList<Entrada>();
        
        int existeUsuario=0;
        
        Controladora control = new Controladora();
        
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
        
                    if(usuario.equals("admin")){
            
                        control.crearEmpleado(dni, nombre, apellido, usuario, contrasenia);
                    }
                    else{
            
                    control.crearPersona(dni, nombre, apellido, usuario, contrasenia, listaEntradas);
                    }
        
                   
                
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
