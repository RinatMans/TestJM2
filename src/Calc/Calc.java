package Calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calc {
    enum Rome{
        I,II,III,IV,V,VI,VII,VIII,IX,X
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input: ");
        String str = reader.readLine();                  // вводим данные с клавиатуры
        int a,b;
        String result;
        String[] symbols = str.split(" ");          //делим строку на 3 части, ориентируемся на пробел
        if (symbols.length != 3) throw new Exception("Неверное выражение");       //проверка на правильность ввода строки

        try {
            Rome.valueOf(symbols[0]);                            //проверка на принадлежность 1го чисела перечислению Rome
            Rome.valueOf(symbols[2]);                            //проверка на принадлежность 2го чисела

            a = Rome.valueOf(symbols[0]).ordinal()+1;             //а присваиваем индекс найденного римского в перечислении +1
            b = Rome.valueOf(symbols[2]).ordinal()+1;             //b присваиваем индекс найденного римского в перечислении +1
            Integer romeResult = Integer.valueOf(Action.calculate(a, b, symbols[1]));  //запуск действия калькулятор

            if (romeResult <= 0) {
                throw new Exception("Результат отрицательное число или ноль");
            } else {
                result = IntToRome.RomanNumerals(romeResult);
            }
        } catch (Exception e)  {
            a = Integer.valueOf(symbols[0]);
            b = Integer.valueOf(symbols[2]);
            if (a < 0 | a > 10 | b < 0 | b > 10) {                //проверка условия задачи >0 и <10
                throw new Exception("Неверные числа");
            } else {
                Integer IntResult = Integer.valueOf(Action.calculate(a, b, symbols[1]));
                result = Action.calculate(a, b, symbols[1]);
            }
        }

        /*
          if ((Rome.valueOf(symbols[0]) !=null) && (Rome.valueOf(symbols[2]) !=null)) {
              a = Rome.valueOf(symbols[0]).ordinal()+1;             //а присваиваем индекс найденного римского в перечислении +1
              b = Rome.valueOf(symbols[2]).ordinal()+1;             //b присваиваем индекс найденного римского в перечислении +1
              Integer romeResult = Integer.valueOf(Action.calculate(a, b, symbols[1]));   //запуск действия калькулятор
              if (romeResult <= 0) {
                  throw new Exception("Результат отрицательное число или ноль");
              } else {
                  result = IntToRome.RomanNumerals(romeResult);
              }
          }
          else{
                  a = Integer.valueOf(symbols[0]);
                  b = Integer.valueOf(symbols[2]);
                  if (a < 0 | a > 10 | b < 0 | b > 10) {
                      throw new Exception("Неверные числа");
                  } else {
                      Integer IntResult = Integer.valueOf(Action.calculate(a, b, symbols[1]));
                      result = Action.calculate(a, b, symbols[1]);
                  }
              }
            */
        System.out.println("Output:");
        System.out.println(result);
    }
}