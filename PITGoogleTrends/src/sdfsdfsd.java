import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class sdfsdfsd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("C:/Users/Jean/Desktop/PIT_GoogleTrends/Download.csv");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
		LinkedList<String> lines = new LinkedList();
		String readLine;

		while ((readLine = in.readLine()) != null) {
		    lines.add(readLine);
		}

		for (String line : lines) {
		    System.out.println("> " + line);
		}
	}

}
