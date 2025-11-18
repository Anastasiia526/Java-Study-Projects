package Java_advanced.IO_String;

public class Task3 {
    public static void main(String[] args) {
        String text = "Many birds from colder areas migrate to warmer regions to avoid harsh winters," +
                " but others stay in their living area all through the year";
        StringBuilder sb = new StringBuilder(text);
        int middle = sb.length() / 2;
        String firstPath = sb.substring(0, middle);
        String secondPath = sb.substring(middle);
        System.out.println("First path of the text: " + firstPath);
        System.out.println("Second path of the text: " + secondPath);

    }
}
