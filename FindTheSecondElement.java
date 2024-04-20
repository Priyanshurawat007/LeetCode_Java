public class Solution {
      public static int SecondLargest(int n ,int[]a){
           int largest=a[0];
            int Slargest=-1;

            for(int i=0;i<n;i++){
                if(a[i]>largest){
                    largest=a[i];
                }
            }
            for(int i=0;i<n;i++){
                if(a[i]>Slargest && a[i]!=largest){
                    Slargest=a[i];
                }
            }
            return Slargest;

    }

    public static int SecondSmallest(int n, int[]a){
        int smallest=a[0];
        int Ssmallest=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(a[i]<smallest){
                Ssmallest=smallest;
                smallest=a[i];
            }
            else if(a[i]!=smallest && a[i]<Ssmallest){
                Ssmallest=a[i];
            }
        }
        return Ssmallest;

    }
    public static int[] getSecondOrderElements(int n, int []a) {
        int SecLargest = SecondLargest(n, a);
        int SecSmallest = SecondSmallest(n, a);

          return new int[]{SecLargest, SecSmallest};
    }

 
}
