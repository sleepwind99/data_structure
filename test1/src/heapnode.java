public class heapnode {
    public hNode h;
    public void heapify(){
        if(h == null) return;
        int tmp;
        if(h.data < h.left.data){
            tmp = h.data;
            h.data = h.left.data;
            h.left.data = tmp;
        }
        if(h.data < h.right.data){
            tmp = h.data;
            h.data = h.right.data;
            h.right.data =tmp;
        }

    }
    public void insert(int x){

    }
}
class hNode{
    int data;
    hNode left, right, parent;
}