import java.io.*;

public class generator {
    public static void main(String[] args){
        BufferedWriter wr;
        try{
            wr = new BufferedWriter(new FileWriter("input.txt"));
            wr.write("10001 10000");
            for(int i = 0; i < 10000; i++){
                wr.newLine();
                wr.write(Integer.toString(i)+" "+Integer.toString(i+1));
            }
            wr.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }

    }
}
