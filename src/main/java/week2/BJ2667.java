package week2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ2667 {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] != 0 && !visited[y][x]) {
                    visited[y][x] = true;
                    int answer = bfs(new Point(x, y));
                    answers.add(answer);
                }
            }
        }
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String buffer = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = buffer.charAt(j) - '0';
            }
        }

        br.close();
    }

    private static int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        int answer = 0;

        queue.offer(point);
        answer++;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX]) {
                    continue;
                }

                if (map[nextY][nextX] != 0) {
                    queue.offer(new Point(nextX, nextY));
                    visited[nextY][nextX] = true;
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void printAnswer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answers.size() + "\n");

        Collections.sort(answers);

        for (Integer answer : answers) {
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}
