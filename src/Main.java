import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // JAVA ALARM CLOCK

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        // ALARM NOISE - FILE PATH:
        String filePath = "preview.wav";

        while (alarmTime == null){
            try {
                System.out.print("ENTER AN ALARM TIME (HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("ALARM SET FOR " + alarmTime);
            }catch (DateTimeParseException e){
                System.out.println("INVALID TIME FORMAT! PLEASE USE: HH:MM:SS");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime ,filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();

    }
}