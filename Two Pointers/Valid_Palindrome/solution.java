class Solution {
   public boolean isPalindrome(String s) {
        
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
        
        Character start = s.charAt(i);
        Character end = s.charAt(j);
        
        if (!Character.isLetterOrDigit(start)) {
            i++;
            continue;
        }
        
        if (!Character.isLetterOrDigit(end)) {
            j--;
            continue;
        }
        
        if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
            return false;
        }
        
        i++;
        j--;    
    }
    
    return true;
}
   public boolean isPalindrome2(String s) {
    Character[] chars = s.chars().mapToObj(c -> (char)c)
                .map(Character::toLowerCase)
                .filter(Character::isLetterOrDigit)
                .toArray(Character[]::new);
        
        int j = chars.length-1;
        for (int i = 0; i < j; i++, j--) {
            if(chars[i] != chars[j])
                return false;
        }

        return true;
}
}
