package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Robot {
    int x;
    int y;
    int direction;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void shiftLeft() {
        direction = (direction + 1) % 4;
    }
}

public class BJ14503 {

    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int CLEAN = 2;

    private static int answer = 0;
    private static int[][] rooms;
    private static int r, c;
    private static Robot robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br);
        printAnswer(bw);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        rooms = new int[r][c];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        robot = new Robot(x, y, direction);
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    private static void printAnswer(BufferedWriter bw) throws IOException {
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static int shiftLeft(int currentDirection) {
        return (currentDirection + 1) % 4;
    }
}
