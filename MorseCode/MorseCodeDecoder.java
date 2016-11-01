/*
  Author-Owen Collier-Ridge and Robert Kelly (Co-op Coding Session)
  Problem: https://www.codewars.com/kata/decode-the-morse-code-advanced/java
  Given Morse Code encoded in binary with an unknown time unit, decode the Binary
  to Morse Code and the Morse Code to English.
*/
public class MorseCodeDecoder {
  public static void append(String s, StringBuffer sb, int length){
    if(s.length()==0)
      return;
    char c=s.charAt(0);
    length=s.length()/length; 
    if(c=='0'){
      if(length==3){
        sb.append(" ");
      }
      if(length==7){
        sb.append("   ");
      }
    }else{
      if(length==1)
        sb.append(".");
      if(length==3)
        sb.append("-");
      }
  }
  public static String decodeBits(String bits) {
    StringBuffer bitsB=new StringBuffer(bits);
    //Delete all leading and trailing 0's
    for(int i=0;i<bitsB.length();i++){
      if(bitsB.charAt(i)=='1')
        break;
      else
        bitsB.deleteCharAt(i);
    }
    for(int i=bitsB.length()-1;i>=0;i--){
      if(bitsB.charAt(i)=='1')
        break;
      else
        bitsB.deleteCharAt(i);
    }
    bits=bitsB.toString();
    int dotLength=Integer.MAX_VALUE;
    //Determine the length of a dot
    for(String s:bits.split("0+")){
      if(s.length()!=0)
        dotLength=Math.min(dotLength,s.length());
    }
    for(String s:bits.split("1+")){
      if(s.length()!=0)
        dotLength=Math.min(dotLength,s.length());
    }
    if(dotLength==0)
      return "";
    //Now that we know the time unit, we can decode the binary to morse code.
    StringBuffer sb=new StringBuffer();
    StringBuffer temp=new StringBuffer();
    for(int i=0;i<bits.length();i++){
      temp=new StringBuffer(bits.charAt(i));
      char character=bits.charAt(i);
      while(i!=bits.length() && bits.charAt(i)==character){
        temp.append(character);
        i++;
      }
      if(i!=bits.length() && character!=bits.charAt(i))
        i--;
      append(temp.toString(),sb,dotLength);
    }
      return sb.toString().trim();
  }
    public static String decodeMorse(String morseCode) {
      StringBuffer sb=new StringBuffer();
      for(String s:morseCode.split("   ")){
        for(String s1:s.split(" ")){
          sb.append(MorseCode.get(s1));
        }
        sb.append(" ");
      }
      return sb.toString().trim();
    }
}
