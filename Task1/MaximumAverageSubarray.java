import java.util.Scanner; // Import the Scanner class

public class MaximumAverageSubarray {
    
    public double findMaxAverage(int[] nums, int k) {
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        long maxSum = currentSum;
        
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaximumAverageSubarray solution = new MaximumAverageSubarray();
        
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers separated by spaces or new lines:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        // 4. Call the method and print the result
        double maxAverage = solution.findMaxAverage(nums, k);
        System.out.println("The maximum average is: " + maxAverage);
        
        scanner.close();
    }
}