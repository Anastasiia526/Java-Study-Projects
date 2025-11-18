package Java_advanced.IO_String.extraTask;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ExtraTask {
    public static void main(String[] args) {
        File file = new File("src/Java_advanced/IO_String/extraTask/test.txt");
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {

            String text = "This is the text for the test";
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                bufferedWriter.write(bytes[i]);
            }
            bufferedWriter.flush();
            int data;
            while ((data = bufferedReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
