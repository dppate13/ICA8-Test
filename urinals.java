import java.util.*;

public class urinals {

    Boolean goodString(String str){
     for(int i =1 ;i< str.length(); i++){
         if(str.charAt(i) == '1' && str.charAt(i-1) == '1'){
             return false;
         }
     }
     return true;
    }

    int countUrinals(String str){
        int count = 0;

        for(int i =0; i<str.length();i++){

            if(str.charAt(i) == '0'){
                if(str.charAt(i+1) == '0' && str.charAt(i-1) == '0'){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        String choice;
        urinals u = new urinals();
        System.out.println(u.goodString("11001"));
        System.out.println(u.countUrinals("10000"));
    }
}


