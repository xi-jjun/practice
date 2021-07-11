class Solution2 {
    public static int[] addArr(int n, int arr[], int element) {
        int i;
        int newarr[] = new int[n + 1];

        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = element;

        return newarr;
    }

    public static int[] removeArr(int n, int arr[]) {
        int newarr[] = new int[n - 1];
        int i;

        for (i = 0; i < n - 1; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int[] recursionF(int[] answer, int money, int index) {
        int debt;
        index -= 1;

        if(answer[index] + money > 0) {
            answer[index] += money;
        } else if(answer[index] + money == 0) {
            answer = removeArr(answer.length, answer);
        } else if(answer[index] + money < 0) {
            debt = answer[index] + money;
            answer = removeArr(answer.length, answer);
            return recursionF(answer, debt, answer.length);                    
        }
        return answer;
    }

    public static int[] solution2(int[] deposit) {
        int[] answer = {};

        for(int money : deposit) {
            if(money >= 0)
                answer = addArr(answer.length, answer, money); // add element in answer array
            else
                answer = recursionF(answer, money, answer.length);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer;
        int[] deposit = {500, 1000, -300, 200, -1000};
        answer = solution2(deposit);

        for(int i : answer)
            System.out.print(i + " ");
    }
}
