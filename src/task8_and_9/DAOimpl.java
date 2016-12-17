package task8_and_9;

import task2.Room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DAOimpl implements DAO {
    private static List<Room> roomDb = new ArrayList<>();
    private static int len = 0;

    public DAOimpl() {

    }

    @Override
    public Room save(Room room) {
        roomDb.add(room);
        return room;
    }
    // the first found room will be deleted
    @Override
    public boolean delete(Room room) {
        Iterator<Room> iter = roomDb.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(room))
                iter.remove();
            return true;
        }
        return false;
    }

    @Override
    public Room update(Room room) {
        Iterator<Room> iter = roomDb.iterator();
        int i=0;
        while (iter.hasNext()) {
            if (iter.next().equals(room)) {
                return iter.next();
            }
            return room;
        }
        return room;
    }

    @Override
    public Room findById(long id) {
        return roomDb.get((int)id);
    }

    @Override
    public List<Room> getAll() {
        return roomDb;
    }
}
