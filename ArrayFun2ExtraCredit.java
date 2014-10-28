public class ArrayFun2ExtraCredit
{
    public ArrayFun2ExtraCredit()
    {
        int[] a =  {1,1,1,0,1};
        int[] b =  {0,0,1,1,1};
        
        print(add(a,b,2));
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
    
    int[] add(int[] num1, int[] num2, int base)
    {
        int[] output = new int[5];
        int sum = 0;
        int carry = 0;
        for(int i = 4; i >= 0; i--)
        {
            sum = num1[i] + num2[i];
            if(sum + carry >= base)
            {
                if((sum + carry) % base == 0 || (sum%base + carry) == base)
                {
                    output[i] = 0;
                    carry = 1;
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
            if(carry > 0)
            throw new ArithmeticException("Addition Overflow Error");
        }
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
