import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	public String Nome;
	public String Aniversario;
	
	public void Inserir() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection db = null;
		db = DriverManager.getConnection("jdbc:mysql://localhost/dessoft4bim","root","root");
		Statement command = db.createStatement();
		command.execute("insert into pessoa values('" + this.Nome + "','" + this.Aniversario + "')");
	}
}
