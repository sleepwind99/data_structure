public class insertion {
    public static void insertionsort(int[] a, int n){
        int j, tmp;
        for(int i=0;i<n;i++){
            tmp = a[i];
            for(j=i-1;j>=0;j--){
                if(a[j]>=tmp) break;
                a[j+1] = a[j];
            }
            a[j+1] = tmp;
        }
    }
}
