public class Assignment21 {
    public static void main(String[] args){
        CDList A;
        CDIter B;
        int k;
        A = new CDList();
        A.append(1);
        A.append(2);
        A.append(3);
        A.append(4);
        B = A.getIter();
        B.insertBefore(5);
        B.insertBefore(6);
        B.insertBefore(7);


        for(int i = 0; i<10;i++ ){
            System.out.println(B.getValue());
            B.next();
        }
    }
}
