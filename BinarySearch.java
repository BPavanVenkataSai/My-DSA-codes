public class BinarySearch {
    boolean BSI(int arr[],int n, int k){
        int lo=0;
        int hi = n-1;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(arr[m]==k){
                return true;
            } else if(arr[m]>k){
                hi = m -1;
            }else{
                lo = m +1;
            }
        }
        return false;
    }

    boolean BSR(int arr[], int lo, int hi, int k){
        if(lo>hi)
        return false;
        int m = (lo+hi)/2;
        if(arr[m]==k){
            return true;
        }else if(arr[m]>k){
            return BSR(arr, lo, m-1, k);
        }else{
            return BSR(arr, m+1, hi, k);
        }
    }
}
