package Java_advanced.IO_String.Task2;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("src/Java_advanced/IO_String/Task2/test2.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            String text = "free text for file";
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            int data = 0;
            while ((data = br.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
