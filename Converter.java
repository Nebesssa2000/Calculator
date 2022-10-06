import java.util.TreeMap;
import java.io.IOException;

public class Changer { //создаем класс Charger для преобразования арабских чисел в римские и обратно
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>(); // создаем переменную romanKeyMap класса Treemap
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>(); // создаем переменную arabianKeyMap класса Treemap

    public Changer() {  // дерево для преобразований римских чисел в арабские и обратно
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);


        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }


    public boolean isRoman(String number){ // создаем переменную для проверки римские или арабские числа введены

        return romanKeyMap.containsKey(number.charAt(0)); // отправляем результат в дерево
    }

    public String intToRoman(int number) throws NullPointerException { // создаем переменную для преобразования арабских чисел в римские
        String roman = "";
        int arabianKey = 0;
        do { try {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);  }
        catch (NullPointerException e) {  // исключение отрицательных чисел в римской системе
            System.err.println("В римском исчислении отсутствуют отрицательные числа");
            break;
        }
            number -= arabianKey;
        } while (number != 0);
        return roman;


    }
    public int romanToInt(String s) { // создаем переменную для переобразования результата в римские числа
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--)
        {
            arabian = romanKeyMap.get(arr[i]);

            if (arabian < romanKeyMap.get(arr[i + 1]))
            {
                result -= arabian;
            }
            else
            {
                result += arabian;
            }


        }
        return result;

    }
}
