package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Client;
import Model.ClientDAO;
import Model.Compte;
import Model.CompteDAO;

/**
 * Servlet implementation class AddSoldeController
 */
@WebServlet("/add-solde")
public class AddSoldeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSoldeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteDAO compteDAO = new CompteDAO();
		
		int compte_id = Integer.parseInt(request.getParameter("compte_id"));
		Compte compte = compteDAO.getAccount(compte_id);
		
		request.setAttribute("compte", compte);
		request.setAttribute("compte_id", compte_id);
		this.getServletContext().getRequestDispatcher("/add-solde.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteDAO compteDAO = new CompteDAO();
		
		int compte_id = Integer.parseInt(request.getParameter("compte_id"));
		double solde = Double.parseDouble(request.getParameter("solde-added"));
		Compte compte = compteDAO.getAccount(compte_id);
		
		compteDAO.addSolde(solde, compte);
		compte = compteDAO.getAccount(compte_id);
		request.setAttribute("compte", compte);
		
		this.getServletContext().getRequestDispatcher("/solde-added.jsp").forward(request, response);
	}

}
