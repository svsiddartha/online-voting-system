package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDAO;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class voteServlet
 */
@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
		if(session==null || session.getAttribute("user")==null)
		{
			response.sendRedirect("Login.jsp");
			return;
		}
		
		User user = (User) session.getAttribute("user");
		
		if(user.gethasVoted())
		{
			response.sendRedirect("result.jsp");
			return;
		}
		String candidateParam = request.getParameter("candidate_id");
        if (candidateParam == null) {
            response.sendRedirect("getCandidates");
            return;
        }
        int candidate_id = Integer.parseInt(candidateParam);
		
		CandidateDAO dao = new CandidateDAO();
		
		dao.voteincrement(candidate_id);
		
		UserDAO dao1 = new UserDAO();
		dao1.voteUpdate(user.getUserId());
		
		user.sethasVoted(true);
		
		session.setAttribute("user", user);
		
		response.sendRedirect("result.jsp");
	}

}
