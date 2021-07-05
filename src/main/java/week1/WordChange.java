package week1;

import java.util.LinkedList;
import java.util.Queue;

class Word {
    String word;
    int index;

    public Word(String word, int index) {
        this.word = word;
        this.index = index;
    }
}

public class WordChange {

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        int[] dist = new int[words.length + 1];
        Word currentWord = new Word(begin, words.length);

        queue.offer(new Word(begin, words.length));

        while (!queue.isEmpty() && !currentWord.word.equals(target)) {
            currentWord = queue.poll();
            System.out.println(currentWord.word);
            System.out.println();

            for (int i = 0; i < words.length; i++) {
                if (dist[i] != 0 || isNotOneWordDifferent(currentWord.word, words[i])) {
                    continue;
                }

                System.out.println(words[i]);
                queue.offer(new Word(words[i], i));
                dist[i] = dist[currentWord.index] + 1;
            }
        }

        if (currentWord.word.equals(target)) {
            return dist[currentWord.index];
        }

        return 0;
    }

    private boolean isNotOneWordDifferent(String word, String other) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != other.charAt(i)) {
                count++;
            }
        }

        return count != 1;
    }
}
