package task3;

import task2.Room;
import task5.DAOimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class API {
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        Room roomForSearch = new Room(-1, price, persons, new Date(), hotel, city);
        List<Room> roomList = new ArrayList<>();

        for (Room room1 : getAllRooms()) {
            if (room1.equals(roomForSearch)) {
                roomList.add(room1);
            }
        }
        return roomList;
    }

    public abstract List<Room> getAllRooms();
}

