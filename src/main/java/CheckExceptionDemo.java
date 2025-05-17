import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckExceptionDemo {
    // 方法声明 throws，表示可能抛出受检异常
    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file); // 可能抛出 FileNotFoundException
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    // 方法无需声明 throws，因为 IllegalArgumentException 是非受检异常
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能为负数！"); // 非受检异常
        }
        System.out.println("年龄合法: " + age);
    }

    public static void main(String[] args) {
        validateAge(-5);
        try {
            readFile("nonexistent.txt"); // 必须 try-catch 或继续 throws
        } catch (FileNotFoundException e) {
            System.err.println("文件不存在！"); // 必须处理
        }
    }
}