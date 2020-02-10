import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CrossZero extends JFrame {
    static int counter;

    public CrossZero() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(600, 300);
        JPanel p = new JPanel(new GridLayout(3, 3));
        JButton[][] btns = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j] = new JButton();
                JButton copy = btns[i][j];
                int finali = i;
                int finalj = j;
                copy.addActionListener(e -> {
                    copy.setText("X");
                    copy.setEnabled(false);
                    if (checkWin(btns)) {
                        windowDialog("Вы выиграли!");
                        return;
                    }
                    counter++;
                    System.out.printf("Button [%d][%d] cliked, counter: %d\n", finali, finalj, counter);
                    if (counter == 9) {
                        windowDialog("Ничья!");
                        return;
                    }
                    moveAI(btns);
                    if (checkWin(btns)) {
                        windowDialog("Вы проиграли!");
                        return;
                    }

                });
                p.add(btns[i][j]);
            }
        }

        add(p);
        setVisible(true);
    }

    private void moveAI(JButton[][] btns) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (btns[i][j].getText().isEmpty()) {
//                    btns[i][j].setText("O");
//                    btns[i][j].setEnabled(false);
//                    counter++;
//                    return;
//                }
//            }
//        }

        Random rnd = new Random();
        int x = -1;
        int y = -1;
        int status = 0;

        // Нападение
        if (status == 0) {
            for (int i = 0; i < 3; i++) {
                int win = 0, fld = 0, winAI = 0;
                for (int j = 0; j < 3; j++) {

                    if (btns[i][j].getText().equals("O")) {
                        winAI += 1;
                    }
                    if (btns[i][j].getText().isEmpty()) {
                        fld += 1;
                        y = i;
                        x = j;
                    }
                }
                if (winAI == 2 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }
        if (status == 0) {
            for (int i = 0; i < 3; i++) {
                int win = 0, fld = 0, winAI = 0;
                for (int j = 0; j < 3; j++) {

                    if (btns[j][i].getText().equals("O")) {
                        winAI += 1;
                    }
                    if (btns[j][i].getText().isEmpty()) {
                        fld += 1;
                        y = j;
                        x = i;
                    }
                }
                if (winAI == 2 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }

        if (status == 0) {
            int win = 0, fld = 0, winAI = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {

                        if (btns[i][j].getText().equals("O")) {
                            winAI += 1;
                        }
                        if (btns[i][j].getText().isEmpty()) {
                            fld += 1;
                            y = i;
                            x = j;
                        }
                    }
                }
            }
            if (winAI == 2 && fld == 1) {
                status = 1;
            }
        }

        if (status == 0) {
            int win = 0, fld = 0, winAI = 0;
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i + j == 4) {

                        if (btns[i-1][j-1].getText().equals("O")) {
                            winAI += 1;
                        }
                        if (btns[i-1][j-1].getText().isEmpty()) {
                            fld += 1;
                            y = i-1;
                            x = j-1;
                        }
                    }
                }
            }
            if (winAI == 2 && fld == 1) {
                status = 1;
            }
        }

        // Защита
        if (status == 0) {
            for (int i = 0; i < 3; i++) {
                int win = 0, fld = 0, winAI = 0;
                for (int j = 0; j < 3; j++) {
                    if (btns[i][j].getText().equals("X")) {
                        win += 1;
                    }

                    if (btns[i][j].getText().isEmpty()) {
                        fld += 1;
                        y = i;
                        x = j;
                    }
                }
                if (win == 2 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }
        if (status == 0) {
            for (int i = 0; i < 3; i++) {
                int win = 0, fld = 0, winAI = 0;
                for (int j = 0; j < 3; j++) {
                    if (btns[j][i].getText().equals("X")) {
                        win += 1;
                    }

                    if (btns[j][i].getText().isEmpty()) {
                        fld += 1;
                        y = j;
                        x = i;
                    }
                }
                if (win == 2 && fld == 1) {
                    status = 1;
                    break;
                }
            }
        }

        if (status == 0) {
            int win = 0, fld = 0, winAI = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        if (btns[i][j].getText().equals("X")) {
                            win += 1;
                        }

                        if (btns[i][j].getText().isEmpty()) {
                            fld += 1;
                            y = i;
                            x = j;
                        }
                    }
                }
            }
            if (win == 2 && fld == 1) {
                status = 1;
            }
        }

        if (status == 0) {
            int win = 0, fld = 0, winAI = 0;
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (i + j == 4) {
                        if (btns[i-1][j-1].getText().equals("X")) {
                            win += 1;
                        }

                        if (btns[i-1][j-1].getText().isEmpty()) {
                            fld += 1;
                            y = i-1;
                            x = j-1;
                        }
                    }
                }
            }
            if (win == 2 && fld == 1) {
                status = 1;
            }
        }

        if (status == 0) {
            do {

                x = rnd.nextInt(3);
                y = rnd.nextInt(3);
            } while ((0 > x || x > 2)||(0 > y || y > 2)||!btns[y][x].getText().isEmpty());
        }
        btns[y][x].setText("O");
        btns[y][x].setEnabled(false);
        counter++;
        System.out.printf("Move AI [%d][%d], counter: %d\n", y, x, counter);
    }

    private void windowDialog(String s) {
        JFrame dialog = new JFrame("Start new game");
        dialog.setSize(200, 100);
        dialog.setLocation(600, 300);
        JLabel label = new JLabel(s);
        dialog.getContentPane().add(label, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton start = new JButton("Начать новую игру");
        start.addActionListener(action -> {
            new CrossZero();
            counter = 0;
            dispose();
            dialog.dispose();
        });
        dialog.add(start, BorderLayout.PAGE_END);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private boolean checkWin(JButton[][] btns) {
        for (int i = 0; i < 3; i++) {
            int win = 0;
            for (int j = 0; j < 3; j++) {
                if (btns[i][j].getText().equals("X")) {
                    win += 1;
                }
                if (btns[i][j].getText().equals("O")) {
                    win -= 1;
                }
            }
            if (win == 3 || win == -3) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            int win = 0;
            for (int j = 0; j < 3; j++) {
                if (btns[j][i].getText().equals("X")) {
                    win += 1;
                }
                if (btns[j][i].getText().equals("O")) {
                    win -= 1;
                }
            }
            if (win == 3 || win == -3) {
                return true;
            }
        }
        int win = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (btns[i][j].getText().equals("X")) {
                        win += 1;
                    }
                    if (btns[i][j].getText().equals("O")) {
                        win -= 1;
                    }
                }
            }
        }
        if (win == 3 || win == -3) {
            return true;
        }

        win = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i + j == 3 + 1) {
                    if (btns[i-1][j-1].getText().equals("X")) {
                        win += 1;
                    }
                    if (btns[i-1][j-1].getText().equals("O")) {
                        win -= 1;
                    }
                }
            }
        }
        if (win == 3 || win == -3) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        new CrossZero();

    }
}
