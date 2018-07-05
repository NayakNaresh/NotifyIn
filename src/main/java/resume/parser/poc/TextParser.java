package resume.parser.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextParser implements Parser {

	@Override
	public void parse(String inputFile) {
		File file = new File(inputFile);
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
				System.out.println(st);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}

}
