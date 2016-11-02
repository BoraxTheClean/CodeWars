/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/product-of-consecutive-fib-numbers/java
  Given a number prod, find two sequential fibonacci numbers that sum to prod.
*/
public class ProdFib {
  public static long[] productFib(long prod) {
    long[] ret;
    long first=0;long second=1;
    while(first*second<prod){
      long temp=second;
      second+=first;
      first=temp;
    }
    if(first*second==prod)
      ret=new long[]{first,second,1};
    else{
      ret=new long[]{first,second,0};
    }
    return ret;
   }
}
