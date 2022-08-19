import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movie {
	
	private String title;
	private String urlImage;
	private String rating;
	private String year;

	
	
	public Movie(String title, String urlImage, String rating, String year){
		this.title = title;
		this.urlImage = urlImage;
		this.rating = rating;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Filme: " + title + " Url imagem: " +urlImage+ " rating: "+ rating+ " ano: " + year;
	}
	
}
