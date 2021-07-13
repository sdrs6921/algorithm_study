package week2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16234 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int N, L, R;
    private static int map[][];
    private static boolean visited[][];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        movePopulation();
        printAnswer();
    }

    private static void movePopulation() {
        boolean flag = false;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (bfs(new Point(x, y))) {
                    flag = true;
                }
            }
        }

        if (flag) {
            answer++;
            visited = new boolean[N][N];
            movePopulation();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static boolean bfs(Point point) {
        int sum = 0;
        List<Point> points = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            points.add(new Point(cur.x, cur.y));
            sum += map[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
                    continue;
                }

                int difference = Math.abs(map[cur.x][cur.y] - map[nextX][nextY]);

                if (difference >= L && difference <= R) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }

        if (points.size() != 1) {
            int average = sum / points.size();
            for (Point p : points) {
                map[p.x][p.y] = average;
            }
            return true;
        }
        return false;
    }

    private static void printAnswer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
