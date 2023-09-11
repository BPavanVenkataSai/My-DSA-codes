public class SelectionSort {
    void swap(int a ,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    void SS(int arr[], int n){
        for(int i=0;i<n;i++){
            int min =i;
            for(int j=i+1;j<n;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(min,i);
        }
    }
    
}
