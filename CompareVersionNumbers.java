public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String version1_1 = "1.01", version2_1 = "1.001";
        System.out.println(solution.compareVersion(version1_1, version2_1)); // Output: 0
        
        String version1_2 = "1.0", version2_2 = "1.0.0";
        System.out.println(solution.compareVersion(version1_2, version2_2)); // Output: 0
        
        String version1_3 = "0.1", version2_3 = "1.1";
        System.out.println(solution.compareVersion(version1_3, version2_3)); // Output: -1
    }
}
