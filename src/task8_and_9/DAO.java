package task8_and_9;

import task2.Room;

import java.util.List;

public interface DAO {
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
    List<Room> getAll();
}
