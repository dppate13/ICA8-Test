import java.util.*;
import java.io.*;

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

        if(goodString(str)){
            for(int i =0; i<str.length();i++){

                if(str.charAt(i) == '0'){
                    if((i-1<0 || str.charAt(i-1) == '0') && (i+1>=str.length() || str.charAt(i+1) == '0')){
                        count++;
                        i++;
                    }
                }
            }
            return count;
        }
        else{
            return -1;
        }

    }

    public static void main(String args[]){
        String choice;
        urinals u = new urinals();
        try {
            File myObj = new File("urinals.dat");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(u.countUrinals(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


