import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Test {
    /** 1 задание.
     * ОТВЕТ: 70
     */
    /** 2 задание.
     * ОТВЕТ
     7   4  6              7   5  6
     8  11  5              10 11  4
     3  10  9              3   8  9
     Возможны еще варианты
     */
    /** 3 задание.
     * ОТВЕТ: 100
     */
    /** 4 задание
     *ОТВЕТ: 60
     */
    /**
     *
     *
     * 
     * Задача 1
     * <p>
     * Написать метод/функцию, который/которая на вход принимает массив городов. В качестве результата возвращает строку,
     * где города разделены запятыми, а в конце стоит точка.
     * Пример:
     * «Москва, Санкт-Петербург, Воронеж.»
     * <p>
     * <p>
     * <p>
     * Потратил на решение не более 5 минут
     * Исходя из условия, конечно нужно было создать класс Town со String полем(к примеру, name)  - Название этого города,
     * с обязательным конструктором, где нужно присвоить название этому городу,а также создать геттер и сеттер для поля Названия города.
     * И уже в массив класть строки с названиями городов - Town.getName(). Это по правилам Java, C++. В Javascript, PHP - это делается проще.
     */
    public static String towns(String[] towns) {
        StringBuilder builder = new StringBuilder();

        Arrays.stream(towns).forEach(town -> builder.append(town + ", "));
        builder.replace(builder.lastIndexOf(", "), builder.length() - 1, ".").deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    /**
     * Задача 2
     * Написать метод/функцию, который/которая на вход принимает число (float), а на выходе получает число, округленное до пятерок.
     * Пример:  27 => 25, 27.8 => 30, 41.7 => 40.
     * <p>
     * <p>
     * Потратил на решение 5 минут
     */
    public static int roundUpToFive(float number) {
        BigDecimal big = new BigDecimal(number / 5);

        return big.setScale(0, RoundingMode.HALF_UP).intValue() * 5;
    }

    /**
     * Задача 3
     * Написать метод/функцию, который/которая на вход принимает число (int), а на выходе выдает слово “компьютер” в падеже,
     * соответствующем указанному количеству. Например, «25 компьютеров», «41 компьютер», «1048 компьютеров».
     * <p>
     * <p>
     * Потратил на решение ~20 минут
     */
    public static String caseComputer(int number) {
        StringBuilder builder = new StringBuilder(number + " компьютер");
        String numberAsString = String.valueOf(number);

        Pattern withOnePattern = Pattern.compile("[\\d]*1");
        Pattern exceptionsPattern = Pattern.compile("[\\d]*1[1234]");
        Pattern aPattern = Pattern.compile("[\\d]*[234]");

        if (exceptionsPattern.matcher(numberAsString).matches()) return builder.append("ов").toString();
        if (aPattern.matcher(numberAsString).matches()) return builder.append("a").toString();
        if (withOnePattern.matcher(numberAsString).matches()) return builder.toString();

        return builder.append("ов").toString();
    }

    /**
     * Задача 4
     * Написать метод/функцию, который/которая на вход принимает целое число, а на выходе возвращает то,
     * является ли число простым (не имеет делителей кроме 1 и самого себя).
     * <p>
     * <p>
     * Потратил на решение ~2 минуты. в Java уже реализован поиск простых чисел. Также приложил и свой метод
     */
    public static boolean isPrime(int number) {
        return new BigInteger(String.valueOf(number)).isProbablePrime(number);
    }

    public static boolean isPrimeCustom(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Задача 5
     * Написать метод, который определяет, какие элементы присутствуют в двух экземплярах в каждом из массивов (= в двух и более, причем в каждом).
     * На вход подаются два массива. На выходе массив с необходимыми совпадениями.
     * Пример:[7, 17, 1, 9, 1, 17, 56, 56, 23], [56, 17, 17, 1, 23, 34, 23, 1, 8, 1]
     * На выходе [1, 17]
     * <p>
     * <p>
     * * Потратил на решение ~20 минут
     */
    public static int[] result(int[] a, int[] b) {

        Set<Integer> set = new HashSet();

        int[] left = Arrays.stream(a).filter(f -> !set.add(f)).toArray();

        set.clear();

        int[] right = Arrays.stream(b).filter(f -> !set.add(f)).toArray();

        return Arrays.stream(left).takeWhile(f -> Arrays.stream(right).anyMatch(s -> f == s)).toArray();
    }

    /**
     * Написать метод, который в консоль выводит таблицу умножения. На вход метод получает число, до которого выводит таблицу умножения.
     * В консоли должна появиться таблица.
     * <p>
     * Важно:
     * В последней строке между числами ровно по одному пробелу должно выводиться.
     * В каждом столбце числа должны быть выровнены по правому краю.
     * <p>
     * <p>
     * <p>
     * * Потратил на решение ~20 минут
     */
    public static void table(int number) {
        System.out.print(" ");
        for (int i = 1; i <= number; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.printf("\n");

        for (int i = 1; i <= number; i++) {
            System.out.print(i);
            for (int j = 1; j <= number; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.printf("\n");
        }
    }


    public static void main(String[] args) {

    }
}
