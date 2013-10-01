package mysh;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class CommandReader{
	
	private Scanner scanner;
	
	public CommandReader(InputStream is){
		this.scanner = new Scanner(is);
	}
	
	public String readCommands(){
		prompt();
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.toLowerCase().equals("exit")){
				System.out.println("mysh is exiting...");
				break;
			}else if(line.matches("\\s+") || line.isEmpty()){ //handle lines of only whitespace
				prompt();
				continue;
			}else{
				try{
					Mysh.execute(formatCommand(line));
				}catch(IOException e){
					System.out.printf("Cannot run program %s.%n", line);
//					System.err.flush();
				}catch(InterruptedException e){
					System.out.printf("Program %s was interrupted. I am sorry.", line);
//					System.err.flush();
				}finally{
					prompt();
				}
			}
		}
		return null;
	}
	
	public String[] formatCommand(String cmd){
		String[] formatString = cmd.split("\\s+");
		return formatString;
	}
	
	public void prompt(){
		System.out.print("mysh>");
	}
	
}
