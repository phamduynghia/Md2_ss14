package bt2;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Ngày hiện tại của hệ thống
        LocalDate currentDate = LocalDate.now();
        System.out.println("Ngày hiện tại: " + currentDate);

        // Ngày hiện tại tại Asia/Tokyo
        ZonedDateTime tokyoDate = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Ngày hiện tại tại Tokyo: " + tokyoDate.toLocalDate());

        // Ngày hiện tại tại Australia/Sydney
        ZonedDateTime sydneyDate = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("Ngày hiện tại tại Sydney: " + sydneyDate.toLocalDate());

        // Ngày hiện tại tại America/Sao_Paulo
        ZonedDateTime saoPauloDate = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Ngày hiện tại tại Sao Paulo: " + saoPauloDate.toLocalDate());

//        Viết chương trình để lấy thời gian hiện tại (giờ phút giây).
        LocalTime currentTime = LocalTime.now();
        System.out.println("Thời gian hiện tại: " + currentTime);

//        Viết chương trình để tính toán số ngày trong tháng hiện tại.
        LocalDate currentDate1 = LocalDate.now();
        Month month = currentDate1.getMonth();
        int daysInMonth = currentDate1.lengthOfMonth();
        System.out.println("Tháng " + month + " có " + daysInMonth + " ngày.");

//        Viết chương trình để tính toán số ngày trong năm hiện tại.
        LocalDate currentDate2 = LocalDate.now();
        int daysInYear = currentDate2.lengthOfYear();
        System.out.println("Năm " + currentDate2.getYear() + " có " + daysInYear + " ngày.");

//        Viết chương trình để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
        String dateString = "23/08/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        System.out.println("Đối tượng LocalDate: " + date);

//        Viết chương trình để chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy).
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date1.format(formatter1);
        System.out.println("Chuỗi ngày: " + formattedDate);

//        Viết chương trình để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter2);
        System.out.println("Chuỗi ngày giờ: " + formattedDateTime);

//        Viết chương trình để so sánh hai ngày LocalDate ( trả về int ).
        LocalDate date2 = LocalDate.of(2024, 8, 23);
        LocalDate date3 = LocalDate.of(2024, 8, 24);

        int comparisonResult = date2.compareTo(date3);
        if (comparisonResult < 0) {
            System.out.println("Ngày " + date2 + " trước ngày " + date3);
        } else if (comparisonResult > 0) {
            System.out.println("Ngày " + date2 + " sau ngày " + date3);
        } else {
            System.out.println("Hai ngày bằng nhau.");
        }

//        Viết chương trình để so sánh hai thời gian LocalTime.
        LocalTime time1 = LocalTime.of(10, 30);
        LocalTime time2 = LocalTime.of(12, 45);

        int comparisonResult1 = time1.compareTo(time2);
        if (comparisonResult1 < 0) {
            System.out.println("Thời gian " + time1 + " trước thời gian " + time2);
        } else if (comparisonResult1 > 0) {
            System.out.println("Thời gian " + time1 + " sau thời gian " + time2);
        } else {
            System.out.println("Hai thời gian bằng nhau.");
        }

//       Viết chương trình để thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        LocalDateTime dateTime1 = LocalDateTime.now();

        LocalDateTime plusDays = dateTime1.plusDays(5);
        LocalDateTime minusHours = dateTime1.minusHours(3);

        System.out.println("Ngày giờ ban đầu: " + dateTime1);
        System.out.println("Sau khi thêm 5 ngày: " + plusDays);
        System.out.println("Sau khi trừ 3 giờ: " + minusHours);

//        Viết chương trình để tính toán ngày (LocalDate) tiếp theo hoặc ngày trước đó của một ngày.
        LocalDate date9 = LocalDate.now();

        LocalDate nextDay = date9.plusDays(1);
        LocalDate previousDay = date9.minusDays(1);

        System.out.println("Ngày hiện tại: " + date9);
        System.out.println("Ngày tiếp theo: " + nextDay);
        System.out.println("Ngày trước đó: " + previousDay);

    }
}
