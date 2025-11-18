package Java_advanced.Regular_expressions_and_Data_API;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decoder {
    public static void main(String[] args) {
        File file = new File("text.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            String text = "Birds are animal with feathers. Because they can fly, " +
                    "they are the fastest animals on Earth. Some birds can reach speeds of up to 160km an hour." +
                    " However, not all birds can fly. Some birds, like ostriches can run and penguins can swim.";
            bw.write(text);
            bw.flush();
            List<String> prepositions = new ArrayList<>(Arrays.asList("are", "with", "on", "some", "to", "of", "not", "all", "like", "and"));
            StringBuilder result = new StringBuilder();
            for (String temp : text.split("\\s+")) {
                String cleanWord = temp.replaceAll("[^a-zA-Z]", "");
                if (prepositions.contains(cleanWord.toLowerCase())) {
                    result.append("Java");
                    if (!Character.isLetterOrDigit(temp.charAt(temp.length() - 1))) {
                        result.append(temp.charAt(temp.length() - 1));
                    }
                } else {
                    result.append(temp);
                }
                result.append(" ");
            }
            String replacedText = result.toString().trim();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(replacedText)))) {
                int i = 0;
                while ((i = br.read()) != -1) {
                    System.out.print((char) i);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
