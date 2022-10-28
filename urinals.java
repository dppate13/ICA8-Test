import java.util.*;
import java.io.*;

public class urinals {


    public void getInputKeyboard(){
        Scanner scanner = new Scanner(System.in);

        while(scanner.nextLine() != "-1"){
            String str = String.valueOf(scanner.hasNext());
            System.out.println(str + "ayu");
            goodString(str);
        }
    }

    public void openFile(){
        try {
            File myObj = new File("urinals.dat");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(countUrinals(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
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

        urinals u = new urinals();

        System.out.println("Choice one option for input:");
        System.out.println("i. Enter '1' to get input from keyboard.");
        System.out.println("ii. Enter '2' to get input from file.");
        System.out.print("Enter your choice = ");
        Scanner scanner = new Scanner(System.in);
        int InputType = scanner.nextInt();


        switch (InputType) {
            case 1:
                System.out.print("Enter input = ");
                String str = scanner.next();
                while(!str.equals("-1")){
                    System.out.println("Max urinals possible: " + u.countUrinals(str));
                    System.out.print("Enter '-1' to end input or string to continue enter = ");
                    str = scanner.next();
                }
                break;
            case 2:
                u.openFile();
                break;
        }
    }
}


