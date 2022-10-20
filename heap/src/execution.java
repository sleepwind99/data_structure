public class execution {
    public static void main(String[] args){
        minheap h = new minheap(20);
        h.insert(3);
        h.insert(6);
        h.insert(8);
        h.insert(4);
        h.insert(5);
        h.insert(10);
        h.insert(9);
        h.insert(7);
        h.insert(1);
        h.insert(11);
        System.out.println(h.h[0]+" "+h.h[1]+" "+h.h[2]+" "+h.h[3]+" "+h.h[4]+" "+h.h[5]+" "+h.h[6]+" "+h.h[7]+" "+h.h[8]+" "+h.h[9]+" ");
        System.out.println(h.index+" "+h.delete()+" "+h.index);
    }
}
