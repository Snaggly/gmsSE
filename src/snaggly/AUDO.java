package snaggly;
import java.util.LinkedList;

public class AUDO implements IType{

	//Private fields
	private int chunkSize;
	private int chunkCount;
	private String fileName = "";

	//Assuming GMS takes wave files for AUDO. Please correct me if I'm wrong
	private String suffix = ".wav";
	private LinkedList<Integer> offsets = new LinkedList<Integer>();

	//Public constructors
	public AUDO(){}

	public AUDO(String fileName){
		this.fileName = fileName;
	}

	//Public methods
	public final String getType() {
		return "AUDO";
	}
	
	public String getFileName() {
		return fileName + suffix;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public int getChunkCount() {
		return chunkCount;
	}

	public void setChunkCount(int chunkCount) {
		this.chunkCount = chunkCount;
	}

	public LinkedList<Integer> getOffsets() {
		return offsets;
	}
}
