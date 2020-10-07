import java.io.*;

public class Variant2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\vipka\\Desktop\\2 КУРС\\АиП\\Lab6IlyaB\\text.txt")));
            out = new PrintWriter("C:\\Users\\vipka\\Desktop\\2 КУРС\\АиП\\Lab6IlyaB\\result.txt");
            String s;
            int fw = 0;
            int fwl = 0;
            int count =1;
            while ((s = br.readLine()) != null) {
                for (String word : s.split(" ")) { // разделение строки s на слова word ориентируясь на пробелы
                    if (fw == 0) { // нахождение длины первого слова в строке
                        System.out.print("Длина первого слова " + count + " строки = " + word.length()); // вывод строк
                        out.print(word + " ");
                        fw++;
                        count++;
                        fwl = word.length();
                    } else if (fwl < word.length()) { //сравнение длины символов с длиной первого слова в строке
                        out.print(word + " ");
                    }
                }
                fw = 0;
                System.out.println();
                out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        } finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}

