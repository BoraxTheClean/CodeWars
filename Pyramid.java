/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/string-pyramid/java
  Given a string perform 4 methods: Create a pyramid view of the strings from the side and from above, and
  count the # of characters visible in the pyramid and the # of characters used in the pyramid.
*/
public class Pyramid
{
  public static void addspaces(StringBuffer s, int n){
    for(int i=0;i<n;i++)
      s.append(" ");
  }
  public static String watchPyramidFromTheSide(String characters)
  {
    if(characters==null || characters.length()==0)
      return characters;
    StringBuffer ret=new StringBuffer();
    int q=1;
    int length=2*(characters.length())-1;
    for(int j=characters.length()-1;j>=0;j--){
      char c=characters.charAt(j);
      addspaces(ret,(int)Math.round((length-q)/2));
      for(int i=0;i<q;i++)
        ret.append(c);
      addspaces(ret,(int)Math.round((length-q)/2));
      if(j!=0)
        ret.append('\n');
      q+=2;
    }
    return ret.toString();
  }

  public static String watchPyramidFromAbove(String characters)
  {
    if(characters==null || characters.length()==0)
      return characters;
    String[] side=watchPyramidFromTheSide(characters).split("\n");
    String temp=side[side.length-1];
    String ret=temp+"\n";
    int depth=1;
    for(int i=1;i<characters.length();i++){
      char[] tempArr=temp.toCharArray();
      for(int j=depth;j<temp.length()-depth;j++){
        tempArr[j]=characters.charAt(i);
      }
      temp=new String(tempArr);
      ret+=temp+"\n";
      depth+=1;
    }
    side=ret.split("\n");
    for(int i=side.length-2;i>=0;i--){
      ret+=side[i];
      if(i!=0)
        ret+="\n";
    }
    return ret;
  }
  
  public static int countVisibleCharactersOfThePyramid(String characters)
  {
    if(characters==null || characters.length()==0)
      return -1;
    return (int)Math.pow(characters.length()*2-1,2);
  }

  public static int countAllCharactersOfThePyramid(String characters)
  {
    if(characters==null || characters.length()==0)
      return -1;
    int ret=0;
    int q=1;
    for(int i=0;i<characters.length();i++){
      ret+=q*q;
      q+=2;
    }
    return ret;
  }
}
