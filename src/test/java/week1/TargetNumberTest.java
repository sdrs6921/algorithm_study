package week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week1.TargetNumber;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberTest {
    private TargetNumber targetNumber = new TargetNumber();

    @Test
    @DisplayName("테스트 케이스 1")
    void solution() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int expect = targetNumber.solution(nums, target);

        assertThat(expect).isEqualTo(5);
    }
}
