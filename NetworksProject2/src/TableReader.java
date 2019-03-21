import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableReader 
{
	
	public static  ArrayList<DataHolder> readData() throws FileNotFoundException
	{
		File routingTable = new File("routingtable.txt");
		Scanner scanner = new Scanner(routingTable);
		
		ArrayList<DataHolder> map = new ArrayList<DataHolder>();
		scanner.useDelimiter(" ");
		String source = scanner.next();
		String destination = scanner.next();
		String address = scanner.next();
		DataHolder dataHolder = new DataHolder(source, destination, address);
		map.add(dataHolder);
		scanner.close();
		return map;
		
	}
	
	
	
}
