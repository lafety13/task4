package task10;

import task2.Room;
import task3.API;
import task4.*;
import task8_and_9.DAO;
import task8_and_9.DAOimpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Controller {
    private DAO dao = new DAOimpl();
    private List<API> apiList = new ArrayList<>();

    public Controller() {
        this.apiList.add(new BookingComAPI());
        this.apiList.add(new GoogleAPI());
        this.apiList.add(new TripAdvisorAPI());
    }

    public Controller(API...ap) {
        Collections.addAll(apiList, ap);
    }

    public List<Room> requstRooms(int price, int persons, String city, String hotel) {
        List<Room> room = new ArrayList<>();

        for (int i = 0; i < apiList.size(); i++) {
            room.add((Room) apiList.get(i).findRooms(price, persons, city, hotel));
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

    public Room save(Room room) {
        return (Room) dao.save(room);
    }

    public boolean delete(Room room) {
        return dao.delete(room);
    }

    public Room update(Room room) {
        return dao.update(room);
    }

    public Room findById(long id) {
        return dao.findById(id);
    }

    public List<Room> getAll() {
        return dao.getAll();
    }

}
