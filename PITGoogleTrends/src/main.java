//  URL para download do CSV - https://www.google.com/trends/trendsReport?date=now%201-H&q=economy&export=1

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.Scanner;

public class main {

	private static final CopyOption REPLACE_EXISTING = null;

	public static void main (String[] args) throws IOException, InterruptedException {
        // Logar no Chrome antes de executar
		// O Eclipse vai abrir a página no Chrome a cada 30 min
		// Não consegui fazer o eclipse escrever a parte final da String no Chrome...  só até antes do primeiro "&"...
		int a = 0;
		int b = 1;
		String pesquisa = null;
		System.out.println("Informe um termo para pesquisar: ");
		Scanner teclado = new Scanner(System.in);
		pesquisa = teclado.nextLine();
		String URL1 = "start chrome https://www.google.com/trends/trendsReport?date=now%201-H^&q=";
		String URL2 = "^&export=1";
		String URL = URL1+pesquisa+URL2;
		while (a == 0){
			System.out.println("Realizando Download");
			Runtime.getRuntime().exec(new String[]{"cmd", "/c", URL});
			Thread.sleep(10000);
			System.out.println("Download número " + b + " realizado com sucesso");
			
			System.out.println("Renomeando arquivo para GoogleTrends000"+b+".csv");
			Path from = Paths.get("C:\\Users\\Jean\\Downloads\\report.csv");
			Path to = Paths.get("C:\\Users\\Jean\\Desktop\\PIT_GoogleTrends\\GoogleTrends000"+b+".csv");
			Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
		//	Files.move(PIT, PIT.resolveSibling("GoogleTrends000"+b+".csv"));

			System.out.println("Aguardando 30 minutos para o próximo download");
			Random R = new Random(50000);
			int c = R.nextInt(50000);
			int Sleep = 1800000+c;
			System.out.println("Random: "+c+" milissegundos a mais");
			System.out.println("---------------------------------------------");
			Thread.sleep(Sleep);
			b++;
		}
    }
}
