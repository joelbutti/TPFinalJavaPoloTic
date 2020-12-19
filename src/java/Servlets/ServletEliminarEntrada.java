
package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.Persona;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEliminarEntrada", urlPatterns = {"/ServletEliminarEntrada"})
public class ServletEliminarEntrada extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idActivo = (int)request.getSession().getAttribute("idActivo");
        int id = Integer.parseInt(request.getParameter("id"));
        int idBorrar=999;
        
        Controladora control = new Controladora();
        
        Persona pers = control.buscarPersona(idActivo);
        
        Entrada ent = control.buscarEntrada(id);
        
        List<Entrada>listaEntradas = pers.getListaEntradas();
        
        for(Entrada entrada : listaEntradas){
            
            if(entrada.getIdEntrada() == id){
                
                idBorrar = listaEntradas.indexOf(entrada);
                
                //listaEntradas.remove(entrada);
            }
        }
        
        listaEntradas.remove(idBorrar);
        
        
        pers.setListaEntradas(listaEntradas);
        
        control.actualizarPersona(pers);
        
        
        response.sendRedirect("misEntradas.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
