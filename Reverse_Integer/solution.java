class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while(x!=0) {
            int rem = x % 10;
            int temp = res;
            res = (res*10) + rem;
            if((res-rem)/10!=temp) {
                return 0;
            }
            x = x/10;
        }

        return res;
    }
}