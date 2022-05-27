package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * класс Main для общения с пользователем и вывода результата в консоль
 * в классе Main проверяются исключения try/catch
 *
 * @author Никита Анохин, группа 21ит35
 */
public class Main {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+");
        Matcher m;
        double result = 0;
        System.out.println("Enter an example: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = split(inputString.split(" "), result);
                        System.out.println(result);
                        return;
                    } else {
                        System.out.println("Input is not correct!");
                        return;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для работы с введенно пользователем строкой и поиска в нем нужных значений
     *
     * @param array массив для разрыва строки на значения, необходимый для длальнейшей работы с ними
     * @param previousResult переменная проверяющая предыдущий результат
     * @return возвращает значения для возможности их дальнейшего использования методе calculate
     * @throws Exception обрабатывает исключения
     */
    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double a;
        double b;
        if (array.length == 3) {
            a = Double.parseDouble(array[0]);
            operand = array[1];
            b = Double.parseDouble(array[2]);
            return calculate(a, b, operand);
        } else {
            throw new Exception("Input is not correct");
        }
    }

    /**
     * метод для реализации базовых функций калькулятора
     * @param a значение 1
     * @param b значение 2
     * @param operand действие, которое должно быть применено к значению
     * @return возвращает результат действия
     * @throws Exception обрабатывает исключения
     */
    private static double calculate(double a, double b, String operand) throws Exception {
        switch (operand) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            case "%":
                return a % b;
            default:
                throw new Exception("Input is not correct");
        }
    }
}