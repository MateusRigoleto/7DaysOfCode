import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner(new File("keyimdb.txt"), "UTF-8");
		String key = sc.nextLine();
		
		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + key)).GET().timeout(Duration.ofSeconds(5)).build();
		HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
		 
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		 
		System.out.println(response.body());
		}
		catch (FileNotFoundException | IllegalArgumentException ex) {
			System.out.println("Arquivo nao encontrado");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		



		
	}
}