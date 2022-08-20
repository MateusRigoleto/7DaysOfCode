import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Classe responsavel por parsear o JSON
public class ImdbMovieJsonParser {
	private String json;
	
	
	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}
	
	 public List<Movie> parse(){
		 System.out.println(json);
		String[] filmesArray = parseJsonMovies(json);
		
		List<String> titles = parseTitles(filmesArray);		
		List<String> urlImages = parseUrlImages(filmesArray);		
		List<String> years = parseYear(filmesArray);		
		List<String> ratings = parseRating(filmesArray);
		
		List<Movie> movies = new ArrayList<>(titles.size());
		for(int i = 0; i<titles.size();i++) {
			movies.add(new Movie(titles.get(i), urlImages.get(i), years.get(i),ratings.get(i)));
		}
		return movies;
	}
	private static String[] parseJsonMovies(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}

		String[] filmesArray = matcher.group(1).split("\\},\\{");
		filmesArray[0] = filmesArray[0].substring(1);
		int last = filmesArray.length - 1;
		String lastString = filmesArray[last];
		filmesArray[last] = lastString.substring(0, lastString.length() - 1);
		return filmesArray;
	}
	
	private static List<String> parseTitles(String[] filmesArray) {
		return parseAttribute(filmesArray, 3);
	}
	
	private static List<String> parseUrlImages(String[] filmesArray) {
		return parseAttribute(filmesArray, 5);
	}
	
	private static List<String> parseYear(String[] filmesArray) {
		return parseAttribute(filmesArray, 4);
	}

	private static List<String> parseRating(String[] filmesArray) {
		return parseAttribute(filmesArray, 7);
	}

	
	private static List<String> parseAttribute(String[] filmesArray, int pos) {
		return Stream.of(filmesArray)
			.map(e -> e.split("\",\"")[pos]) 
			.map(e -> e.split(":\"")[1]) 
			.map(e -> e.replaceAll("\"", ""))
			.collect(Collectors.toList());
	}
	
}
