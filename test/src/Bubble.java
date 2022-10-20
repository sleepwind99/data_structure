public class Bubble {
    public static void main(String[] args){
        int[] arr = {7,6,5,4,3,2,1};
        int a = bubble(arr, 7);
        System.out.println(a);
    }
    public static int bubble(int[] arr, int n){
        boolean sort;
        int k = 0;
        do{
            sort = true;
            for(int i=0;i<n-1;i++){
                if(arr[i] > arr[i+1]){
                   int tmp = arr[i];
                   arr[i] = arr[i+1];
                   arr[i+1] = tmp;
                   sort = false;
                   k++;
                   break;
                }
            }
        }while(!sort);
        return k;
    }
}
