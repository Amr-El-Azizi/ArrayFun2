public class ArrayFun2ExtraCredit
{
    public ArrayFun2ExtraCredit()
    {
              int[] a =  {2,1,3,2,1};
        int[] b =  {1,3,2,3,2,2,1,3};
        
        print(add(a,b,10));
    }
    
    int[] invert(int[] nums)
    {
        int nl = nums.length;
        int[] output = new int[nl];
        for(int i = nl-1; i > nl/2; i --)
            output[nl-i-1] = nums[i];
        for(int i = 0; i <= nl/2; i ++)
            output[nl-1-i] = nums[i];
        return output;
    }
    
    int[] inverse(int[] nums)
    {
        int nl = nums.length;
        int[] output = new int[nl];
        for(int i = 0; i < nl; i++)
        output[i] = nums[nl-1-i];
        return output;
    }
    
    int[] ShiftByN(int[] nums, int deltapure)
    {
        int nl = nums.length;
        if(deltapure < 0)
        nums = inverse(nums);
        int delta = Math.abs(deltapure);
        int[] output = new int[nl];
        for(int i = delta; i < nl; i ++)
        output[i] = nums[i-delta];
        for(int i = 0; i < delta; i ++)
        output[i] = nums[nl-delta+i];
        if(deltapure < 0)
        output = inverse(output);
        return output;
    }
    
    int[] ShiftByDelta(int[] nums, int deltapure)
    {
        int nl = nums.length;
        int delta = Math.abs(deltapure);
        int[] output = new int[nl];
        for(int i = delta; i < nl; i ++)
        output[i] = nums[i-delta];
        for(int i = 0; i < delta; i ++)
        output[i] = nums[nl-delta+i];
        return output;
    }
    
    int[] add5(int[] num1, int[] num2, int base)
    {
        int[] output = new int[5];
        int sum = 0;
        int carry = 0;
        for(int i = 4; i >= 0; i--)
        {
            sum = num1[i] + num2[i];
            if(sum + carry >= base)
            {
                if((sum + carry) % base == 0)
                {
                    output[i] = 0;
                    carry = (sum + carry)/base;
                }
                else
                {
                    output[i] = sum%base + carry;
                    carry = sum/ base;
                }
            }
            else
            {
                output[i] = sum + carry;
                carry = 0;
            }
        }
        if(carry > 0)
        throw new ArithmeticException("Addition Overflow Error");
        return output;
    }
    
    int[] product5(int[] num1, int[] num2, int base)
    {
        int[] output = new int[5];
        int product = 0;
        int carry = 0;
        for(int i = 4; i >= 0; i--)
        {
            product = num1[i] * num2[i];
            if(product + carry >= base)
            {
                if((product + carry) % base == 0)
                {
                    output[i] = 0;
                    carry = (product + carry)/base;
                    
                }
                else
                {
                    output[i] = product%base + carry;
                    carry = product/ base;
                }
            }
            else
            {
                output[i] = product + carry;
                carry = 0;
            }
        }
        if(carry > 0)
        throw new ArithmeticException("Multiplication Overflow Error");
        return output;
    }
    
        int[] add(int[] num1, int[] num2, int base)
    {
        int nl1 = num1.length;
        int nl2 = num2.length;
        if(nl1 > 100 || nl2 > 100)
        throw new ArithmeticException("Out of Bounds Error");
        int[] snum = num1;
        int[] lnum = num2;
        int lnuml = nl2;
        int snuml = nl1;
        if(nl1 > nl2)
        {
            snum = num2;
            lnum = num1;
            lnuml = nl1;
            snuml = nl2;
        }
        int[] output = new int[lnuml];
        int sum = 0;
        int carry = 0;
        int[] tempnum = new int[lnuml];
        for(int i = 0; i < snuml; i ++)
        tempnum[tempnum.length-1-i] = snum[snuml-1-i];
        for(int i = lnuml-1; i >= 0; i--)
        {
            sum = lnum[i] + tempnum[i];
            if(sum + carry >= base)
            {
                if((sum + carry) % base == 0)
                {
                    output[i] = 0;
                    carry = (sum + carry)/base;
                }
                else
                {
                    output[i] = sum%base + carry;
                    carry = sum/ base;
                }
            }
            else
            {
                output[i] = sum + carry;
                carry = 0;
            }
        }
        if(carry > 0)
        throw new ArithmeticException("Addition Overflow Error");
        return output;
    }
        /// HELPERS
public void print(String s){
    System.out.println("printing : " + s ) ;
}  

public void print(boolean[] b){
for( boolean inB : b)
    System.out.println(b);

}
    

public void print(int[] nums){
for( int n : nums)
    System.out.println(n);

}

public void print(String[] nums){
for(String n : nums)
System.out.println(n);

}
}
