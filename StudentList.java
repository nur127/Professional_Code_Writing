import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
	boolean isValidArg = true ;

	while(isValidArg)
	{
		if(args[0].equals("a"))
		 {
			isValidArg = false ;
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String read = fileReader.readLine();
			String i[] = read.split(",");			
			for(String j : i)
			 {
				 System.out.println(j);
			 }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r")) 
		{
			isValidArg = false ;
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String read = fileReader.readLine();
			System.out.println(r);
			String i[] = read.split(",");	
			Random x = new Random();
			int y = x.nextInt();
			System.out.println(i[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			isValidArg = false ;
			System.out.println("Loading data ...");			
			try {
			BufferedWriter fileWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
			String write = args[0].substring(1);
	        Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			fileWriter.write(", "+write+"\nList last updated on "+fd);
			fileWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			isValidArg = false ;
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String r = fileReader.readLine();
			String i[] = r.split(",");	
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length && !done; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			isValidArg = false ;
			System.out.println("Loading data ...");			
			try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String D = fileReader.readLine();
			char a[] = D.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char c:a) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}

		else{
			System.out.println("Invalid Argument . Please Give an valid Argument like : (a,r,c) ?Studentname +Studentname + Studentname ");

			Scanner scanner = new Scanner(System.in);
			String getarg = scanner.nextLine();
			args = getarg.split("//s+");
			isValidArg = true ;

		}
	}
	}
}