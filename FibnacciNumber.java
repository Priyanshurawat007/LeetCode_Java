package LeetCode;

public class FibnacciNumber {
   

        public static int[] generateFibonacciNumbers(int n) {
    
            int[] ans = new int[n];
    
            if(n==1){
    
                ans[0] = 0;
    
            }else if(n==2){
    
                ans[1] = 1;
    
            }else{
    
                ans[0] = 0;
    
                ans[1] = 1;
    
                fib(n, 2, ans);
    
            }
    
            return ans;
    
        }
    
     
    
        public static void fib(int n, int idx, int[] ans){
    
            if(idx==n){
    
                return;
    
            }else{
    
                ans[idx] = ans[idx-1]+ans[idx-2];
    
                fib(n, idx+1, ans);
    
            }
    
        }
    
    }

