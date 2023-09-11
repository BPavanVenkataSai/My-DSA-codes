public class MergeSort {
    static void MS(int arr[],int lo, int hi){
        if(lo==hi)
            return ;
        int m = (lo+hi)/2;
        MS(arr,lo,m);
        MS(arr,m+1,hi);
        Merge(arr,lo,m,hi);
    }
    static void Merge(int arr[],int lo ,int m, int hi){
        int p1 = lo, p2= m+1;
        int[] temp = new int[hi-lo+1];
        int k=0;
        while(p1<=m && p2<=hi){
            if(arr[p1]<arr[p2]){
                temp[k] = arr[p1];
                p1++;
            }else{
                temp[k] = arr[p2];
                p2++;
            }
            k++;
        }
        while(p1<=m){
            temp[k] = arr[p1];
            k++;
            p1++;
        }
        while(p2<=hi){
            temp[k] = arr[p2];
            k++;
            p2++;
        }
        for(int i=0;i<hi-lo+1;i++){
            arr[lo+i] = temp[i];
        }
    }
}
