import java.io.*;

public class App001 {
	public static void main(String[] args) {
		try {
			BufferedWriter  wr = new BufferedWriter(new FileWriter("input.txt"));
			int n = 5000000;
			wr.write(n+" "+(n-1));
			wr.newLine();
			wr.write(0+" "+(n-1));
			wr.newLine();
			for(int i = 0; i<n-1; i++) {
				wr.write(i+" "+(i+1));
				wr.newLine();
			}
			
		wr.close();
		}
		catch (Exception e) { 
			System.out.println("ERROR"); 
		}
		
		
	}
}
