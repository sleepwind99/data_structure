public class heapricution {
    public static void main(String[] args){
        int[] a ={0,6,4,5,8,9,7,1,2,3};
        heapsort(a, 10);
        for(int i=0;i<10;i++) System.out.println(a[i]);
    }
    public static void heap(int[] arr, int size){
        for(int mid = size/2-1;mid>=0;mid--){ heapify(arr, size, mid);}
    }
    public static void heapify(int[] arr,int size, int mid){
        int p = mid;
        int LC = mid*2+1;
        int RC = mid*2+2;
        int large = p;
        if(LC < size && arr[LC] > arr[large]) large = LC;
        if(RC < size && arr[RC] > arr[large]) large = RC;
        if(large != p){
            int tmp = arr[large];
            arr[large] = arr[p];
            arr[p] = tmp;
            heapify(arr, size, large);
        }
    }
    public static void heapsort(int[] arr, int size){
        heap(arr, size);
        for(int i = size-1;i>=0;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr,--size,0);
        }
    }
}
