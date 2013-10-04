
package mysh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mysh{
	
	public static void prompt(){
		System.out.print("mysh> ");
	}
	
	public static void execute(String[] cmd) throws IOException,
			InterruptedException{
		Process p = new ProcessBuilder(cmd).start();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		// System.out.printf("Output of running %s is:\n",
		// Arrays.toString(command));
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		int exitValue = p.waitFor();
		if(exitValue == 0){
			System.out.println("Process exited normally");
		}else{
			System.out.printf("Process exited abnormally. Error %d.%n",
					exitValue);
		}
	}
	
}
