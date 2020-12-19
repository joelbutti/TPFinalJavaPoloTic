
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Entrada;
import Logica.Juego;
import Logica.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletNuevaEntrada", urlPatterns = {"/ServletNuevaEntrada"})
public class ServletNuevaEntrada extends HttpServlet {
    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = (int)request.getSession().getAttribute("idActivo");
        String nombre = request.getParameter("juego");
        String horario = request.getParameter("horario");
        String fecha = request.getParameter("fecha");
        
        
        int juegoId = Integer.parseInt(nombre);
       
        Controladora control = new Controladora();
        
        Juego jue = control.buscarJuego(juegoId);
        
        Date hora = null;
        Date horaFin = null;
        Date horaInicio = null;
        try {
            horaInicio = control.stringToTime(jue.getHoraInicio());
            horaFin = control.stringToTime(jue.getHoraFin());
            hora = control.stringToTime(horario);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(horaInicio.before(hora) && horaFin.after(hora)){
            
            Persona pers = control.buscarPersona(id);
        
            Entrada ent = new Entrada();
        
            List<Entrada>listaEntradas= pers.getListaEntradas();
        
            ent.setFecha(fecha);
            ent.setHorario(horario);
            ent.setJueg(jue);
            listaEntradas.add(ent);
            control.crearEntrada(ent);
        
        
        
            pers.setListaEntradas(listaEntradas);
        
            control.actualizarPersona(pers);
        }
        
        
        
        response.sendRedirect("index.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
