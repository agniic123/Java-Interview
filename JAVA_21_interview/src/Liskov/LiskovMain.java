package Liskov;

import java.util.ArrayList;
import java.util.List;

public class LiskovMain {

    public static void main(String[] args) {
        List<VehicleEngine> Vlist=new ArrayList<>();
        Vlist.add(new Car());
        Vlist.add(new Schooter());
        Vlist.stream().forEach(e->{
            System.out.println(e.VehicleWheel());
        });

    }
}
