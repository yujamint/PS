import java.util.Stack;

class Stock {
    int price;
    int order;

    public Stock(int price, int order) {
        this.price = price;
        this.order = order;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        Stack<Stock> stack = new Stack<>();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int price = prices[i];

            if (!stack.isEmpty() && price >= stack.peek().price) {
                stack.push(new Stock(price, i));
                continue;
            }

            while (!stack.isEmpty() && price < stack.peek().price) {
                Stock stock = stack.pop();
                answer[stock.order] = i - stock.order;
            }
            stack.push(new Stock(price, i));
        }

        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.order] = len - stock.order - 1;
        }

        return answer;
    }
}