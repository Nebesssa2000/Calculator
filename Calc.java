import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static String data;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String data = scanner.nextLine();
        Calc(data);



    }

    public static String Calc(String expression) {
        Changer changeNumber = new Changer();
        String[] operation = {"+", "-", "/", "*"};
        String[] separator = {"\\+", "-", "/", "\\*"};
        int operationValue = -1;
        for (int i = 0; i < operation.length; i++) {
            if (expression.contains(operation[i])) {
                operationValue = i;
                break;

            }
        }
        if (operationValue == -1) { //Проверка наличия математического действия
            System.err.println("строка не является математической операцией");
            // return;
        }

        String[] material = expression.split(separator[operationValue]);
        int result = 0;
        if (changeNumber.isRoman(material[0]) == changeNumber.isRoman(material[1])) {
            int a, b;


            boolean isRoman = changeNumber.isRoman(material[0]);// проверяем римские или арабские числа введены
            if (isRoman) { //если получили римские числа, преобразуем их в арабские
                a = changeNumber.romanToInt(material[0]);
                b = changeNumber.romanToInt(material[1]);
            } else {
                //если арабские, преобразуем их из строки в число
                a = Integer.parseInt(material[0]);// присваиваем переменной а значение полученое из массива и преобразованое в int
                b = Integer.parseInt(material[1]);// тоже самое для b


            }
            if (a < 1 || a > 10 || b > 10) // проверяем что введенные числа больше 1 и меньше 10
            {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.err.println("Введенные числа меньше 1 или больше 10");
                }

            }


            result = switch (operation[operationValue]) {// Производим математические операции
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };

            if (isRoman) {
                //если числа были римские, преобразуем результат ввиде римского числа
                System.out.println(changeNumber.intToRoman(result));
            } else { //если числа были арабские, выводим результат
                System.out.println(result);
            }

        } else { // если числа разных систем выводим исключение
            System.err.println("используются одновременно разные системы счисления");

        }
        return String.valueOf(result);
    }
}
