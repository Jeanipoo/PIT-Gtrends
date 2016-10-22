

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ControllerDoArquivoCSV")
public class ControllerDoArquivoCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome"); // Parâmetro oriundo da chamada JQuery
        String aniversario = request.getParameter("niver"); // Parâmetro oriundo da chamada   JQuery
        Pessoa pessoa = new Pessoa();
        pessoa.Nome = nome;
        pessoa.Aniversario = aniversario;
        System.out.println("uhuuuul");
        //try {
        //     pessoa.Inserir();
       //}catch (ClassNotFoundException | SQLException e) {
       //      e.printStackTrace();
       //}
        //String funcionou = "AH GAROTO!";
        /*valores funcionou1 = new valores();
        funcionou1.atributo = "SHOW";
        funcionou1.valor = 90;
        ArrayList<valores> funcionou = new ArrayList<valores>();
        funcionou.add(funcionou1);
        valores funcionou2 = new valores();
        funcionou2.atributo = "SHOW2";
        funcionou2.valor = 902;
        funcionou.add(funcionou2);
        */
		arquivoCSV funcionou = new arquivoCSV();
		funcionou.ler();
        
		String JSONok = "";
		JSONok = new Gson().toJson(funcionou);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONok);
   }
}
