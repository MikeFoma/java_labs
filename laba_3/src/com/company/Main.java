/*3.	Напишите свой класс StringBuilder с поддержкой операции undo.
Для этого делегируйте все методы стандартному StringBuilder,
а в собственном классе храните список всех операций для выполнения undo().
Это будет реализацией шаблона «Команда».*/

package com.company;

public class Main {

    public static void main(String[] args) {
        StrBuilder sb = new StrBuilder("Тут есть некий текст");
        System.out.println(sb);
        sb.append(" ДА ДА");
        sb.append(1);
        System.out.println(sb);
        sb.actions.pop().undo();
        System.out.println(sb);
        char [] arr ={' ', 'Т','Е','К','С', 'Т', ' '};
        sb.append(arr);
        System.out.println(sb);
        boolean bool = true;
        sb.append(bool);
        System.out.println(sb);
        sb.replace(1,3,"ЛОЛ КЕК ЧЕБУРЕК");
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
        sb.insert(0, "NOT ");
        sb.insert(sb.toString().length(), false);
        System.out.println(sb);
    }
}