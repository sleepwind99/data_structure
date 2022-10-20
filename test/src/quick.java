public class quick {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quicksort(a, 0, 9);
        for (int i=0;i<10;i++) System.out.print(a[i]);
    }
    public static void quicksort(int[] arr,int start, int end){
        int pivot, tmp, i, j;
        if(start>=end) return;
        pivot = arr[start];
        j= start; //Replaceable
        for(i = start + 1; i<=end; i++){
            if(arr[i]<pivot){
                j++;
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        tmp = arr[start];
        arr[start] = arr[j];
        arr[j] = tmp;
        quicksort(arr, start, j-1);
        quicksort(arr,j+1, end);
    }
}
