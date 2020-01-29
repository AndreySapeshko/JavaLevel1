import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class CrossZero {
    public static final char CHAR_FIELD = '_';
    public static final char CHAR_HUMAN = 'X';
    public static final char CHAR_AI = 'O';
    public static int sizeMap = 0;
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
        iniMap();
        printMap();
        while (true) {
            humanMove();
            printMap();
            if (checkWin()) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (openField()) {
                System.out.println("Ничья!");
                break;
            }
            aiMove();
            printMap();
            if (checkWin()) {
                System.out.println("Компьютер выиграл!");
                break;
            }
            if (openField()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    static void iniMap() {

        do {
            System.out.println("Игра \"Крестики-Нолики\"\nНа каком поле хотите сыграть?" +
                    "\n3Х3 - введите: 3\n4Х4 - введите: 4\n5Х5 - введите: 5");
            sizeMap = sc.nextInt();
        } while (!(sizeMap == 3 || sizeMap == 4 || sizeMap == 5));
        map = new char[sizeMap][sizeMap];
        for (int i = 0; i < map.length; i++) {
            fill(map[i], CHAR_FIELD);
        }
    }
    static void printMap() {
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
            if (i == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " |");
            for ( int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }

    }
    static void aiMove() {
        int x = -1;
        int y = -1;
        int status = 0;
        if (status == 0) {
            for (int i = 0; i < map.length; i++) {
                int win = 0, fld = 0;
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == CHAR_HUMAN) {
                        win += 1;
                    }
                    if (map[i][j] == CHAR_FIELD) {
                        fld += 1;
                        y = i;
                        x = j;
                    }
                }
                if (win == sizeMap - 1 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }
        if (status == 0) {
            for (int i = 0; i < map.length; i++) {
                int win = 0, fld = 0;
                for (int j = 0; j < map[i].length; j++) {
                    if (map[j][i] == CHAR_HUMAN) {
                        win += 1;
                    }
                    if (map[j][i] == CHAR_FIELD) {
                        fld += 1;
                        y = j;
                        x = i;
                    }
                }
                if (win == sizeMap -1 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }

        if (status == 0) {
            int win = 0, fld = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == j) {
                        if (map[i][j] == CHAR_HUMAN) {
                            win += 1;
                        }
                        if (map[i][j] == CHAR_FIELD) {
                            fld += 1;
                            y = i;
                            x = j;
                        }
                    }
                }
            }
            if (win == sizeMap -1 && fld == 1) {
                status = 1;
            }
        }

        if (status == 0) {
            int win = 0,fld = 0;
            for (int i = 1; i <= map.length; i++) {
                for (int j = 1; j <= map[i-1].length; j++) {
                    if (i + j == sizeMap + 1) {
                        if (map[i-1][j-1] == CHAR_HUMAN) {
                            win += 1;
                        }
                        if (map[i-1][j-1] == CHAR_FIELD) {
                            fld += 1;
                            y = i-1;
                            x = j-1;
                        }
                    }
                }
            }
            if (win == sizeMap -1 && fld == 1) {
                status = 1;
            }
        }

        if (status == 0) {
            do {

                x = rnd.nextInt(sizeMap);
                y = rnd.nextInt(sizeMap);
            } while ((1 > x || x > sizeMap)||(1 > y || y > sizeMap)||map[y][x] != CHAR_FIELD);
        }
        map[y][x] = CHAR_AI;
        System.out.println("Компьютер походил в ячейку вертиклаь: " + (x + 1) + ", по горизонтали: " + (y + 1));
    }
    private static void humanMove() {
        int x;
        int y;
        do {
            System.out.println("Укажите пустую ячейку в которую хотите слелать ход." +
                    "\nВведите ее адрес по вертикали, затем по горизонтали.");
            x = sc.nextInt();
            y = sc.nextInt();
        } while ((1 > x || x > sizeMap)||(1 > y || y > sizeMap)||map[y-1][x-1] != CHAR_FIELD);
        map[y-1][x-1] = CHAR_HUMAN;
    }
    static boolean checkWin() {

        for (int i = 0; i < map.length; i++) {
            int win = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == CHAR_HUMAN) {
                    win += 1;
                }
                if (map[i][j] == CHAR_AI) {
                    win -= 1;
                }
            }
            if (win == sizeMap || win == -sizeMap) {
                return true;
            }
        }
        for (int i = 0; i < map.length; i++) {
            int win = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == CHAR_HUMAN) {
                    win += 1;
                }
                if (map[j][i] == CHAR_AI) {
                    win -= 1;
                }
            }
            if (win == sizeMap || win == -sizeMap) {
                return true;
            }
        }
        int win = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    if (map[i][j] == CHAR_HUMAN) {
                        win += 1;
                    }
                    if (map[i][j] == CHAR_AI) {
                        win -= 1;
                    }
                }
            }
        }
        if (win == sizeMap || win == -sizeMap) {
            return true;
        }

        win = 0;
        for (int i = 1; i <= map.length; i++) {
            for (int j = 1; j <= map[i-1].length; j++) {
                if (i + j == sizeMap + 1) {
                    if (map[i-1][j-1] == CHAR_HUMAN) {
                        win += 1;
                    }
                    if (map[i-1][j-1] == CHAR_AI) {
                        win -= 1;
                    }
                }
            }
        }
        if (win == sizeMap || win == -sizeMap) {
            return true;
        }


        return false;
    }
    private static boolean openField() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == CHAR_FIELD) {
                    return false;
                }
            }
        }

        return true;
    }
}
