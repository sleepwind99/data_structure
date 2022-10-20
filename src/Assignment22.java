import java.io.*;
public class Assignment22 {
    public static void main(String[] args){
        try {
            BufferedReader rdfile = new BufferedReader(new FileReader("input.txt")); //Read the file from "input.txt"
            BufferedWriter wtfile = new BufferedWriter(new FileWriter("output.txt")); //Get the write file, "output.txt"
            int size;
            boolean carry = false; //carry point
            boolean zero = true;
            String line1, line2;
            Linkint A, B, C;
            A = new Linkint();
            B = new Linkint();
            C = new Linkint();
            line1 = rdfile.readLine();
            line2 = rdfile.readLine();
            if(Integer.parseInt(line1)>= Integer.parseInt(line2)) size = line1.length(); //largest size of two input data
            else{
                size = line2.length();
                String reg = line1;
                line1 = line2;
                line2 = reg;
            }

            for (int i = 0; i < line1.length(); i++) { //division and accumulation
                int x = Integer.parseInt(line1.substring(i, i + 1));
                A.append(x);
            }
            for (int i = 0; i < line2.length(); i++) { //division and accumulation
                int x = Integer.parseInt(line2.substring(i, i + 1));
                B.append(x);
            }
            for(int i =0;i < size;i++){ //Calculation and Accumulation
                int w = A.reading() - B.reading();
                if(carry) w--;
                if(w<0){
                    C.append(10+w);
                    carry = true;
                }
                else{
                    C.append(w);
                    carry = false;
                }
            }

            while(!C.Isempty()){
                char result = Character.forDigit(C.reading(), 10);
                if(result == '0' && zero) continue;
                else{
                    wtfile.write(result);
                    zero = false;
                }
            }
            if(zero) wtfile.write("0");
            wtfile.close(); //close the file
            rdfile.close();

        }
        catch (Exception e) { System.out.println("error"); }
    }
}

class point{ //Linked list node class
    public int base;
    public point forward;
}

class Linkint{ //Linked list class
    public point begin; //first
    public Linkint(){begin = null;}
    public void append(int k){ //append the element
        point pos;
        pos = new point();
        pos.base = k;
        if(begin == null){
            begin = pos;
            pos.forward = null;
        }
        else{
            pos.forward = begin;
            begin = pos;
        }
    }

    public int reading(){ //output data and move the node
        int k;
        if(!(begin == null)) {
            k = begin.base;
            begin = begin.forward;
            return k;
        }
        else return 0;
    }

    public boolean Isempty(){
        return (begin == null);
    } //Return true if list is empty
}

