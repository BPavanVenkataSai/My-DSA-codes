public class Sorted {
public static void main(String[] args) {
    int[] arr = {1,2,31,5};
    System.out.println(is_Sorted(arr, 0));

}
static boolean is_Sorted(int[] arr, int index){
    if(index == arr.length-1){
        return true;
    }
    return arr[index]<arr[index+1] && is_Sorted(arr,index+1);
}
    
}
