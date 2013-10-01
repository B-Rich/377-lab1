package mysh;


public class Main{
	
	public static void main(String[] args){
		CommandReader cr = new CommandReader(System.in);
		while(true){
			cr.readCommands();
		}
	}
	
}
