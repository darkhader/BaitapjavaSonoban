
import java.util.Random;
import java.util.Scanner;

public class Bai1va2 {

    public static void main(String[] args) {
        String[][] map = {
                {"G", "*", "y", "*"},
                {"*", "*", "*", "*"},
                {"x", "*", "P", "*"},
                {"*", "*", "*", "*"}
        };

        Scanner scanner = new Scanner(System.in);
        int ex = 2;
        int ey = 2;
        int px = 2;
        int py = 2;

        while (true) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[j][i] + " ");
                }
                System.out.println();
            }

            System.out.println("Nhap ky tu ban phim: ");
            String key = scanner.next();
            map[ex][0] = "*";
            map[0][ey] = "*";
            map[0][0] = "G";
            map[px][py] = "*";
            Random rd = new Random();
            switch (key) {
                case "w":

                    py -= 1;
                    ex += rd.nextInt(3) - 1;
                    ey += rd.nextInt(3) - 1;
                    break;
                case "s":
                    py += 1;
                    ex += rd.nextInt(3) - 1;
                    ey += rd.nextInt(3) - 1;
                    break;
                case "a":
                    px -= 1;
                    ex += rd.nextInt(3) - 1;
                    ey += rd.nextInt(3) - 1;
                    break;
                case "d":
                    px += 1;
                    ex += rd.nextInt(3) - 1;
                    ey += rd.nextInt(3) - 1;
                    break;
            }
            if (ey == -1) {
                ey = map.length - 1;
            }
            if (ey == map.length) {
                ey = 0;
            }
            if (ex == -1) {
                ex = map.length - 1;
            }
            if (ex == map.length) {
                ex = 0;
            }
            if (py == -1) {
                py = map.length - 1;
            }
            if (py == map.length) {
                py = 0;
            }
            if (px == -1) {
                px = map.length - 1;
            }
            if (px == map.length) {
                px = 0;
            }
            if (px == ex && py == 0) {
                System.out.println("thua");
                break;
            }
            if (px == 0 && py == ey) {
                System.out.println("thua");
                break;
            }
            if (px == 0 && py == 0) {
                System.out.println("Win");
                break;
            }
            map[px][py] = "P";
            map[ex][0] = "x";
            map[0][ey] = "y";

        }
    }

}
