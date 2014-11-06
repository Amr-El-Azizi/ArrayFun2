public class Product
{
    public Product()
    {
        int[] a =  {2,6,9,8,6,7};
        int[] b =  {3,4,3,2,6,7};
        
        print(productany(a,b,10));
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
            if(num1[x] >= base)
            throw new ArithmeticException("Non existing Number Error");
            for(int i = num2l-1; i >= 0; i--)
            {
                if(num2[i] >= base)
                throw new ArithmeticException("Non existing Number Error");
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
    
   // METHODS FOR PRODUCT
            int[] add(int[] num1, int[] num2, int base)
    {
        int nl1 = num1.length;
        int nl2 = num2.length;
        
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
        
        int[] output = new int[lnuml+1];
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
                    output[i+1] = 0;
                    carry = (sum + carry)/base;
                }
                else
                {
                    output[i+1] = sum%base + carry;
                    carry = sum/ base;
                }
            }
            else
            {
                output[i+1] = sum + carry;
                carry = 0;
            }
        }
        
        if(carry > 0)
        throw new ArithmeticException("Addition Overflow Error");
        return (output);
    }
    
   public int[] shiftleft(int[] nums)
   {
        int nl = nums.length;
        int[] temp = new int[nl + 1];
        for(int i = 0; i < nl; i ++ )
        temp[i] = nums[i];
        return temp;
   }
   
   public int[] resetArray(int[] nums, int len)
   {
       int[] blank = new int[len];
       return blank;
   }
        /// HELPERS
   public void print(String s)
   {
        System.out.println("printing : " + s ) ;
   } 

   public void print(boolean[] b)
   {
        for( boolean inB : b)
        System.out.println(b);
    }
    

    public void print(int[] nums)
    {
        for( int n : nums)
        System.out.print(n);

    }

    public void print(String[] nums)
    {
        for(String n : nums)
        System.out.println(n);

    }
}
