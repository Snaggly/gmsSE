package snaggly;
import java.io.*;

public class Extractor<T extends IType> {
	private T type;
	private IntInputFileStream stream;
	
	protected String inputFile;
	protected String outputDir;
	
	//Requires DataType to be decoded by Reader first!!
	public Extractor(String inputFile, String outputDir, T dataType) throws IOException, UnexpectedFileException {
		this.inputFile = inputFile;
		this.outputDir = outputDir;
		this.type = dataType;
	}
	
	//Getting length and extracting data into an Output Stream from each offset
	public void extract() throws IOException {
		for (int i=0; i < type.getChunkCount(); i++) {
			String outputPath = outputDir+"/"+i+type.getFileName();
			int currentOffset = type.getOffsets().get(i);
			Logger.print("Extracting from " + inputFile + "@" + currentOffset + " to " + outputPath);
			FileOutputStream fos = new FileOutputStream(outputPath);
			stream = new IntInputFileStream(inputFile);
			stream.skip(currentOffset);
			int length = stream.readInt();
			for (int j=0; j<length; j++) {
				fos.write(stream.read());
			}
			fos.close();
			stream.close();
		}
		Logger.print("Extraction completed!!");
	}
}
