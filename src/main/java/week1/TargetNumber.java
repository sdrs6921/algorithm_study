package week1;

public class TargetNumber {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int step, int current, int target) {
        if (numbers.length == step) {
            if (current == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, step + 1, current + numbers[step], target);
        dfs(numbers, step + 1, current - numbers[step], target);
    }
}
