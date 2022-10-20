public class StackAndQueue {

}

class stack{
    private char[] arr;
    private int first;
    private int size;
    public stack(int s){
        arr = new char[s];
        size = s;
        first = -1;
    }
    public boolean isEmpty() { return (first == -1); }
    public boolean isFull(){ return(first == size-1); }
    public void push(char k){
        if(!isFull()) arr[++first] = k;
        else return;
    }
    public char pop(){
        if(!isEmpty()) return arr[first--];
        else return ' ';
    }
    public char peek(){
        if(!isEmpty()) return arr[first];
        else return ' ';
    }
}

class CircleQueue{
    private int[] arr;
    private int size, first, last;
    public CircleQueue(int s){
        arr = new int[++s];
        size = s;
        first = --s;
        last = 0;
    }
    public boolean isFull(){ return (first + 2)%size == last;}
    public boolean isEmpty(){return (first + 1)%size == last;}

    public void CircleEnqueue(int k){
        if(!isFull()){
            first = (first+1) % size;
            arr[first] = k;
        }
    }
    public int CircleDequeue(){
        int ret;
        if(!isEmpty()){
            ret = arr[last];
            last = (last+1) % size;
            return ret;
        }
        else return -1;
    }
}

class queue{
    private int[] arr;
    private int first, last;
    private int size;
    public queue(int s){
        arr = new int[s];
        first = -1;
        last = 0;
        size = s;
    }
    public boolean isEmpty(){return (first + 1 == last); }
    public boolean isFull(){return (first == size-1);}

    public void Enqueue(int k){
        if(!isFull()) arr[++first] = k;
        else return;
    }
    public int Dequeue(){
        if(!isEmpty()) return arr[last++];
        else return -1;
    }

}
