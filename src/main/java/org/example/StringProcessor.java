package org.example;

import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

public class StringProcessor {
    //проверяет, является ли пароль «сильным», согласно указанным критериям.
    public boolean isStrongPassword(String password) {
        // Проверяем, что длина пароля не менее 8 символов
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;

        // Перебираем каждый символ в пароле
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true; // Есть заглавная буква
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true; // Есть строчная буква
            } else if (Character.isDigit(ch)) {
                hasDigit = true; // Есть цифра
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialSymbol = true; // Есть специальный символ
            }
        }

        // Возвращаем true, если все условия выполнены
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialSymbol;
    }


    // Метод для подсчета цифр в строке
    public int calculateDigits(String sentence) {
        int digitCount = 0;

        if (sentence == null) {
            return 0; // Возвращаем 0, если строка null
        }

        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }

        return digitCount;
    }

    // Метод для подсчета слов в строке
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Метод для вычисления выражения
    public double calculateExpression(String expression) {
        // Стек для хранения чисел
        Stack<Double> values = new Stack<>();
        // Стек для хранения операторов
        Stack<Character> ops = new Stack<>();

        double tempNumber = 0; // Переменная для текущего числа
        char previousOperator = '+'; // Предыдущий оператор, по умолчанию '+' для первого числа

        for (int index = 0; index < expression.length(); index++) {
            char currentChar = expression.charAt(index); // Получаем текущий символ

            // Если символ - цифра, формируем текущее число
            if (Character.isDigit(currentChar)) {
                tempNumber = tempNumber * 10 + (currentChar - '0'); // Собираем число
            }

            // Если символ - оператор или конец строки
            if ((!Character.isDigit(currentChar) && currentChar != ' ' && currentChar != '(') || index == expression.length() - 1) {
                // Обрабатываем предыдущий оператор
                if (previousOperator == '+') {
                    values.push(tempNumber); // Добавляем текущее число
                }
                if (previousOperator == '-') {
                    values.push(-tempNumber); // Добавляем отрицательное число
                }
                if (previousOperator == '*') {
                    values.push(values.pop() * tempNumber); // Умножаем предыдущее число
                }
                if (previousOperator == '/') {
                    values.push(values.pop() / tempNumber); // Делим предыдущее число
                }

                previousOperator = currentChar; // Обновляем предыдущий оператор
                tempNumber = 0; // Сбрасываем текущее число
            }
        }

        double finalResult = 0; // Переменная для хранения итогового результата
        // Суммируем все числа из стека
        while (!values.isEmpty()) {
            finalResult += values.pop(); // Извлекаем числа и добавляем к итоговому результату
        }

        return finalResult; // Возвращаем итоговый результат
    }

}



