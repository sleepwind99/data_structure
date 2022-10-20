public class selection {
    public static void main(String[] args){

    }
    public static void selectionsort(int[] a, int n){
        int j, tmp;
        for(int i = 0;i < n - 1; i++){
            j = i;
            for(int k = i + 1; k < n; k++) if( a[k] < a[j] ) j = k;
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
