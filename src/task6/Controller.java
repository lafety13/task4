package task6;

import task2.Room;
import task3.API;
import task4.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private List<API> apiList = new ArrayList<>();

    public Controller() {
        apiList.add(new BookingComAPI());
        apiList.add(new GoogleAPI());
        apiList.add(new TripAdvisorAPI());
    }

    public Controller(API...ap) {
        Collections.addAll(apiList, ap);
    }

    public List<Room> requstRooms(int price, int persons, String city, String hotel) {
        List<Room> room = new ArrayList<>();

        for (int i = 0; i < apiList.size(); i++) {
            room.addAll(apiList.get(i).findRooms(price, persons, city, hotel));
        }
        return room;
    }

    public List<Room> check(API api1, API api2) {
        List<Room> allRoomsApi1 = new ArrayList<>();
        List<Room> allRoomsApi2 = new ArrayList<>();

        allRoomsApi1.addAll(api1.getAllRooms());
        allRoomsApi2.addAll(api2.getAllRooms());
        List<Room> match = new ArrayList<>();

        int len = allRoomsApi1.size();

        for (int i = 0; i < len; i++) {
            if (allRoomsApi1.get(i).equals(allRoomsApi2.get(i))) {
                match.add(allRoomsApi1.get(i));
            }
        }
        return match;
    }


}
