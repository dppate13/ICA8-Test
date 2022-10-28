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



    public static void main(String args[]){
        String choice;
        urinals u = new urinals();
        System.out.println(u.goodString("11001"));

    }
}


