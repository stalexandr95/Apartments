import controller.ApController;
import entity.Apartment;
import service.SQLApDAOImplementation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment("Brovary", "Korolenko 68", 3, 40, 25000);
        Apartment apartment2 = new Apartment("Brovary", "Yroslava Mudrogo 36A", 2, 28, 15000);
        Apartment apartment3 = new Apartment("Novopecherskiy Lipki", "Yaroslava Mudrogo 18B", 3, 38, 50000);
        Apartment apartment4 = new Apartment("Some", "Some 1", 2, 30, 27000);
        Apartment apartment5 = new Apartment("Test", "Test 34B", 4, 50, 75000);

        ApController ap = new ApController(new SQLApDAOImplementation());
        ap.addAp(apartment);
        ap.addAp(apartment2);
        ap.addAp(apartment3);
        ap.addAp(apartment4);
        ap.addAp(apartment5);
//        List<Apartment> apartments = ap.getAllAp();
//        for (Apartment apartment1 : apartments) {
//            System.out.println(apartment1);
//        }
//
//        ap.delAp(4);

        List<Apartment> apartments = ap.findbyPrice(30000, 50000);
        for (Apartment apartment1 : apartments) {
            System.out.println(apartment1);
        }

    }
}
