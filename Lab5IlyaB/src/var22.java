import java.io.*;
import java.util.Scanner;

public class var22 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            File f1 = new File("var2.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь: " + f1.getAbsolutePath());
            }
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            for (int i = 1; i < 6; i++) {
                System.out.println("Введите " + i + " число");
                wr.writeDouble(sc.nextDouble());
            }
            wr.flush();
            wr.close();

            File f2 = new File("Result.txt");
            f2.createNewFile();
            if (f2.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь: " + f2.getAbsolutePath());
            }
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
            int ws = 0;
            double i = -1;
            try {
                while ((i = rd.readDouble()) != -1) {
                    if (i >= 0) {
                        wr.writeDouble(i);
                        System.out.println(i);
                    }
                }
            } catch (EOFException e) {
                System.out.println("End");
            }
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.out.println("End of file");
        }
    }
}
//вывод только положительных чисел double