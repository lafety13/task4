package task4;

import task2.Room;
import task3.API;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingComAPI extends API {
    private List<Room> rooms = new ArrayList<>();

    public BookingComAPI() {
        rooms.add(new Room(1, 1000, 1, new Date(), "", "Kiev"));
        rooms.add(new Room(2, 2000, 3, new Date(), "IBM", "Kiev"));
        rooms.add(new Room(3, 3000, 5, new Date(), "BBC", "Kiev"));
        rooms.add(new Room(4, 1000, 1, new Date(), "", "Kiev"));
        rooms.add(new Room(5, 5000, 3, new Date(), "", "Kiev"));
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }
}
