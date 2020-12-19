package login.summit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginRegister() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO ud = new UserDAOImpl(); 
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");
		
		User u  = ud.getUser(email, password);
		System.out.println(u.getName()+u.getEmail());
		if (submitType.equals("login") && u!=null && u.getName()!=null ) {
			request.setAttribute("message", u.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}else if (submitType.equals("register") && password.equals(request.getParameter("password2"))) {
			u = new User();
			u.setName(request.getParameter("name"));
			u.setEmail(email);
			u.setPassword(password);
			ud.insertUser(u);
	
			request.setAttribute("successMessage", "Registro feito com Sucesso.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Nenhum dado foi encontrado.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
