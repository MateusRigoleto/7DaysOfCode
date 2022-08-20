import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		
		try {
		Scanner sc = new Scanner(new File("keyimdb.txt"), "UTF-8");
		String key = sc.nextLine();	
		String json = (new ImdbApiClient(key).getJson());
		
		List<Movie> movies =(new ImdbMovieJsonParser(json).parse());
		System.out.println(movies.size());
		System.out.println(movies.get(0));
		
		PrintWriter writer = new PrintWriter("content.html");
		new HtmlGenerator(writer).generate(movies);
		writer.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	



	

}