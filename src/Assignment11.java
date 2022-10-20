import java.io.*;

public class Assignment11 {
    public static void main(String[] args) {
        try {
            BufferedReader rdfile = new BufferedReader(new FileReader("input.txt")); //Read the file from "input.txt"
            BufferedWriter wtfile = new BufferedWriter(new FileWriter("output.txt")); //Get the write file, "output.txt"

            int linenum, num, min, index, minindex;
            String[] pch; //purchase list
            String con, oneline;

            con = rdfile.readLine(); //Count the list size
            linenum = Integer.parseInt(con); //switch to int
            pch = new String[linenum];

            oneline = rdfile.readLine();
            index = oneline.indexOf(" "); //Divide the letters with the numbers
            pch[0] = oneline.substring(index+1);
            min = Integer.parseInt(oneline.substring(0,index));
            minindex = 0;

            for(int i = 1;i < linenum; i++) { //find the minimum value repeatedly according to the conditions
                oneline = rdfile.readLine();
                index = oneline.indexOf(" ");
                pch[i] = oneline.substring(index+1);
                num = Integer.parseInt(oneline.substring(0,index));
                if(min>num) {
                    minindex = i;
                    min = num;
                }
            }

            wtfile.write(pch[minindex]);
            wtfile.newLine();

            rdfile.close(); //close file
            wtfile.close();
        }
        catch (Exception e) {
            System.out.println("error");
        }

    }
}
