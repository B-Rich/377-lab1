package mysh;

import java.io.InputStream;
import java.util.Scanner;


public class CommandReader{
	
	private Scanner scanner;
	
	public CommandReader(InputStream is){
		this.scanner = new Scanner(is);
	}
	
	public String readCommands(){
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.toLowerCase().equals("exit")){
				break;
			}else{
				Mysh.execute(line);
			}
		}
		return null;
	}
	
}
