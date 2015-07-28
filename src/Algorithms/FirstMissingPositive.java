package Algorithms;

class firstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums==null) return 0;
        int n=nums.length;
        int temp=0;
        int i=0;
        while(i<n){
            int cur = nums[i];
            if(cur!=i+1 && cur>=1 && cur<=n){
                int j = cur-1;
                if(cur==nums[j]){
                  i++; //could be dups
                  continue;
                } 
                temp=nums[j];
                nums[j]=cur;
                nums[i]=temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(j+1!=nums[j]) return j+1;
        }
        return n+1;
    }
}
