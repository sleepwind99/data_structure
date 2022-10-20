import java.io.*;
public class Assignment51 {
    public static void main(String args[]){
        BufferedReader rd;
        BufferedWriter wr;
        int				vt, eg, pos, start, end;
        String          s;
        long			starttime, elapsedtime;
        graph g;
        try {
            rd = new BufferedReader(new FileReader("input.txt"));
            s = rd.readLine();
            pos = s.indexOf(" ");
            vt = Integer.parseInt(s.substring(0, pos));
            eg = Integer.parseInt(s.substring(pos + 1));
            g = new graph(vt);
            for (int i = 0; i < eg; i++) {
                s = rd.readLine();
                pos = s.indexOf(" ");
                start = Integer.parseInt(s.substring(0, pos));
                end = Integer.parseInt(s.substring(pos + 1));
                g.edge(start,end);
            }
            rd.close();

            starttime = System.nanoTime();
            g.bic();
            elapsedtime = System.nanoTime() - starttime;

            System.out.println(Double.toString((double)elapsedtime / 1000000000));

            wr = new BufferedWriter(new FileWriter("output.txt"));
            wr.write(Integer.toString(g.ans));
            wr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
