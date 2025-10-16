package Java_essential.class_Object;

    public class Device {
        private String manufacture;
        private float price;
        private String serialNumber;

        public Device() {
        }

        public Device(String manufacture, float price, String serialNumber) {
            this.manufacture = manufacture;
            this.price = price;
            this.serialNumber = serialNumber;
        }

        public String getManufacture() {
            return manufacture;
        }

        public float getPrice() {
            return price;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        @Override
        public String toString() {
            return "Device{" + " manufacture= " + manufacture + ", price=" + price + ", serialNumber='" + serialNumber + '}';
        }

        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Device device = (Device) object;
            if (price != device.getPrice() && manufacture.equals(device.manufacture)) return false;
            return true;
        }

        public int hashCode() {
            int result = 17;
            result = 37 * result + Float.floatToIntBits(getPrice());
            result = 37 * result + (getManufacture() == null ? 0 : getManufacture().hashCode());
            result = 37 * result + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());

            return result;
        }
    }

    class Monitor extends Device {
        private int resolutionX;
        private int resolutionY;

        public Monitor(String manufacture, float price, String serialNumber, int resolutionX, int resolutionY) {
            super(manufacture, price, serialNumber);
            this.resolutionX = resolutionX;
            this.resolutionY = resolutionY;
        }

        public int getResolutionX() {
            return resolutionX;
        }

        public int getResolutionY() {
            return resolutionY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Monitor monitor = (Monitor) o;
            if (resolutionX != monitor.getResolutionX() && resolutionY != monitor.getResolutionY()) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + Float.floatToIntBits(getPrice());
            result = 37 * result + (getManufacture() == null ? 0 : getManufacture().hashCode());
            result = 37 * result + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode());
            result = 37 * result + Integer.hashCode(getResolutionX());
            result = 37 * result + Integer.hashCode(getResolutionY());

            return result;
        }
        public String toString(){
            return "Monitor: manufacturer = " + getManufacture() + ", price= " + getPrice() + ", serialNumber= " + getSerialNumber() + ", X= " + resolutionX +", Y= " + resolutionY;
        }
    }

    class EthernetAdapter extends Device {
        private int speed;
        private String mac;

        public EthernetAdapter(String manufacture, float price, String serialNumber, int speed, String mac) {
            super(manufacture, price, serialNumber);
            this.speed = speed;
            this.mac = mac;
        }

        public int getSpeed() {
            return speed;
        }

        public String getMac() {
            return mac;
        }

        @Override
        public java.lang.String toString() {
            return "EthernetAdapter{" +
                    "speed=" + speed +
                    ", mac='" + mac + '\'' +
                    '}';
        }
    }

    class DeviceMain {
        public static void main(String[] args) {
            Device device = new Device("Samsung", 120, "AB1234567CD");
            System.out.println(device);
            System.out.println(device.hashCode());
            Device monitor = new Monitor("Samsung", 120, "AB1234567CD", 1280, 1024);
            System.out.println(monitor);
            System.out.println(monitor.hashCode());
            System.out.println(device.equals(monitor));
        }
    }

