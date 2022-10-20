public class merge {
    public static void main(String[] args){
        int[] a = {3,9,4,7,5,0,1,6,8,2};
        int[] arr = new int[a.length];
        printarr(a);
        mergesort(a, 0, 9, arr);
        printarr(a);
    }
    public static void mergesort(int[] a,int start, int end, int[] arr){
        if(start<end){
            int mid = (start+end)/2;
            mergesort(a, start, mid, arr);
            mergesort(a,mid+1,end, arr);
            merge(a,start,end, mid, arr);
        }
    }
    public static void merge(int[] a, int start, int end, int mid, int[] arr){
        for(int i = start;i<=end;i++) arr[i] = a[i];
        int left = start;
        int right = mid+1;
        int index = start;
        while(left<=mid && right <=end){
            if(arr[left]>=arr[right]) a[index++] = arr[right++];
            else a[index++] = arr[left++];
        }
        while(left <= mid) a[index++] = arr[left++];
        while(right <= end) a[index++] = arr[right++];
    }
    private static void printarr(int[] arr){
        for(int data:arr) System.out.print(data + ", ");
        System.out.println();
    }
}
