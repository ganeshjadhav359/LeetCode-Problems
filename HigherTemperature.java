import java.util.Arrays;
import java.util.Stack;

public class HigherTemperature {
    public static void daysRemaining(int[] everyDayTemp){

        Stack<Integer> stack = new Stack<>();
        int[] output = new int[everyDayTemp.length];
        Arrays.fill(output,-1);
        for(int i=0;i< everyDayTemp.length;i++){

            while(!stack.isEmpty() && everyDayTemp[stack.peek()] < everyDayTemp[i]){
                int ind = stack.pop();
                output[ind]= i - ind;
            }
            stack.add(i);
        }
        for(int i=0;i< everyDayTemp.length;i++)
            System.out.print(output[i]+" ");
        System.out.println();

    }
    public static void main(String[] args) {
        // Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73}
        // Output: {1, 1, 4, 2, 1, 1, -1, -1}
        daysRemaining(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
