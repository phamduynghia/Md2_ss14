package bt1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 8, 5};

        OptionalInt max = Arrays.stream(numbers)
                .max();

        max.ifPresent(value -> System.out.println("Số lớn nhất: " + value));


        System.out.println("Các số chẵn:");
        Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị: ");
        int threshold = scanner.nextInt();

        System.out.println("Các số lớn hơn " + threshold + ":");
        Arrays.stream(numbers)
                .filter(n -> n > threshold)
                .forEach(System.out::println);


        int sum = Arrays.stream(numbers)
                .reduce(0, Integer::sum);

        System.out.println("Tổng các số: " + sum);

        boolean hasEven = Arrays.stream(numbers)
                .anyMatch(n -> n % 2 == 0);

        if (hasEven) {
            System.out.println("Danh sách có chứa ít nhất một số chẵn.");
        } else {
            System.out.println("Danh sách không chứa số chẵn.");
        }

        int x = 1;
        int y = 10;

        System.out.println("Các số từ " + x + " đến " + y + ":");
        IntStream.range(x, y + 1)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("Anna", "John", "Zara", "Mike");

        System.out.println("Danh sách sau khi sắp xếp:");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Danh sách sau khi chuyển thành chữ in hoa:");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);



    }
}
