public class executation {
    public static void main(String[] args){
        rbtree rb = new rbtree();
        rb.insert(55);
        rb.insert(56);
        rb.insert(44);
        rb.insert(66);
        rb.insert(76);
//        rb.insert(60);
//        rb.insert(40);
//        rb.insert(45);
//        rb.insert(47);
        if(rb.find(54)) System.out.println("find");
        rb.delete(54);
        if(!rb.find(54)) System.out.println("Not find");
        System.out.println(rb.root.key+" "+rb.root.left.key+" "+rb.root.left.right+" "+rb.root.right.key);
        System.out.println(rb.root.color+" "+rb.root.left.color+" "+rb.root.left.right+" "+rb.root.right.color);
//        System.out.println(rb.root.key+" "+rb.root.left.key+" "+rb.root.right.key+" "+rb.root.right.right.key);
//        System.out.println(rb.root.color+" "+rb.root.left.color+" "+rb.root.right.color+" "+rb.root.right.right.color);
    }
}
