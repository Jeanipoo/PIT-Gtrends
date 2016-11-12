

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        String termo = request.getParameter("termo");
        
        arquivoCSV csv = new arquivoCSV();
		termo = termo.replace(" ", "%20");
        csv.download(termo);
		csv.ler();
		termo = termo.replace("%20", "_");
		DateFormat dateFormat2 = new SimpleDateFormat("HHmmss_ddMMyyyy");
		Date date2 = new Date();
		System.out.println(dateFormat2.format(date2));
		Path from = Paths.get("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\Download.csv");
		Path to = Paths.get("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\" + termo + dateFormat2.format(date2) + ".csv");
		try {
			Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String JSONok = "";
		JSONok = new Gson().toJson(csv);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONok);
   }
}
