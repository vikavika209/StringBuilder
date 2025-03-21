package org.example;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();

        sb.append("Привет");
        System.out.println(sb);

        sb.append(", мир!");
        System.out.println(sb);

        sb.delete(6, 11);
        System.out.println(sb);

        sb.undo();
        System.out.println("После undo: " + sb);

        sb.undo();
        System.out.println("После второго undo: " + sb);

        sb.undo();
        System.out.println("После третьего undo: " + sb);

        sb.undo();
    }
}
