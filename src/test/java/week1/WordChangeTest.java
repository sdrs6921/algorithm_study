package week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week1.WordChange;

import static org.assertj.core.api.Assertions.assertThat;


class WordChangeTest {
    private WordChange wordChange = new WordChange();

    @Test
    @DisplayName("테스트 케이스 1")
    void solution_first_testcase() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int answer = wordChange.solution(begin, target, words);

        assertThat(answer).isEqualTo(4);
    }

    @Test
    @DisplayName("테스트 케이스 2")
    void solution_second_testcase() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        int answer = wordChange.solution(begin, target, words);

        assertThat(answer).isEqualTo(0);
    }
}
