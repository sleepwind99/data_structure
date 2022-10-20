public class quick {
    public static void main(String[] args){
        int[] a ={5,4,3,2,8,9,0,7,6,1};
        quick(a,0,9);
        for(int i =0;i<10;i++){
            System.out.println(a[i]);
        }
    }
    public static void quick(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot, j, tmp;
        pivot = start;
        j = start;
        for(int i = start+1;i<=end;i++){
            if(arr[i] < arr[pivot]){
                j++;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        tmp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = tmp;
        quick(arr,start,j-1);
        quick(arr,j+1,end);
    }
}
