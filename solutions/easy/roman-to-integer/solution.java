class Solution {
    public int romanToInt(String s) {
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            
            // Check if we are at a subtractive instance:
            // Is there a next character? AND is the current value smaller than the next value?
            if (i < s.length() - 1 && currentValue < getValue(s.charAt(i + 1))) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        
        return total;
    }
    
    // Helper method to keep the main logic clean and avoid HashMap overhead
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}