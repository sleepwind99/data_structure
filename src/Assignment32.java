public class Assignment32 {
    public static void main(String[] args){
        BST arr = new BST();
        BSTSplit spt = new BSTSplit();
        arr.insert(60);
        arr.insert(47);
        arr.insert(30);
        arr.insert(80);
        arr.insert(50);
        spt.split(arr,100);
        if(spt.bstSmaller.delete(47)) System.out.println("founded!");
        else System.out.println("Not founded!");
        if(spt.bstSmaller.delete(47)) System.out.println("founded");
        else System.out.println("Not founded");
    }
}

