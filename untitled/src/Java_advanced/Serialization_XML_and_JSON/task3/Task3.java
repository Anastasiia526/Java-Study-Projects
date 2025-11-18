package Java_advanced.Serialization_XML_and_JSON.task3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        File fileName = new File("D:\\Java\\Сourse\\Java-Study-Projects\\untitled\\src\\Java_advanced\\Serialization_XML_and_JSON\\task3\\Phonebook.xml");
        try {
            SAXParserFactory factory = SAXParserFactory.newNSInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Тут ми визначили анонімний клас, який розширює клас DefaultHandler
            DefaultHandler def = new DefaultHandler() {
                // Поле, щоб вказати, що тег name почався
                boolean name = false;

                // Метод викликається, коли SAXParser "натикається" на початок тегу
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    // Якщо тег має ім'я name, ми цей момент відзначаємо - почався тег name
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;

                    }
                }

                // Метод викликається, коли SAXParser зчитує текст між тегами
                @Override
                public void characters(char ch[], int start, int length){
                    // Якщо перед цим ми відзначили, що ім'я тэга name - значить нам треба використовувати текст.
                    if(name){
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;}
                }

            };
            // Стартуємо аналіз методом parse, якому передаємо спадкоємця від DefaultHandler, який буде викликатися в потрібні моменти
            saxParser.parse(fileName, def);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();

        }
    }
}