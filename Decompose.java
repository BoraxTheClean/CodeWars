/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/square-into-squares-protect-trees/java
  Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².
*/
public class Decompose {
  static String decompose(long n){
    if(n<1)
      return null;
    StringBuffer ret=new StringBuffer();
    long sq=n*n;
    while(--n>0 && sq!=0){
      if(n*n<=sq && check(n,sq-n*n)){        
          ret.insert(0,n+" ");
          sq-=n*n;
        }
      }
    if(sq!=0)
      return null;
    ret.deleteCharAt(ret.length()-1);
    return ret.toString();
  }
  static boolean check(long n, long sq){
      while(--n>0 && sq!=0){
        if(n*n<=sq && check(n,sq-n*n)){ //Good thing computers are so fast
          sq-=n*n;
        }
      }
    return sq==0;
  }
}
