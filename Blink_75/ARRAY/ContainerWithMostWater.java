import java.util.*;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Example 1
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println("Maximum water area: " + result);  // Output: 49

        // Example 2
        int[] height2 = {1,1};
        int result2 = maxArea(height2);
        System.out.println("Maximum water area: " + result2);  // Output: 1
    }
}
