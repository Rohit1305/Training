public class LongestSeq {
    public static void main(String[] args) {
        String input = "aaabbbbbbccccccccc";
        
        char longestChar = findLongestChar(input);
        
        System.out.println("The longest character in the input string is: " + longestChar);
    }
    
    public static char findLongestChar(String input) {

        char longestChar = input.charAt(0);
        
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            if (currentChar > longestChar) {
                longestChar = currentChar;
            }
        }
        
        return longestChar;
    }
}
