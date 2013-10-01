package mysh;

import java.io.IOException;


public class Mysh{
	
	private Mysh(){}
	
	public static void execute(String[] cmd) throws IOException, InterruptedException{
		Process p = new ProcessBuilder(cmd).start();
		int exitValue = p.waitFor();
		if(exitValue == 0){
			System.out.println("Process exited normally");
		}else{
			System.out.printf("Process exited abnormally. Error %d.%n", exitValue);
		}
	}
	
}
