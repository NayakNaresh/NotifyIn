package resume.parser.poc;

public class ParserFactory {
	
	public Parser getParser(String s){
		if(s.equalsIgnoreCase("pdf")){
			return new PdfParser();
		}
		return new TextParser();
	}

}
