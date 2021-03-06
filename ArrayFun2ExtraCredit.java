public class ArrayFun2ExtraCredit
{
    public ArrayFun2ExtraCredit()
    {
        int[] a =  {2,6};
        int[] b =  {3,4};
        
        print(productany(a,b,10));
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
    
    int[] product5indiv(int[] num1, int[] num2, int base)
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
    
    int[] productany(int[] num1, int[] num2, int base)
    {
        int num1l = num1.length;
        int num2l = num2.length;
        int[] output = new int[num1l+num2l];
        int product = 0;
        int carry = 0;
        int[] temp = new int[num1l+num2l-1];
        int tens = 0;
        for(int x = num1l-1; x >= 0; x--)
        {
            temp = resetArray(temp, temp.length-tens+1);
            for(int i = num2l-1; i >= 0; i--)
            {
                product = num1[x] * num2[i];
                if(product + carry >= base)
                {
                    if((product + carry) % base == 0)
                    {
                        temp[i+num1l] = 0;
                        carry = (product + carry)/base;
                    }
                    else
                    {
                        temp[i+num1l] = product%base + carry;
                        carry = product/ base;
                    }
                }
                else
                {
                    temp[i+num1l] = product + carry;
                    carry = 0;
                }
            }
            temp[num1l-1] += carry;
            for(int i = 0; i < tens; i++)
            {
                temp = shiftleft(temp);
            }
            output = add(output, temp, base);
            tens ++;
            carry = 0;
        }
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
        return (output);
    }
    
   
   // METHODS FOR PRODUCT
       
   public int[] shiftleft(int[] nums)
   {
        int nl = nums.length;
        int[] temp = new int[nl + 1];
        for(int i = 0; i < nl; i ++ )
        temp[i] = nums[i];
        return temp;
   }
   
      public int[] shiftright(int[] nums)
   {
        int nl = nums.length;
        int[] temp = new int[nl - 1];
        for(int i = nl-2; i >= 0; i -- )
        temp[i] = nums[i];
        return temp;
   }
   
   public int[] resetArray(int[] nums, int len)
   {
       int[] blank = new int[len];
       return blank;
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
    System.out.print(n);

}

public void print(String[] nums){
for(String n : nums)
System.out.println(n);

}
}
