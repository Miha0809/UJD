package zadanie2;

import java.util.LinkedList;

import java.util.Iterator;

public class zadanie4 {
    public static void main(String[] arg){
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Krakow");
        cities.add("Warszawa");
        cities.add("Poznan");
        cities.add("Lublin");
        cities.add("Czestochowa");
        cities.add("Kolobrzeg");

        for (String city: cities ){
            System.out.println(city);
        }

        System.out.println("\nNew cities:");
        cities.remove(2);
        cities.add(1, "Lubliniec ");
        cities.add(cities.size() - 1, "Rzeszow ");

        Iterator<String> iterator= cities.iterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}