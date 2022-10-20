public class merge {
    public static void mergesort(int start, int end, int[] arr, int[] sub){
        if(start>=end) return;
        int mid = (start+end)/2;
        mergesort(start, mid, arr, sub);
        mergesort(mid+1, end, arr, sub);
        merge(start, end, mid, arr, sub);
    }
    public static void merge(int start, int end, int mid, int[] arr, int[] sub){
        for(int i = 0;i<arr.length;i++) sub[i] = arr[i];
        int left = start;
        int right = mid+1;
        int index = start;
        while(left <= mid && right <= end){
            if(sub[left] < sub[right]) arr[index++] = sub[left++];
            else arr[index++] = sub[right++];
        }
        while(left <= mid) arr[index++] = sub[left++];
        while(right <= end) arr[index++] = sub[right++];
    }
}
