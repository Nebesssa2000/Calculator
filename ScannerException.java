public class ScannerException extends Exception {// была идея вывести исключения в отдельный файл, но пока не реализовал
    public ScannerException(){
        System.out.println("Введенные числа меньше 1 или больше 10");

    }
    public void NullPointerException(){
        System.err.println("В римской системе нет отрицательных чисел");
    }
    public void StringIndexOutOfBoundsException(){
        System.err.println("В римской системе нет отрицательных чисел");
    }
    public void NumberFormatException(){
        System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }
}
