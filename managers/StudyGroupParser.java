package managers;

import java.time.LocalDate;



import things.Coordinates;
import things.Person;
import things.Semester;
import things.StudyGroup;

public class StudyGroupParser {
    private final IoManager ioManager;

    public StudyGroupParser(IoManager ioManager) {
        this.ioManager = ioManager;
    }


    public StudyGroup parseStudyGroup() {
        Integer id = IoManager.inputInt("Введите ID группы:");
        String name = IoManager.inputString("Введите название группы:");
        Coordinates coordinates = parseCoordinates();
        LocalDate creationDate = LocalDate.now();
        Long studentsCount = ioManager.inputLong("Введите количество студентов:");
        Integer shouldBeExpelled  = IoManager.inputInt("Введите количество отчисляемых:");
        Integer transferredStudents = IoManager.inputInt("Введите количество переведенных:");
        Semester semesterEnum = parseSemesterEnum();
        Person groupAdmin = parsePerson();
        
        return new StudyGroup(id, name, coordinates, creationDate, studentsCount, shouldBeExpelled, transferredStudents, semesterEnum, groupAdmin);
    }

    private Coordinates parseCoordinates() {
        Double x = ioManager.inputDouble("Введите координату x:");
        long y = ioManager.inputLong("Введите координату y:");
        return new Coordinates(x, y);
    }

    private Semester parseSemesterEnum() {
        String semesterEnum = null;
        while(semesterEnum == null ){
            try{
                semesterEnum = IoManager.inputString("Введите номер семестра:");
            } catch (Exception e) {
                System.out.println("Попробуйте ввести на английском языке капсом:");
            }
        }
        return Semester.valueOf(semesterEnum);
    }

    private LocalDate parseDate() {
        LocalDate date = null;
        while (date == null) {
            try {
                date = LocalDate.parse(IoManager.inputString("Введите дату в формате yyyy-MM-dd:"));
            } catch (Exception e) {
                System.out.println("Неверный формат даты. Попробуйте еще раз.");
            }
        }
        return date;
    }

    private Person parsePerson() {
        String name = IoManager.inputString("Введите имя:");
        LocalDate birthday = parseDate();
        long weight = ioManager.inputLong("Введите вес:");        
        String passportID = IoManager.inputString("Введите номер паспорта:");
        return new Person(name, birthday, weight, passportID);
    }

}



