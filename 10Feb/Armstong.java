public class Armstong {
    static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

 static boolean isArmstrong(int n)   
{   
int temp, digits=0, last=0, sum=0;   
//assigning n into a temp variable  
temp=n;   
//loop execute until the condition becomes false  
while(temp>0)    
{   
temp = temp/10;   
digits++;   
}   
temp = n;   
while(temp>0)   
{   
//determines the last digit from the number      
last = temp % 10;   
//calculates the power of a number up to digit times and add the resultant to the sum variable  
sum +=  (Math.pow(last, digits));   
//removes the last digit   
temp = temp/10;   
}  
return sum==n;}
//compares the sum with n  


    public static void main(String[] args) {
        int  n = 153;     
        for(int i=1;i<=n;i ++){
            if(isPrime(i)){  
              } 
            else{  
                if(isArmstrong(i)){  

                }
                else{
                    System.out.println(" Not Armstrong: "+i);}
                }
         

        }
    }
}



