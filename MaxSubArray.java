public class MaxSubArray {
    public int maxSubArray(int[] nums) {
            int n = nums.length;
            int ans = Integer.MIN_VALUE;
                int sum = 0;
                for(int j=0;j<n;j++){
                    sum+=nums[j];
                    ans = Math.max(ans,sum);
                    if(sum<0)
                    sum = 0;
                    
                }
            return ans;
    }
}
