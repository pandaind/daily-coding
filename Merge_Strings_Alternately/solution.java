class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int sLen = len1<len2 ? len1:len2;
        char[] res = new char[sLen*2];

        int j = 0;
        int i = 0;
        while(i<sLen){
                res[j] = word1.charAt(i);
                res[j+1] = word2.charAt(i);
                j=j+2;
                i++;
        }

        String result = new String(res);
        result+=len1>len2?word1.substring(i):word2.substring(i);

        return result;
    }
}