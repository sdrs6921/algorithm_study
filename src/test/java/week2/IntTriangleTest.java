package week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntTriangleTest {
    private final IntTriangle intTriangle = new IntTriangle();

    @Test
    @DisplayName("test case 1")
    void solution() {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int answer = intTriangle.solution(triangle);

        assertThat(answer).isEqualTo(30);
    }
}
