public class BST {
    public static void main(String[] args){
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        BSTNode bry;
        new BSTNode();
        bry = binary(a,0,9);
        searchtree(bry,5);
        insertnode(bry,10);
        searchtree(bry,10);
    }
    public static BSTNode binary(int[] arr,int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        BSTNode newnode = new BSTNode();
        newnode.data = mid;
        newnode.left = binary(arr,start,mid-1);
        newnode.right = binary(arr,mid+1,end);
        return newnode;

    }
    public static void insertnode(BSTNode start,int x) {
        if (start.data < x) {
            if (start.right == null) {
                BSTNode newnode = new BSTNode();
                newnode.data = x;
                start.right = newnode;
                return;
            } else insertnode(start.right, x);
        } else if (start.data > x) {
            if (start.left == null) {
                BSTNode newnode = new BSTNode();
                newnode.data = x;
                start.left = newnode;
                return;
            } else insertnode(start.left, x);
        } else System.out.println("This data is not inserted!");
    }
    //public static int deletetree(BSTNode start, int x){

    //}
    public static void searchtree(BSTNode start, int find){
        if(start == null) {
            System.out.println("Data is not in tree!");
            return;
        }
        if(find<start.data){
            System.out.println("Data is smaller than "+ start.data);
            searchtree(start.left,find);
        }
        else if(find>start.data){
            System.out.println("Data is bigger than "+start.data);
            searchtree(start.right,find);
        }
        else if(find == start.data) System.out.println("Data is finded!");
    }
}
