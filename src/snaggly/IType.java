package snaggly;
import java.util.LinkedList;

public interface IType {
	public String getType();
	public String getFileName();
	public int getChunkSize();
	public int getChunkCount();
	public void setChunkSize(int value);
	public void setChunkCount(int value);
	public LinkedList<Integer> getOffsets();
}
