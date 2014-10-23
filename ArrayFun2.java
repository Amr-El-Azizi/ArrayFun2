public class ArrayFun2
{
    public ArrayFun2()
    {
    }
    
    public int[] digitsToArray(int nums)
    {
        int count = 0;
        int tempnums = nums;
        while(tempnums!=0)
        {
            tempnums = tempnums/10;
            count++;
        }
        int[] output = new int[count];
        for(int i = 1; nums!=0; i ++)
        {
            output[output.length-i] = nums%10;
            nums = nums/10;
        }
        return output;
    }
    
    public boolean allFactorsOfSum(int[] nums)
    {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++)
            sum += nums[i];
        for(int i = 0; i < nums.length; i ++)
        {
            if(sum % nums[i] != 0)
            return false;
        }
        return true;
    }
    
    public String[] doubleArr(String[] strs)
    {
        String[] output = new String[strs.length * 2];
        for(int i = 0; i < strs.length; i ++)
        {
            output[i + i] = strs[i];
            output[i + i + 1] = strs[i];
        }
        return output;
    }
    
    public boolean isThere(int[] nums, int num)
    {
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] == num)
            return true;
        }
        return false;
    }
    
    public int indexOf(int[] nums, int num)
    {
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] == num)
            return i;
        }
        return -1;
    }
    
    public int lastIndexOf(int[] nums, int num)
    {
        int index = -1;
        for(int i = 0; i < nums.length; i ++)
        {
            if(nums[i] == num)
            index = i;
        }
        return index;
    }
    
    public boolean isIncreasing(double[] nums)
    {
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] < nums[i-1])
            return false;
        }
        return true;
    }
    
    public int largestSpan(int[] nums)
    {
        int span = 0;
        int tempspan = 1;
        for(int i = 1; i < nums.length; i ++)
        {
          if(nums[i] > nums[i-1])
          tempspan++;
          else if(tempspan > span)
          {
          span = tempspan;
          tempspan = 1;
          }
          else
          tempspan = 1;
        }
        return span;
    }
    
        public int largestSpanPatternPRACTICECODE(int[] nums)
    {
        int span = 0;
        int tempspan = 0;
        int difference = 0;
        boolean a = true;
        for(int i = 0; i < nums.length; i ++)
        {
          difference = nums[i+1] - nums[i];
            for(int x = i; x < nums.length-1 && a == true; x ++)
          {
             if(nums[x+1] - nums[x] == difference)
             tempspan ++;
             else
             a = false;
          }
          if(tempspan > span)
          span = tempspan;
          tempspan = 0;
          a = true;
        }
        return span;
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
