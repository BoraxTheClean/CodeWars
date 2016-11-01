import java.util.*;
/*
  Author: Owen Collier-Ridge
  Problem: https://www.codewars.com/kata/my-smallest-code-interpreter-aka-brainf-star-star-k/java
  The task is to create a BrainF**k interpretter.
*/
public class BrainLuck {
    char[] inp;
    char current;
    int pointer=0;
    int inputPointer=0;
    boolean flag=false;
    List<Integer> data=new ArrayList<>();
    StringBuffer sb=new StringBuffer();
    String code;
    public BrainLuck(String code) {  
      this.code=code;
      data.add(0);
    }

    public String process(String input) {
      this.inp=input.toCharArray();
      return processHelper(code);
    }
    public String processHelper(String input){
      for(int i=0;i<input.length();i++){
        char c=input.charAt(i);
        switch(c){
          case '>': pointer++;
                        data.add(0);
                    break;
          case '<': pointer--;
                    break;
          case '+':
                    data.set(pointer,(data.get(pointer)+1)%256);
                    break;
          case '-':
                    data.set(pointer,(data.get(pointer)-1)%256);
                    break;
          case '.':
                    char temp=(char)('0'-'0'+data.get(pointer));
                    sb.append(temp);
                    break;
          case ',':
                    data.set(pointer,(int)inp[inputPointer++]);
                    break;
          case '[':
                    if(data.get(pointer)!=(char)0){
                        processHelper(input.substring(i+1));
                        if(flag)
                          return sb.toString();
                        i--;
                    }
                    else{
                        int count=1;
                        for(int j=i+1;j<input.length();j++){
                          char ch=input.charAt(j);
                          if(ch=='[')
                            count++;
                          else if(ch==']')
                            count--;
                          if(count==0){
                            if(j+1==input.length()){
                              return sb.toString();
                              }
                            return processHelper(input.substring(j+1));
                          }
                        }
                    }
                    break;
          case ']':
                   return sb.toString(); 
                   
          

        }
      }
      return sb.toString();
    }
}
