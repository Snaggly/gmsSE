package snaggly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IntInputFileStream extends FileInputStream{
	
	public IntInputFileStream(String name) throws FileNotFoundException {
		super(name);
	}
	
	//Careful! Does not detect if end of stream!!
	public int readInt() throws IOException {
		int result = 0;
		
		for (byte b=0;b<4;b++) {
			result |= super.read()<<b*8; //Little-endian First byte is LSB
		}
		
		return result;
	}

}
