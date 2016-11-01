/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/large-factorials/java
  BigInteger factorial implementation with memoization.
*/
import java.math.*;
import java.util.*;
public class BigFactorials
{

  public static String Factorial(int n) {
    Map<BigInteger,String> map=new HashMap<>();
    map.put(BigInteger.ONE,"1");
    map.put(BigInteger.ZERO,"1");
    return factHelp(new BigInteger(Integer.toString(n)),map);
  }
  static String factHelp(BigInteger n,Map<BigInteger,String> map){
    if(map.get(n)!=null){
      return map.get(n);
    }
    BigInteger result=n.multiply(new BigInteger(factHelp(n.subtract(BigInteger.ONE),map)));
    map.put(n,result.toString());
    return map.get(n);
  }

}
