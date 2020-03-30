package snaggly;
import java.util.LinkedList;

public class AUDO implements IType{
	public final String getType() {
		return "AUDO";
	}
	
	private int chunkSize;
	private int chunkCount;
	private LinkedList<Integer> offsets = new LinkedList<Integer>();

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
