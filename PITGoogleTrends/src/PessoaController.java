

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PessoaController")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome"); // Parâmetro oriundo da chamada JQuery
        String aniversario = request.getParameter("niver"); // Parâmetro oriundo da chamada   JQuery
        Pessoa pessoa = new Pessoa();
        pessoa.Nome = nome;
        pessoa.Aniversario = aniversario;
        System.out.println("uhuuuul");
        try {
             pessoa.Inserir();
       }catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
       }
   }
}
