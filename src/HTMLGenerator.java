import java.io.PrintWriter;
import java.util.List;
//Classe responsavel por gerar o HTML
class HtmlGenerator {

	private final PrintWriter writer;

	public HtmlGenerator(PrintWriter writer) {
		this.writer = writer;
	}

	public void generate(List<Movie> movies) {
		writer.println("<html>");
			writer.println("<head>");
			writer.println("<meta charset=\"utf-8\">");
			writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
			writer.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"+ \"integrity=\\\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\\\" crossorigin=\\\"anonymous\\\">"); 
			writer.println("</head>");
		writer.println("<body>");

		for (Movie movie : movies) {
			String div =
			
			"<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">"
				+"<h4 class=\"card-header\">%s</h4>"
				+"<div class=\"card-body\">"
					+"<img class=\"card-img\" src=\"%s\" alt=\"%s\">"
					+"<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>"
				+"</div>"
			+"</div>";
			
			
			writer.println(String.format(div, movie.getTitle(), movie.getUrlImage(), movie.getTitle(), movie.getYear(), movie.getRating()));
		}

				
		writer.println("</body>");
		writer.println("/html>");
	}

}
