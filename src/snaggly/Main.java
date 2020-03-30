package snaggly;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//Check args
		if (args.length < 2) {
			printError("Invalid arguments! At least 2 arguments expected.\nSyntax: gmsSE.jar InputFile OutputDirectory");
			return;
		}
		
		//Begin extraction
		try {
			AUDO t = Reader.lookupType(args[0], new AUDO());
			Extractor<AUDO> ext = new Extractor<AUDO>(args[0], args[1], t);
			ext.extract();
		}
		catch(IOException err) {
			printError("Error reading file!\n" + err.getMessage());
		}
		catch (UnexpectedFileException err) {
			printError("Wrong or corrupted file!\n" + err.getMessage());
		}
	}
	
	public static void printError(String text) {
		System.out.println(text);
	}

}
