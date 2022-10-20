public class heaparray {
    public static void main(String[] args){
        int[] a = {7,8,5,4,6,2,3,1,9,0};
        heapify(a,10);
        heapsort(a,10);
        for(int i =0;i<10;i++)System.out.println(a[i]);
    }
    public static void heapify(int[] arr, int n) {
        for(int i = n/2-1; i >= 0;i--){
            int root = i;
            int child = root*2 +1;
            while(child < n) {
                if (child+1 < n) if(arr[child] < arr[child+1]) child++;
                if (arr[child] > arr[root]) {
                    int tmp = arr[child];
                    arr[child] = arr[root];
                    arr[root] = tmp;
                }
                root = child;
                child = root*2 +1;
            }
        }
    }
    public static void heapsort(int[] arr, int n){
        for(int i = n - 1;i>=0;i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, --n);
        }
    }
}
