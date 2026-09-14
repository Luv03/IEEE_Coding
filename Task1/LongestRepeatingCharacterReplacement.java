import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {
    
    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxCount = 0;
        
        for (int right = 0; right < s.length(); right++) {
            charCounts[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCounts[s.charAt(right) - 'A']);
            
            if (right - left + 1 - maxCount > k) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        
        System.out.print("Enter string s: ");
        String s = scanner.nextLine();
        
        System.out.print("Enter integer k: ");
        int k = scanner.nextInt();
        
        int result = solution.characterReplacement(s, k);
        System.out.println("Output: " + result);
        
        scanner.close();
    }
}