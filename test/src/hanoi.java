public class hanoi {
    public static void main(String[] args){
        hanoi(3,1,3,2);
    }
    public static void hanoi(int n,int from, int to, int by){
        if(n==1){
            System.out.println(from + " to " + to);
            return;
        }
        hanoi(n-1, from, by, to);
        System.out.println(from + " to " + to);
        hanoi(n-1,by, to, from);

    }
}
