import java.util.*;
import java.io.*;

public class urinals {


    public static void getInputKeyboard(){
        Scanner scanner = new Scanner(System.in);

        while(scanner.nextLine() != "-1"){
            String str = String.valueOf(scanner.hasNext());
            //System.out.println(str + "ayu");
            goodString(str);
        }
    }

    public static String findFileName(){

        String filename = "rule.txt";
        File file = new File(filename);
        int currentFile=0;

        while(true)
        {
            if(file.exists())
            {
                currentFile++;
                System.out.println(currentFile);
                filename = filename.substring(0,4) + currentFile + ".txt";
                file = new File(filename);
            }
            else
                break;
        }
        return filename;
    }
    public void writeToFile(int maxUrinal, String filename){
        try
        {
            FileWriter fileWriter = new FileWriter(filename, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Integer input = maxUrinal;
            bufferedWriter.write(input.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();

        }
        catch(IOException e)
        {
            System.out.println("I/O Exception!");
        }
    }

    public void openFile(){
        try {
            File myObj = new File("urinals.dat");
            Scanner myReader = new Scanner(myObj);
            String fileName = findFileName();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int maxUrinal = countUrinals(data);
                writeToFile(maxUrinal,fileName);
                //System.out.println(countUrinals(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Boolean goodString(String str){
     for(int i =1 ; i< str.length(); i++){
         if(str.charAt(i) == '1' && str.charAt(i-1) == '1'){
             return false;
         }
     }
     return true;
    }

    public static int countUrinals(String str){
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


