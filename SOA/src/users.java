import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; 

public class users {
	static PrintWriter pw;
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pw = new PrintWriter(new FileWriter("Data/Users_all.csv"));
		br = new BufferedReader(new FileReader("Data/Users.xml"));  
		int cnt = 0,check=0;

		String line = br.readLine();
		try
		{
			line = br.readLine();
			line = br.readLine();
			while(line!=null)
			{ 
				Document doc = (Document) Jsoup.parse(line);
				Element row = ((Element) doc).select("row").first();  
//				if(row.attr("Id")!=""&&row.attr("Location")!=""&&row.attr("reputation")!=""&&row.attr("Age")!=""&&row.attr("Id")!=null&&row.attr("Location")!=null&&row.attr("reputation")!=null&&row.attr("Age")!=null)
//					{
						pw.println(row.attr("Id")+":\t:"+row.attr("reputation")+":\t:"+row.attr("Location")+":\t:"+row.attr("Age"));
						cnt++;
						check=1;
						pw.flush();
//					}
				line = br.readLine();
				if(cnt%10000==0&&check==1)
				{
					System.out.println(cnt);
					check=0;
				} 
			}
		}
		catch(Exception e)
		{
			System.out.println(line);
			// e.printStackTrace();
		}
		System.out.println(cnt);
		pw.close();
		br.close();
	}
}
