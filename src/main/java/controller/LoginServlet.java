package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 
		if(email==null || password==null || email.isEmpty() || password.isEmpty())
		{
			response.sendRedirect("Login.jsp?error=empty");
			return;
		}
		
		UserDAO dao = new UserDAO();
		User user = dao.userLogin(email, password);
		
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			if(user.gethasVoted()) {
				response.sendRedirect("result.jsp");
			}
			else
			{
				response.sendRedirect("Vote.jsp");
			}
		}
		else
		{
			response.sendRedirect("Login.jsp?error=invalid");
		}
	}

}
