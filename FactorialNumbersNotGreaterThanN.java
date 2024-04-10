package LeetCode;
import java.util.*;

public class FactorialNumbersNotGreaterThanN {
  


    public static List<Long> factorialNumbers(long n) {

        // Write Your Code Here

        List<Long> ls=new ArrayList<Long>();

        long fact=1;

        int i=2;

        returnfact(n,ls,fact,i);

        return ls;

    }

    public static void returnfact(Long n, List<Long> ls, Long fact,int i)

    {

    //Long ans=1L;

        if(fact>n)

            return ;

//        ans*=num;      

         ls.add(fact);

        returnfact(n, ls, fact*i,i+1);

        

        

 

    }

}
    
