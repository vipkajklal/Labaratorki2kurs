import java.io.*;
import java.util.Scanner;

public class var2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            File f1 = new File("var2.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь: " + f1.getAbsolutePath());
            }
            System.out.println("Введите 1 строку: ");
            String a = sc.nextLine();
            System.out.println("Введите 2 строку: ");
            String b = sc.nextLine();
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            wr.writeUTF(a + "\n");
            wr.writeUTF(b + "\n");
            /*for (int i = 1; i < 6; i++) {
                System.out.println("Введите " + i + " число");
                wr.writeDouble(sc.nextDouble());
                wr.writeUTF("\n a");
            }*/
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
            int i = -1;
            try {
                while ((i = rd.read()) != -1) {
                    if ((i == 10)) {
                        ws++;
                    } else if ((ws < 2) && (ws > 0)) {
                        wr.write((char) i);
                        System.out.print((char) i);
                    }
                   /* if ((ws == 2) && (i == 10)) {
                        double number = rd.readDouble();
                        if (number >= 0) {
                            wr.writeDouble(number);
                            System.out.println(" Число " + number);
                        }
                    }*/
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
//не получилось реализовать ввод 2 строки с выводом чисел double, поэтому программу разделил на 2 фрагмента, кусок кода, пытающийся вывести double я закомментил, а вывод 2 строки оставил.