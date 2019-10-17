package entity;

public class Apartment {
    private int id;
    private String region;
    private String address;
    private int countOfRooms;
    private float area;
    private float price;

    public Apartment(int id, String region, String address,
                     int countOfRooms, float area, float price) {
        this.id = id;
        this.region = region;
        this.address = address;
        this.countOfRooms = countOfRooms;
        this.area = area;
        this.price = price;
    }

    public Apartment() {
    }

    public Apartment(String region, String address, int countOfRooms, float area, float price) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", countOfRooms=" + countOfRooms +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
