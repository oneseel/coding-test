import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(formatter));
    }
}