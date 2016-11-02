/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/longest-common-subsequence/java
  A neat little recursive solution to the classic longest common subsequence problem.
*/
public class Solution {
    public static String lcs(String x, String y){
        return lcsHelp(x,y);
    }
    public static String lcsHelp(String x, String y) {
          if(x.length()<1 || y.length()<1)
            return "";
          StringBuilder ret=new StringBuilder();
          int i=0;int j=0;
          if(x.charAt(i)==y.charAt(j)){
            ret.append(x.charAt(i));
            i++;j++;
            return ret.append(lcsHelp(x.substring(i),y.substring(j))).toString();
          }else{
            String one=lcsHelp(x.substring(i+1),y);
            String two=lcsHelp(y.substring(j+1),x);
            return one.length()>two.length() ? ret.append(one).toString() : ret.append(two).toString();
          }
    }
}
