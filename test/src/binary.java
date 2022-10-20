public class binary {
    public static void main(String[] arg){
        int[] a = {1,2,3,4,10,15,18,19,20,21,85,101,111,120,121,130};
        System.out.println(binarySearch(0,15,a,2));

    }
    public static int binarySearch(int start,int end, int[] arr, int data){
        if(arr[start] == data) return start;
        else if(start<end){
            int mid = (start+end)/2;
            if(data <= arr[mid]) return binarySearch(start,mid,arr,data);
            else return binarySearch(mid+1,end,arr,data);
        }
        else return -1;
    }
}
