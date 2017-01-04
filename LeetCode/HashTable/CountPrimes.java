/*
204. Count Primes
Description:
Count the number of prime numbers less than a non-negative number, n.
*/
/******************************超时***************************/
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }
    public boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
/****/
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                count++;
                for(int j=2;i*j<n;j++){
                   notPrime[i*j] = true; //两个数相乘，定为非素数
                }
            }
        }
        return count;
    }
}
