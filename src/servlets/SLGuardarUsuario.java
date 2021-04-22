package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import datos.DTUsuario;

/**
 * Servlet implementation class SLGuardarUsuario
 */
@WebServlet("/SLGuardarUsuario")
public class SLGuardarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLGuardarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		Usuario user = new Usuario();
		DTUsuario dtu =  new DTUsuario();
		user.setFullName(request.getParameter("fullname"));
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPwd(request.getParameter("pwd"));
		
		
		switch(opc){
		case 1:{
			try { 
			if(dtu.agregarUsuario(user)) {
		        	response.sendRedirect("signIn.jsp?msj=1");
		        }
		        else {
		        	response.sendRedirect("signIn.jsp?msj=2");
		        }
		        	
	        	
	        }
	        catch(Exception e) {
	        	System.out.println("Error al guardar usuario: " + e.getMessage());
				e.printStackTrace();
	        }
	        
			break;
		}
		
		}
	
		
	}

}
