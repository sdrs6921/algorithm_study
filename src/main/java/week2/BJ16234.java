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
    private static int sum = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printAnswer();
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

    private static void bfs() {
        boolean isMoved = false;

        for (int x = 0; x < N; x++) {
            for (int y  = 0; y < N; y++) {
                if (!visited[x][y]) {
                    List<Point> points = new ArrayList<>();
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                    points.add(new Point(x, y));
                    int sum = map[x][y];

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int i = 0; i < 4; i++) {
                            int nextX = cur.x + dx[i];
                            int nextY = cur.y + dy[i];

                            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
                                continue;
                            }

                            int difference = Math.abs(map[cur.x][cur.y] - map[nextX][nextY]);

                            if (L <= difference && difference <= R) {
                                queue.offer(new Point(nextX, nextY));
                                points.add(new Point(nextX, nextY));
                                visited[nextX][nextY] = true;
                                isMoved = true;
                                sum += map[nextX][nextY];
                            }
                        }

                    }

                    if (points.size() != 1) {
                        int average = sum / points.size();

                        for (Point point : points) {
                            map[point.x][point.y] = average;
                        }
                    }
                }
            }
        }

        if (isMoved) {
            answer++;
            visited = new boolean[N][N];
            bfs();
        }
    }

    private static void printAnswer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
