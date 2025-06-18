class Solution {
    public int[] plusOne(int[] digits) {
        // 3 cases all non 9 digits, some digits are 9 and all digits are 9

        int currentIdx = digits.length - 1;

        while(digits[currentIdx] == 9) {
            if(currentIdx==0){
                int[] newArray = new int[digits.length+1];
                newArray[0] = 1;
                return newArray;
            }
            digits[currentIdx] = 0;
            currentIdx --;
        }

        digits[currentIdx]++;

        return digits;
    }
}