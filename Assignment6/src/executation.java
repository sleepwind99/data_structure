public class executation {
    public static void main(String[] args){
        FibHeap k1 = new FibHeap();
        FibHeap k2 = new FibHeap();
        k1.insert(6,"6");
        k1.insert(5,"5");
        k1.insert(4,"4");
        k1.insert(3,"3");
        k2.insert(7,"7");
        k2.insert(8,"8");
        FibHeap k3 = new FibHeap(k1, k2);
//        Node e = new Node();
//        e.key = 10;
//        e.next = e;
//        e.prev = e;
//        e.deg = 1;
//        k3.minroot.next.child = e;
//        e.parent = k3.minroot.next;
//        System.out.println(k3.dgree(k3.minroot));
//        System.out.println(k3.dgree(k3.minroot.next));
        System.out.println(k3.minroot.prev.key+" "+k3.minroot.key+" "+k3.minroot.next.key+" "+k3.minroot.next.next.key+" "+k3.minroot.next.next.next.key);
        k3.deleteMin();
        System.out.println(k3.minroot.key+" "+k3.minroot.child.key+" "+k3.minroot.child.next.key);
        k3.deleteMin();
        System.out.println(k3.minroot.key+" "+k3.minroot.child.next.child.key);
//        System.out.println(k3.minroot.child.child.deg);
//        System.out.println(k3.minroot.next.child.key);
//        System.out.println(k3.minroot.child.key+" "+k3.minroot.child.next.key+" "+k3.minroot.child.next.child.key);
    }
}
