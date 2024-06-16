package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionRepository {

    public static void main(String[] args) {
        String url = "jdbc:h2:./Sanatorium";
        String username = "LittlePunsh";
        String password = "123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Инициализация репозиториев
            GuestRepository guestRepository = new GuestRepository(connection);
            RoomRepository roomRepository = new RoomRepository(connection);
            BookingRepository bookingRepository = new BookingRepository(connection);
            MedicalExaminationRepository medicalExaminationRepository = new MedicalExaminationRepository(connection);
            ProcedureRepository procedureRepository = new ProcedureRepository(connection);
            ProcedureSessionRepository procedureSessionRepository = new ProcedureSessionRepository(connection);

            // Таблица гостей
            List<Guest> allGuests = guestRepository.getAllGuests();
            for (Guest guest : allGuests) {
                System.out.println("Имя гостя: " + guest.getFirstName() + " " + guest.getLastName());
                System.out.println("Дата рождения: " + guest.getBirthDate());
                System.out.println("Телефон: " + guest.getPhone());
                System.out.println("Email: " + guest.getEmail());
                System.out.println();
            }

            // Таблица комнат
            List<Room> allRooms = roomRepository.getAllRooms();
            for (Room room : allRooms) {
                System.out.println("Тип комнаты: " + room.getRoomType());
                System.out.println("Стоимость за день: " + room.getCostPerDay());
                System.out.println();
            }

            // Таблица бронирований
            List<Booking> allBookings = bookingRepository.getAllBookings();
            for (Booking booking : allBookings) {
                System.out.println("Дата начала: " + booking.getStartDate());
                System.out.println("Дата окончания: " + booking.getEndDate());
                System.out.println("Стоимость: " + booking.getTotalCost());
                System.out.println("ID гостя: " + booking.getGuestId());
                System.out.println("ID комнаты: " + booking.getRoomId());
                System.out.println();
            }

            // Таблица медицинских осмотров
            List<MedicalExamination> allExaminations = medicalExaminationRepository.getAllMedicalExaminations();
            for (MedicalExamination examination : allExaminations) {
                System.out.println("Дата осмотра: " + examination.getExaminationDate());
                System.out.println("ID гостя: " + examination.getGuestId());
                System.out.println("Заметки врача: " + examination.getDoctorNotes());
                System.out.println();
            }

            // Таблица процедур
            List<Procedure> allProcedures = procedureRepository.getAllProcedures();
            for (Procedure procedure : allProcedures) {
                System.out.println("Название процедуры: " + procedure.getName());
                System.out.println("Описание: " + procedure.getDescription());
                System.out.println();
            }

            // Таблица сеансов процедур
            List<ProcedureSession> allProcedureSessions = procedureSessionRepository.getAllProcedureSessions();
            for (ProcedureSession procedureSession : allProcedureSessions) {
                System.out.println("Дата сеанса: " + procedureSession.getSessionDate());
                System.out.println("ID бронирования: " + procedureSession.getBookingId());
                System.out.println("ID процедуры: " + procedureSession.getProcedureId());
                System.out.println("Продолжительность: " + procedureSession.getDuration());
                System.out.println("Результаты: " + procedureSession.getResultNotes());
                System.out.println();
            }

            // Создание, обновление, удаление
            // Примеры создания, обновления и удаления записей в таблицах:

            // Гости
            // Создание нового гостя
            // Guest newGuest = new Guest(0, "Иван", "Иванов", Date.valueOf("1980-01-01"), "+79161234567", "ivanov@example.com");
            // guestRepository.createGuest(newGuest);

            // Обновление гостя
            // Guest updatedGuest = new Guest(1, "Петр", "Петров", Date.valueOf("1985-05-05"), "+79167654321", "petrov@example.com");
            // guestRepository.updateGuest(updatedGuest);

            // Удаление гостя
            // int guestIdToDelete = 7;
            // guestRepository.deleteGuest(guestIdToDelete);

            // Комнаты
            // Создание новой комнаты
            // Room newRoom = new Room(0, "Люкс", 5000.0);
            // roomRepository.createRoom(newRoom);

            // Обновление комнаты
            // Room updatedRoom = new Room(1, "Стандарт", 3000.0);
            // roomRepository.updateRoom(updatedRoom);

            // Удаление комнаты
            // int roomIdToDelete = 1;
            // roomRepository.deleteRoom(roomIdToDelete);

            // Бронирования
            // Создание нового бронирования
            // Booking newBooking = new Booking(0, 1, 1, Date.valueOf("2024-07-01"), Date.valueOf("2024-07-10"), 30000.0);
            // bookingRepository.createBooking(newBooking);

            // Обновление бронирования
            // Booking updatedBooking = new Booking(1, 1, 1, Date.valueOf("2024-07-01"), Date.valueOf("2024-07-12"), 36000.0);
            // bookingRepository.updateBooking(updatedBooking);

            // Удаление бронирования
            // int bookingIdToDelete = 1;
            // bookingRepository.deleteBooking(bookingIdToDelete);

            // Медицинские осмотры
            // Создание нового осмотра
            // MedicalExamination newExamination = new MedicalExamination(0, 1, Date.valueOf("2024-06-15"), "Все хорошо");
            // medicalExaminationRepository.createMedicalExamination(newExamination);

            // Обновление осмотра
            // MedicalExamination updatedExamination = new MedicalExamination(1, 1, Date.valueOf("2024-06-15"), "Есть небольшие проблемы");
            // medicalExaminationRepository.updateMedicalExamination(updatedExamination);

            // Удаление осмотра
            // int examinationIdToDelete = 1;
            // medicalExaminationRepository.deleteMedicalExamination(examinationIdToDelete);

            // Процедуры
            // Создание новой процедуры
            // Procedure newProcedure = new Procedure(0, "Массаж", "Расслабляющий массаж");
            // procedureRepository.createProcedure(newProcedure);

            // Обновление процедуры
            // Procedure updatedProcedure = new Procedure(1, "Гидромассаж", "Массаж с использованием воды");
            // procedureRepository.updateProcedure(updatedProcedure);

            // Удаление процедуры
            // int procedureIdToDelete = 1;
            // procedureRepository.deleteProcedure(procedureIdToDelete);

            // Сеансы процедур
            // Создание нового сеанса процедуры
            // ProcedureSession newProcedureSession = new ProcedureSession(0, 1, 1, Date.valueOf("2024-06-15"), 60, "Процедура прошла успешно");
            // procedureSessionRepository.createProcedureSession(newProcedureSession);

            // Обновление сеанса процедуры
            // ProcedureSession updatedProcedureSession = new ProcedureSession(1, 1, 1, Date.valueOf("2024-06-15"), 60, "Процедура прошла успешно, результаты отличные");
            // procedureSessionRepository.updateProcedureSession(updatedProcedureSession);

            // Удаление сеанса процедуры
            // int procedureSessionIdToDelete = 1;
            // procedureSessionRepository.deleteProcedureSession(procedureSessionIdToDelete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
