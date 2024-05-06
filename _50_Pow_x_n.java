// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long longN = n;
        if(longN < 0) longN = longN * -1;
        while(longN > 0){
            if(longN % 2 == 0){
                x *= x;
                longN /= 2;
            }else{
                ans *= x;
                longN -= 1;
            }
        }
        if(n<0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
}
