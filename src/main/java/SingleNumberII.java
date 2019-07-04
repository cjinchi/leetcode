public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int i = 0;i<32;i++){
            bits[i] = 0;
        }
        for(int x:nums){
            for(int i = 0;i<32;i++){
                if (((x>>i)&1) == 1){
                    bits[i] += 1;
                }
            }
        }
        int ret = 0;
        for(int i = 31;i>=0;i--){
            if(bits[i]%3!=0){
                ret = ret*2 + 1;
            }else{
                ret = ret*2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{2,2,3,2}));
    }
}
