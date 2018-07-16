 import java.util.Random;
        import java.util.Scanner;

/**
 *
 * @author Hiep Nguyen
 */
public class Bai3 {

    static int px, py, bx, by, gx, gy,vx,vy;
    static Scanner sc = new Scanner(System.in);

    static int[][] a = new int[10][10];
    static String move = "";

    public static void main(String[] args) {
        thietkeMT();
        while (true) {
            veMT();
            System.out.println("Di chuyen: ");
            move = sc.next();
            choi(move);
            if(bx==gx && by == gy){
                System.out.println("win");
                a[gx][gy]=2;

            }


        }
    }

    private static void veMT() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                a[i][j] = 0;
                for (int k = 0; k < 5; k++) {
                    a[4][k] = 4;

                }

                a[px][py] = 1;
                a[bx][by] = 2;
                a[gx][gy] = 3;

                switch (a[i][j]) {
                    case 0:
                        System.out.print(" - ");
                        break;
                    case 1:
                        System.out.print(" P ");
                        break;
                    case 2:
                        System.out.print(" B ");
                        break;
                    case 3:
                        System.out.print(" G ");
                        break;
                    case 4:
                        System.out.print(" W ");
                        break;
                    default:
                        break;
                }

            }
            System.out.println("");
        }
    }

    private static void thietkeMT() {
        Random rd = new Random();
        px = rd.nextInt(10);
        py = rd.nextInt(10);
        gx = rd.nextInt(10);
        gy = rd.nextInt(10);
        bx = rd.nextInt(10);
        by = rd.nextInt(10);
        if ((px == gx && py == gy) || (px == bx && py == by) || (px == bx && py == by) || (px == 4 && py < 5) || (bx == 4 && by < 5) || (gx == 4 && gy < 5) ||bx==0 ||by==0) {
            px = rd.nextInt(10);
            py = rd.nextInt(10);
            gx = rd.nextInt(10);
            gy = rd.nextInt(10);
            bx = rd.nextInt(10);
            by = rd.nextInt(10);
        }

    }

    private static void choi(String move) {

        switch (move) {
            case "w":
                vx = -1;
                vy = 0;
                break;
            case "s":
                vx = 1;
                vy = 0;
                break;
            case "a":
                vy = -1;
                vx = 0;
                break;
            case "d":
                vy = 1;
                vx = 0;
                break;
            default:
                vx=0;
                vy=0;
                break;
        }
        if (py+vy < 0 || py+vy > 9) {
            py += 0;
            return;
        }

        if (px+vx < 0 ||px+vx > 9 ) {
            px += 0;
            return;
        }

        if(px+vx==bx && vy+py==by){
            if (by+vy < 0 || by+vy > 9) {
                by += 0;
                return;
            }

            if (bx+vx < 0 ||bx+vx > 9 ) {
                bx += 0;
                return;
            }
            bx+=vx;
            by+=vy;
            px+=vx;
            py+=vy;
            return;
        }

        px+=vx;
        py+=vy;
    }
}


