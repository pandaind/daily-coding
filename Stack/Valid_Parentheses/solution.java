class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> PLIST = new HashMap<>();
        PLIST.put('}', '{');
        PLIST.put(']', '[');
        PLIST.put(')', '(');


        Stack<Character> stack = new Stack<>();

        return s.chars().mapToObj(c -> (char) c)
                        .allMatch(c -> {
                            if (PLIST.containsValue(c)) {
                                stack.push(c);
                                return true;
                            } else {
                                return !stack.isEmpty() && stack.pop() == PLIST.get(c);
                            }
                        }) && stack.isEmpty();
    }
}