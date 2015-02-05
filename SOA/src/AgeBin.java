import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AgeBin {
	
	
	static long[] frequency = {0,0,0,0,0,0,0} ;
	static BufferedReader br;
	static String line;
	public static void main (String[] args) throws IOException{
	br = new BufferedReader(new FileReader("Age.txt"));  
	int value;

	line = br.readLine();
	while(line!= null ){
		
		value = Integer.parseInt(line);
		value = (value/10) - 1 ;
		frequency[value]++;
		line = br.readLine();
	}
	int i;
	for(i=0;i<7;i++)
	{
		System.out.println(frequency[i]);
	}
		
	}
	
	

}
