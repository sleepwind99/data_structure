public class BSTIter {
    public static void main(String[] args){

    }
}
class Node{
    public int data;
    public Node left, right;
}

class sNode{
    public Node cur, next;
}

class Stack{
    public sNode start;
    public boolean isEmpty(){return start.cur == null;}
    public Node pop(){
        Node popnode = new Node();
        popnode = start.cur;
        start.cur = start.next;
        return popnode;
    }
    public void push(Node x){
        if(isEmpty()) start.cur = x;
        else{
            sNode newnode = new sNode();
            newnode.cur = x;
            newnode.next = start.cur;
            start.cur = newnode.cur;
        }
    }
    public Node peek(){return start.cur;}
}

class tree{
    private Node root;
    public PreIter getPreIter(){return new PreIter(root);}
    public PostIter getPostIter(){return new PostIter(root);}
    public InIter getInIter(){return new InIter(root);}
}

class PostIter{
    Stack s;
    public PostIter(Node n){
        s = new Stack();
        pushnext(n);
    }
    public void pushnext(Node n){
        while(n != null){
            s.push(n);
            if(n.left == null) n = n.right;
            else n = n.left;
        }
    }
    public int getdata(){
        if(isEnd()) return -1;
        return s.peek().data;
    }
    public void next(){
        if(isEnd()) return;
        Node prev = s.pop();
        if(!s.isEmpty()) if(s.peek().left == prev) pushnext(s.peek().right);
    }
    public boolean isEnd(){ return s.isEmpty(); }
}

class InIter{
    Stack s;
    public boolean isEnd(){ return s.isEmpty(); }
    public int getdata(){
        if(isEnd()) return -1;
        return s.peek().data;
    }
    public InIter(Node n){
        s = new Stack();
        pushleft(n);
    }
    public void next(){
        if(isEnd()) return;
        Node n = s.pop();
        if(n.right != null) pushleft(n.right);
    }
    public void pushleft(Node n){
        while(n!=null) {
            s.push(n);
            n = n.left;
        }
    }
}

class PreIter{
    Stack s;
    public boolean isEnd(){return s.isEmpty();}
    public int getdata(){
        if(isEnd()) return -1;
        return s.peek().data;
    }
    public PreIter(Node n){
        s = new Stack();
        if(n != null) s.push(n);
    }
    public void next(){
        if(isEnd()) return;
        Node n = s.pop();
        if(n.right != null) s.push(n.right);
        if(n.left != null) s.push(n.left);
    }
}