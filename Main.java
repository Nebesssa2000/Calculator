import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String data = scanner.nextLine();
        Calc(data);



    }

    public static String Calc(String expression) throws ScannerException
    {
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
        if (operationValue == -1) {
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("строка не является математической операцией");
            }

        }

        String[] material = expression.split(separator[operationValue]);
        for (int c = 0;c < material.length; c++)
        {
            if (c > 1)
            {
                try
                {
                    throw new ScannerException();
                }
                catch (ScannerException e)
                {
                    System.err.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            }
        }

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
                } catch (IOException e) { System.err.println("Введенные числа меньше 1 или больше 10");}
            } result = switch (operation[operationValue]) {// Производим математические операции
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;};
            if (isRoman) {
                //если числа были римские, преобразуем результат ввиде римского числа
                System.out.println(changeNumber.intToRoman(result));
            } else { //если числа были арабские, выводим результат
                System.out.println(result); }
        } else { System.err.println("используются одновременно разные системы счисления");// если числа разных систем выводим исключение
               }
        return String.valueOf(result);
    }
}




