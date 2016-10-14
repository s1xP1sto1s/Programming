/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
//用数组表示一个十进制的数，返回将这个数加1之后的结果，注意最高位进位的话数组长度要加1

public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int len = digits.length;
        
        int init = digits[len-1]+1;
        if((init/10)!=0)
            flag = true;
        else
            flag = false;
        digits[len-1] = init%10;
        
        if((len==1)&&(flag==true))
            return newArray(digits);
            
        for(int i=len-2; i>=0; i--)
        {
            if(flag==true)
            {
                int temp = digits[i]+1;
                if((temp/10)!=0)
                    flag = true;
                else
                    flag = false;
                digits[i]=temp%10;
                if((i==0)&&(flag==true))
                    return newArray(digits);
            }
            else
                break;
        }
        return digits;
    }
    public int[] newArray(int[] digits)
    {
        int[] res = new int[digits.length+1];
        res[0] = 1;
        for(int i=1; i<res.length; i++)
        {
            res[i] = digits[i-1];
        }
        return res;
    }
}
