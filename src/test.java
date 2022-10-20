public class test {
    public static void Hanoi(int n, int from,int to,int by){
        if(n==1){
            System.out.println(from + " to "+ to);
            return;
        }
        Hanoi(n-1,from,by,to);
        System.out.println(from + " to " +  to);
        Hanoi(n-1,by,to,from);
    }

    public static void main(String[] args){
        Hanoi(4,1,2,3);
    }
}
