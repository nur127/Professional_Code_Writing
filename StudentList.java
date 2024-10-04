import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String fileReader (String fileName){
		String inputString ;
		try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName))); 

							inputString = fileReader.readLine();
							fileReader.close();
		} catch (Exception e) {
			return e.getMessage();
		}
		return inputString;
	}

	public static String fileWriter(String fileName , String dataName){
		try {
			BufferedWriter fileWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
	        Date d = new Date();
	        String dateFormation = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateFormation);

			fileWriter.write(", "+dataName+"\nList last updated on "+ dateFormat.format(d));
			fileWriter.close();
			
		} catch (Exception e) {
			return (e.getMessage());
		}
		return  "Succesfully Writed";

	}


	public static void main(String[] args) {

		Constant constants = new Constant() ;

//		Check arguments
	boolean isValidArg = true ;

	while(isValidArg)
	{
		if(args[0].equals("a"))
		 {
			isValidArg = false ;
			System.out.println(constants.LOADING_MESSAGE);			

			
			String read = fileReader("students.txt");
			String i[] = read.split(",");			
			for(String j : i)
			 {
				 System.out.println(j);
			 }
			System.out.println(constants.LOADING_MESSAGE);
		}

		else if(args[0].equals("r")) 
		{
			isValidArg = false ;
			System.out.println(constants.LOADING_MESSAGE);			
	
			String inputString = fileReader("students.txt");
			String i[] = inputString.split(",");	
			Random randomNumber = new Random();
			System.out.println(i[randomNumber.nextInt()]);
			System.out.println(constants.LOADING_MESSAGE);			
		}
		else if(args[0].contains("+"))
		{
			isValidArg = false ;
			System.out.println(constants.LOADING_MESSAGE);	

			String name = args[0].substring(1);
			fileWriter("student.txt" ,name);

			System.out.println(constants.LOADING_MESSAGE);	
		}
		else if(args[0].contains("?")) 
		{
			isValidArg = false ;
			System.out.println(constants.LOADING_MESSAGE);			
	
			String r = fileReader("students.txt");
			String i[] = r.split(",");	
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length && !done; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			System.out.println(constants.LOADING_MESSAGE);				
		}
		else if(args[0].contains("c")) 
		{
			isValidArg = false ;
			System.out.println(constants.LOADING_MESSAGE);			
			
			String D = fileReader("students.txt");
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
			System.out.println(constants.LOADING_MESSAGE);				
		}

		else{
			System.out.println(constants.WRONG_ARGUMENT_MESSAGE);

			Scanner scanner = new Scanner(System.in);
			String getarg = scanner.nextLine();
			args = getarg.split("//s+");
			isValidArg = true ;

		}
	}
	}
}