// package Lab9;
interface Function {
    int evaluate(int value);
}

class Half implements Function {
    @Override
    public int evaluate(int value) {
        return value / 2;
    }
}
public class Q5 {
    public static int[] processArray(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        Function halfFunction = new Half();

        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = halfFunction.evaluate(inputArray[i]);
        }

        return outputArray;
    }
    public static void main(String[] args) {
        int[] input = {10, 20, 30, 40, 50};
        int[] output = processArray(input);

        System.out.print("Output array: ");
        for (int value : output) {
            System.out.print(value + " ");
        }
    }
}
