package snaggly;

import java.io.IOException;

public class Reader {
	
	public static <T extends IType> T lookupType(String inputFile, T type) throws IOException, UnexpectedFileException{
		boolean check = false;
		IntInputFileStream stream = new IntInputFileStream(inputFile);
		char[] typeCheck = type.getType().toCharArray();
		
		//Seek for the offset for given type in file
		while(stream.available() > 0 && !check) {
			for (byte b = 0; b<4; b++) {
				check = stream.read() == typeCheck[b];
			}
		}
		
		//Throw exception if type wasn't found
		if (stream.available() <= 0) {
			stream.close();
			throw new UnexpectedFileException();
		}
		
		//Decoding header data
		type.setChunkSize(stream.readInt());
		type.setChunkCount(stream.readInt());
		
		for (int i=0; i< type.getChunkCount(); i++) {
			type.getOffsets().add(stream.readInt());
		}
		Logger.print(type.getChunkCount() + " track(s) found!");
		
		stream.close();
		
		return type;
	}
	
}
