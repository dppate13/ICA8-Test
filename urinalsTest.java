import org.junit.jupiter.api.Test;
import  java.io.File;
import static org.junit.jupiter.api.Assertions.*;


public class urinalsTest {
    String authorName = "Dirgh Pranavkumar Patel";
    String InputFileName = "urinals.dat";

    @Test
    void findFileName() {
        String getFileName = urinals.findFileName();
        String name_init = getFileName.substring(0, 4);
        String name_last = getFileName.substring(getFileName.lastIndexOf('.'), getFileName.length());
        String name_digit = getFileName.substring(4, getFileName.lastIndexOf('.'));


        assertAll(
                () -> assertEquals("rule",name_init),
                () -> assertEquals(".txt",name_last)
        );
        System.out.println(authorName + "Write file tests --> If file name bad => TEST EXECUTED -----");
    }

    @Test

    void writeToFile() {
        File dir = new File("/");
        boolean flag = true;
        String[] files = dir.list();
        for(int i=0; i<files.length; i++) {
            for(int j=i+1; j<files.length; j++)
            {
                if (files[i].equals(files[j]) && files[i].equals("urinals.dat")) {
                    flag = false;
                    break;
                }
            }
        }
        assertTrue(flag);
        System.out.println(authorName + "Write File Tests --> Duplicate File => TEST SUCCESSFUL -----");
    }

    @Test
    void openFile() {
        File file = new File(InputFileName);
        assertTrue(file.exists());
        System.out.println(authorName + "Read the file tests --> If file Exists => TEST EXECUTED -----");

        assertTrue(file.length() != 0);
        System.out.println(authorName + "Read the file Tests --> File Empty => TEST EXECUTED -----");
    }

    @Test
    void goodString() {
        assertAll(
                () -> assertEquals(false, urinals.goodString("1110011")),
                () -> assertEquals(true, urinals.goodString("1010101"))
        );
        System.out.println(authorName + "Good string --> Test Cases => TEST EXECUTED -----");
    }

    @Test
    void countUrinals() {
        assertAll(
                () -> assertEquals(1, urinals.countUrinals("10001")),
                () -> assertEquals(0, urinals.countUrinals("1001")),
                () -> assertEquals(3, urinals.countUrinals("00000")),
                () -> assertEquals(2, urinals.countUrinals("0000")),
                () -> assertEquals(1, urinals.countUrinals("01000")),
                () -> assertEquals(-1, urinals.countUrinals("011"))
        );
        System.out.println(authorName + "CountUrinals Test --> Test Cases => TEST EXECUTED -----");
    }
}
