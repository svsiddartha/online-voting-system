package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDAO;
import model.Candidate;

/**
 * Servlet implementation class AddCandidateServlet
 */
@WebServlet("/addCandidate")
public class AddCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCandidateServlet() {
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
		
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("admin")==null)
		{
			response.sendRedirect("AdminLogin.jsp");
			return;
		}
		
		String name = request.getParameter("name");
		String party = request.getParameter("party");
		
		if(name==null || party==null || name.isEmpty() || party.isEmpty())
		{
			response.sendRedirect("AddCandidates.jsp?error=empty");
			return;
		}
		
		Candidate candidate = new Candidate(name,party);
		
		CandidateDAO dao = new CandidateDAO();
		boolean status = dao.addCandidate(candidate);
		
		if(status)
		{
			response.sendRedirect("AddCandidates.jsp?msg=added");
		}
		else
		{
			response.sendRedirect("AddCandidates.jsp?error=failed");
		}
		
	}

}
