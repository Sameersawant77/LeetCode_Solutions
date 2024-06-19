//Given two integers a and b, return the sum of the two integers without using the operators + and -.

public class _371_sum_of_two_numbers {
    public int getSum(int a, int b) {
        int carryBit = 0;
        while(b!=0){
            carryBit = a & b;
            a = a ^ b;
            b = carryBit << 1; // shifting carry one space to left of generated
        }
        return a;
    }
}
