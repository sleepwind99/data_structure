public class minheap {
    public int[] h;
    public int index;
    public minheap(int k){
        index = 0;
        h = new int[k];
        for(int i = 0; i < k; i++) h[i] = Integer.MAX_VALUE;
    }

    public int delete(){
        if(index == 0) return -1;
        int k = h[0];
        swap(0, index-1);
        down(0);
        index--;
        return k;
    }

    private void down(int x){
        int swidx = x*2+1;
        if(h[swidx] > h[swidx+1]) swidx++;
        if(swidx > h.length-1) return;
        if(h[x] > h[swidx]){
            swap(x, swidx);
            down(swidx);
        }
    }

    public void insert(int x){
        h[index] = x;
        flow(index);
        index++;
    }

    private void flow(int x){
        if(x == 0) return;
        if(h[x] < h[(x-1)/2]) swap(x, (x-1)/2);
        flow((x-1)/2);
    }

    private void swap(int x, int y){
        int tmp = h[x];
        h[x] = h[y];
        h[y] = tmp;
    }
}
