package week2;

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
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ2584 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final List<Integer> answers = new ArrayList<>();

    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br);

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 0 && !visited[y][x]) {
                    visited[y][x] = true;
                    answers.add(bfs(new Point(x, y)));
                }
            }
        }
        printAnswer(bw);
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int x = leftX; x < rightX; x++) {
                for (int y = leftY; y < rightY; y++) {
                    map[y][x] = 1;
                }
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

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextY][nextX]) {
                    continue;
                }

                if (map[nextY][nextX] == 0) {
                    visited[nextY][nextX] = true;
                    queue.offer(new Point(nextX, nextY));
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void printAnswer(BufferedWriter bw) throws IOException {
        bw.write(answers.size() + "\n");

        Collections.sort(answers);
        for (Integer answer : answers) {
            bw.write(answer + " ");
        }

        bw.flush();
        bw.close();
    }
}
