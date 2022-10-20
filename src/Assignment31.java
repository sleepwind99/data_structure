import java.io.*;
public class Assignment31 {
    public static void main(String[] args) {
        try {
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wt = new BufferedWriter(new FileWriter("output.txt"));
            int n;
            String in, inst, data;
            stack s = new stack();
            n = Integer.parseInt(rd.readLine());
            for (int i = 0; i < n; i++) {
                in = rd.readLine();
                inst = in.substring(0, 1);
                if (inst.equals("e")) {
                    wt.write(s.peek());
                    wt.newLine();
                } else if (inst.equals("o")) {
                    wt.write(s.pop());
                    wt.newLine();
                } else if (inst.equals("u")){
                    data = in.substring(2);
                    s.push(data);
                }
            }
            rd.close();
            wt.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

class ptr {
    public String str;
    public ptr node;
}

class stack {
    public ptr first;

    public stack() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String s) {
        ptr newptr = new ptr();
        newptr.str = s;
        if (isEmpty()) {
            first = newptr;
        } else {
            newptr.node = first;
            first = newptr;
        }
    }

    public String pop() {
        if (isEmpty()) return "empty";
        else {
            String a = first.str;
            first = first.node;
            return a;
        }
    }

    public String peek() {
        if (isEmpty()) return "empty";
        else return first.str;
    }
}
