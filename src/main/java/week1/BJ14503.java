package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
    int row;
    int col;
    int direction;

    public Robot(int row, int col, int direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    public void shiftLeft() {
        direction = (direction + 3) % 4;
    }
}

public class BJ14503 {

    private static final int DIRTY = 0;
    private static final int WALL = 1;
    private static final int CLEAN = 2;

    private static final int[] LEFT_ROW = {0, -1, 0, 1};
    private static final int[] LEFT_COL = {-1, 0, 1, 0};
    private static final int[] BACK_ROW = {1, 0, -1, 0};
    private static final int[] BACK_COL = {0, -1, 0, 1};

    private static int answer = 0;
    private static int[][] rooms;
    private static int r, c;
    private static Robot robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        cleanRoom(robot);
        printAnswer();
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

    private static void cleanRoom(Robot robot) {
        if (rooms[robot.row][robot.col] == DIRTY) {
            rooms[robot.row][robot.col] = CLEAN;
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            if (rooms[robot.row + LEFT_ROW[robot.direction]][robot.col + LEFT_COL[robot.direction]] == DIRTY) {
                robot.row = robot.row + LEFT_ROW[robot.direction];
                robot.col = robot.col + LEFT_COL[robot.direction];
                robot.shiftLeft();
                cleanRoom(robot);
                return;
            }

            robot.shiftLeft();
    }

        if (rooms[robot.row + BACK_ROW[robot.direction]][robot.col + BACK_COL[robot.direction]] != WALL) {
            robot.row = robot.row + BACK_ROW[robot.direction];
            robot.col = robot.col + BACK_COL[robot.direction];
            cleanRoom(robot);
        }
    }

    private static void printAnswer() {
        System.out.println(answer);
    }
}
