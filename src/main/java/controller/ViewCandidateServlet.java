package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDAO;
import model.Candidate;

/**
 * Servlet implementation class getAllCandidtaes
 */
@WebServlet("/getAllCandidates")
public class ViewCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//.request.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("Admin")==null)
		{
			response.sendRedirect("AdminLogin.jsp");
			return;
		}
		CandidateDAO dao = new CandidateDAO();
		List<Candidate> list = dao.getAllCandidates();
		
		request.setAttribute("candidates", list);
		request.getRequestDispatcher("ViewCandidates.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//.reques(request, response);
	}

}
