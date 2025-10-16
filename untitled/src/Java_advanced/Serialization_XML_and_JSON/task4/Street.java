package Java_advanced.Serialization_XML_and_JSON.task4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "street")
public class Street {
    private String name;
    House house;

    public Street() {
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", house=" + house +
                '}';
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "house")
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
