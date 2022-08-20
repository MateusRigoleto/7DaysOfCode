import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
//Classe responsavel por consumir a API
public class ImdbApiClient {
	
	private String key;
	private String url;
	
	public ImdbApiClient(String key,String url) {
		this.key = key;
		this.url = url;
	}
	
	public String getJson(){
		try {
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(url + key)).GET().timeout(Duration.ofSeconds(10)).build();
		HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();		 
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());		 
		return response.body();
		}
		catch (FileNotFoundException | IllegalArgumentException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "erro ao se comunicar com API";
	}
}

//"https://imdb-api.com/en/API/Top250Movies/"