package org.example;




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StringProcessorTest {

    StringProcessor processor = new StringProcessor();

    @org.junit.jupiter.api.Test
    void isStrongPassword() {
        assertTrue(processor.isStrongPassword("Aa1!example"));
        assertFalse(processor.isStrongPassword("weak")); // Слишком простой
        assertFalse(processor.isStrongPassword("NoSpecial1")); // Нет специального символа
        assertFalse(processor.isStrongPassword("NoDigit!")); // Нет цифры
        assertFalse(processor.isStrongPassword("Short1!")); // Слишком короткий
    }

    @org.junit.jupiter.api.Test
    void calculateDigits() {
        assertEquals(3, processor.calculateDigits("123abc")); // 3 цифры
        assertEquals(0, processor.calculateDigits("abcdef")); // Нет цифр
        assertEquals(4, processor.calculateDigits("12ab34cd")); // 4 цифры
        assertEquals(2, processor.calculateDigits("1a1")); // 2 цифры
        assertEquals(0, processor.calculateDigits(null)); // null возвращает 0
    }

    @org.junit.jupiter.api.Test
    void calculateWords() {
        assertEquals(6, processor.calculateWords("Hello world, this is a test.")); // 6 слов
        assertEquals(1, processor.calculateWords("single")); // 1 слово
        assertEquals(0, processor.calculateWords("")); // Пустая строка возвращает 0
        assertEquals(0, processor.calculateWords(null)); // null возвращает 0
        assertEquals(3, processor.calculateWords("   a b c   ")); // 3 слова с пробелами

    }

    @org.junit.jupiter.api.Test
    void calculateExpression() {
        assertEquals(16.0, processor.calculateExpression("4 * 4")); // 16
        assertEquals(9.0, processor.calculateExpression("3 * 3")); // 9
        assertEquals(5.0, processor.calculateExpression("10 / 2")); // 5
        assertEquals(1.0, processor.calculateExpression("3 - 2")); // 1
    }
}