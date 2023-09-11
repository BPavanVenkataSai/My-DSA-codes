public class InsertionSort {
    static void IS(int arr[], int n){
        for(int i=1;i<n;i++){
            int j = i-1;
            int x = arr[i];
            while(j>=0 && arr[j]>x){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }
    }
    public static void main(String[] args) {
        int[] arr = {176 ,-272, -272, -45, 269, -327, -945, 176};
        IS(arr,arr.length);
        System.out.println(arr);
        
    }
}
