package Calc;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRome {
    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman = new LinkedHashMap<String, Integer>();
        roman.put("C", 100);  // нам этого достаточно по условию задачи максимальное может быть X * X
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);
        String res = "";
        String repeated ="";

        for(Map.Entry<String, Integer> entry : roman.entrySet()){     //перебираем связанный список поэлементно
            int matches = Int/entry.getValue();                       //делим наше число на 100,90,50,....
            repeated = new String(new char[matches]).replace("\0", entry.getKey());    //копируем элем. списка необходимое кол. раз (matches)
            res = res + repeated;                                                           // склеиваем в общую строку
            Int = Int % entry.getValue();             //находим остаток, меняем наше число остатком
        }
        return res;
    }

}