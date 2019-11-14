package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ClientDAO;
import Model.Compte;
import Model.CompteDAO;

/**
 * Servlet implementation class CreateAccountController
 */
@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountController() {
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
		
		CompteDAO compteDAO = new CompteDAO();
		ClientDAO clientDAO = new ClientDAO();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String CIN = request.getParameter("CIN");
		String account_number = request.getParameter("compte_numero");
		Double solde = Double.parseDouble(request.getParameter("solde"));
		
		Compte compte = new Compte(account_number, solde);
		compteDAO.createAccount(compte);
		compte = compteDAO.getAccount(account_number);
		
		Model.Client client = new Model.Client(nom, prenom, CIN, compte);
		clientDAO.createClient(client);
		request.setAttribute("client", client);

		this.getServletContext().getRequestDispatcher("/account-created.jsp").forward(request, response);
		
		
	}

}
