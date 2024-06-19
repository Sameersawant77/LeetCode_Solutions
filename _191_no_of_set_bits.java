//Write a function that takes the binary representation of a positive integer and returns the number of
//set bits
// it has (also known as the Hamming weight).

public class _191_no_of_set_bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n>0){
            n = n & n-1;
            count ++;
        }
        return count;
    }
}
