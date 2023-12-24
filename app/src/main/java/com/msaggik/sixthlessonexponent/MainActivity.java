package com.msaggik.sixthlessonexponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // поля
    // строка для анализа
    private String pi = "3,1415926535 8979323846 2643383279 5028841971 6939937510 5820974944 5923078164 0628620899 8628034825 3421170679 8214808651 3282306647" +
            "0938446095 5058223172 5359408128 4811174502 8410270193 8521105559 6446229489 5493038196 4428810975 6659334461 2847564823 3786783165 2712019091 4564856692" +
            "3460348610 4543266482 1339360726 0249141273 7245870066 0631558817 4881520920 9628292540 9171536436 7892590360 0113305305 4882046652 1384146951 9415116094";
    private int[] arrayInt; // массив для цифр заданного числа
    private int volumeIII, volumeV; // количество определенных цифр в массиве (3,5)
    private int anPopularDigit; // самая редкая цифра
    private int[] reversArrayInt; // массив задом наперёд
    private String  reversStringInt; // массив задом наперёд в виде строки

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация полей
        arrayInt = arrayInt(pi);
        volumeIII = volumeX(arrayInt, 3);
        volumeV = volumeX(arrayInt,5);
        anPopularDigit = anPopularDigit(arrayInt);
        reversArrayInt = reversArrayInt(arrayInt);
        reversStringInt = Arrays.toString(reversArrayInt); // преобразование массива в строку

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("Массив из строки: " + Arrays.toString(arrayInt) + "\n"
                + "Количество цифр 3: " + volumeIII + "\n"
                + "Количество цифр 5: " + volumeV + "\n"
                + "Самая редко встречающаяся цифра: " + anPopularDigit + "\n"
                + "Отсортированный массив: " + reversStringInt);
    }

    // метод определения массива задом наперёд
    private int[] reversArrayInt(int[] arrayDigit) {
        int[] revers = new int[arrayDigit.length]; // задание нового массива
        for (int i = arrayDigit.length - 1; i >= 0; i--) { // перебор входного массива
            revers[arrayDigit.length - (i + 1)] = arrayDigit[i]; // инициализация задом наперёд
        }
        return revers;
    }
/*
    // 1 метод определения самой редкой цифры
    private int anPopularDigit(int[] arrayDigit) {
        int[] count = new int[10]; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            switch (i) { // заполнение счётчиков
                case 0: count[0]++; break;
                case 1: count[1]++; break;
                case 2: count[2]++; break;
                case 3: count[3]++; break;
                case 4: count[4]++; break;
                case 5: count[5]++; break;
                case 6: count[6]++; break;
                case 7: count[7]++; break;
                case 8: count[8]++; break;
                case 9: count[9]++; break;
            }
        }
        int anPopular = 1; // задание параметра самой редкой цифры
        for (int i = 0; i < count.length; i++) { // перебор массива счётчика
            if (count[i] < count[anPopular]) anPopular = i;
        }
        return anPopular;
    }
*/
    // 2 метод определения самой редкой цифры
    private int anPopularDigit(int[] arrayDigit) {
        int[] count = new int[10]; // определение счётчика
        for (int i = 0; i <= 9 ; i++){
            count[i] = volumeX(arrayDigit, i);
            }
        int anPopular = 1; // задание параметра самой редкой цифры
        for (int i = 0; i < count.length; i++) { // перебор массива счётчика
            if (count[i] < count[anPopular]) anPopular = i;
        }
        return anPopular;
    }

    // метод определения количества любых цифр в массиве
    private int volumeX(int[] arrayDigit, int x) {
        int count = 0; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            if (i == x) {
                count++;
            }
        }
        return count;
    }

    // метод получения массива заданного числа
    private int[] arrayInt(String string) {
        String stringWithoutPoint = string.replace(",", ""); // удаление точки из входных данных
        String stringNew = stringWithoutPoint.replace(" ", ""); // удаление пробелов из входных данных
        String[] arrayString = stringNew.split(""); // деление входных данных на символы
        int[] arrayInteger = new int[arrayString.length]; // создание числового массива для данных
        // заполнение числового массива путём конвертирования данных строкового массива
        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }
}