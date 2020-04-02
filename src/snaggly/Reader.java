package snaggly;

import java.io.IOException;

public class Reader {
	
	public static <T extends IType> T lookupType(String inputFile, T type) throws IOException, UnexpectedFileException{
		IntInputFileStream stream = new IntInputFileStream(inputFile);
		String typeCheck = type.getType();
		
		if (stream.readInt() != 1297239878) {
			stream.close();
			throw new UnexpectedFileException("FORM not found!");
		}

		//Seek for the offset for given type in file
		Logger.print("Looking for the container...");
		int currentPos = 0;
		int maxSize = stream.readInt();
		char[] buffer = new char[typeCheck.length()];
				
		while (currentPos < maxSize) {
			for (byte b = 0; b<typeCheck.length(); b++) {
				buffer[b] = (char) stream.read();
			}
			if (String.copyValueOf(buffer).equals(typeCheck)) {
				break;
			}
			int r = stream.readInt();
			currentPos += typeCheck.length() + r;
			stream.skip(r);
		}
		
		//Throw exception if type wasn't found
		if (currentPos >= maxSize || stream.available() <= 0) {
			stream.close();
			throw new UnexpectedFileException();
		}
		
		Logger.print("Found " + typeCheck + " @ " + currentPos);
		
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
