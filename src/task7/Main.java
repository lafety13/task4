package task7;

import task2.Room;
import task4.*;
import task8_and_9.*;
import task6.Controller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Поиск номеров с разными апи
        System.out.println("Найденные номера Controller1");
        Controller controller1 = new Controller(new TripAdvisorAPI(), new BookingComAPI());
        controller1.requstRooms(1000, 1, "Kiev", "BBC").forEach(System.out::println);


        System.out.println("Найденные номера Controller2");
        Controller controller2 = new Controller(new TripAdvisorAPI(), new BookingComAPI(), new GoogleAPI());
        controller2.requstRooms(1000, 1, "Kiev", "BBC").forEach(System.out::println);

        System.out.println("Найденные номера Controller3");
        Controller controller3 = new Controller(new TripAdvisorAPI());
        controller3.requstRooms(1000, 1, "Kiev", "BBC").forEach(System.out::println);


        // Проверка на совпадения номеров
        System.out.println("Одинаковые номера");
        controller1.check(new TripAdvisorAPI(), new BookingComAPI()).forEach(System.out::println);

        System.out.println("Одинаковые номера");
        controller1.check(new TripAdvisorAPI(), new BookingComAPI()).forEach(System.out::println);


        System.out.println("Одинаковые номера");
        controller1.check(new TripAdvisorAPI(), new BookingComAPI()).forEach(System.out::println);


    }

    private static void display(Room[][] rooms) {
        for (Room[] arrayRoom : rooms) {
            if (arrayRoom != null) {
                for (Room room : arrayRoom) {
                    if (room != null) {
                        System.out.println(room);
                    }
                }
            }
        }
        System.out.println();
    }
}
