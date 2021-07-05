import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("덧")
    void solution() {
        Main main = new Main();



        assertEquals(main.solution(1, 2), 4);
    }
}