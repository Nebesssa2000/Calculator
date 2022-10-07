import java.util.Scanner;
import java.io.IOException;

public class Calc
{
    public static void main(String[] args)  throws ScannerException,IOException
    {
        Changer changeNumber = new Changer();// создаем переменную класса Charger преобразовыватель римских чисел в отдельном файле
        String[] operation = {"+", "-", "/", "*"}; // создаем массив с математическими операторами
        String[] separator = {"\\+", "-", "/", "\\*"};// создаем массив математических операторов для разделения выражения
        Scanner data = new Scanner(System.in);// Создаем новую переменную класса Scanner для захвата строки ввода
        while(true)
        { // запускаем цикл, чтобы не перезапускать программу каждый раз после выполнения
            System.out.print("Введите математическое выражение: ");// предлогаем пользователю ввести выражение
            String records = data.nextLine();// передаем введенное выражение в переменную records

            int operationValue = -1; // создаем переменную для преобразования математического оператора в целочисленное выражение
            for (int i = 0; i < operation.length; i++)
            { // в цикле определяем наличие в выражении оператора
                if (records.contains(operation[i]))
                { // ветвление, если оператор есть присваиваем его переменной operationValue
                    operationValue = i;
                    break; // заканчиваем цикл
                }
            }


            if (operationValue == -1)
            { //Проверка наличия математического действия
                System.err.println("строка не является математической операцией");
                return;
            }


            String[] material = records.split(separator[operationValue]);
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


            if (changeNumber.isRoman(material[0]) == changeNumber.isRoman(material[1]))
            {
                int a, b;


                boolean isRoman = changeNumber.isRoman(material[0]);// проверяем римские или арабские числа введены
                if (isRoman)
                { //если получили римские числа, преобразуем их в арабские
                    a = changeNumber.romanToInt(material[0]);
                    b = changeNumber.romanToInt(material[1]);
                }
                else
                {
                    //если арабские, преобразуем их из строки в число
                    a = Integer.parseInt(material[0]);// присваиваем переменной а значение полученое из массива и преобразованое в int
                    b = Integer.parseInt(material[1]);// тоже самое для b


                }
                if (a< 1 || a >10 || b >10) // проверяем что введенные числа больше 1 и меньше 10
                {
                    try
                    {
                        throw new IOException();
                    }
                    catch (IOException e)
                    {
                        System.err.println("Введенные числа меньше 1 или больше 10");
                    }

                }



                int result = switch (operation[operationValue]) {// Производим математические операции
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> a / b;
                };

                if (isRoman) {
                    //если числа были римские, преобразуем результат ввиде римского числа
                    System.out.println(changeNumber.intToRoman(result));
                }
                else
                { //если числа были арабские, выводим результат
                    System.out.println(result);
                }

            }
            else
            { // если числа разных систем выводим исключение
                System.err.println("используются одновременно разные системы счисления");
            }
        }

    }
}
