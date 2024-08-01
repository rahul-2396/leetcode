// class Solution 
// {
//     public int countPrimes(int n) 
//     {
//         int count = 0;
//         for(int i = 1; i < n; i++)
//         {
//             if(isPrime(i))
//             {
//                 count += 1;
//             }
//         }
//         return count;
//     }
//     private boolean isPrime(int num)
//     {
//         int result = 0;
//         for(int i = 1; i <= num / 2; i++)
//         {
//             if(num % i == 0)
//             {
//                 result += 1;
//             }
//         }
//         if(result == 1)
//         {
//             return true;
//         }
//         return false;
//     }
// }


class Solution 
{
    public int countPrimes(int n) 
    {
        if (n <= 2) 
        {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) 
        {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) 
        {
            if (isPrime[i]) 
            {
                for (int j = i * i; j < n; j += i) 
                {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) 
        {
            if (isPrime[i]) 
            {
                count++;
            }
        }
        
        return count;
    }
}
