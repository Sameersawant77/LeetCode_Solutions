//You are given a string str containing two fractions a/b and c/d, compare them and return the greater. If they are equal, then return "equal".
//
//Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )).
//
//Examples
//
//Input: str = "5/6, 11/45"
//Output: 5/6
//Explanation: 5/6=0.8333 and 11/45=0.2444, So 5/6 is greater fraction.


public class _00_Compare_two_string_fractions {
    public String compareFrac(String str) {
        // Code here
        int[] frac = new int[4];
        int index = 0, num = 0;

        for(char c: str.toCharArray()){
            if(c >= '0' && c <= '9'){
                num = 10 * num + (c-'0');
            }
            if(c == '/' || c == ','){
                frac[index++] = num;
                num = 0;
            }
        }
        frac[index] = num;

        String fractionString1 = frac[0] + "/" + frac[1];
        String fractionString2 = frac[2] + "/" + frac[3];

        int gcd1 = gcd(frac[0],frac[1]);
        int gcd2 = gcd(frac[2],frac[3]);

        frac[0] /= gcd1;
        frac[1] /= gcd1;
        frac[2] /= gcd2;
        frac[3] /= gcd2;

        long multiplication1 = (long) frac[0] * frac[3];
        long multiplication2 = (long) frac[1] * frac[2];

        if(multiplication1 > multiplication2) return fractionString1;
        else if(multiplication2 > multiplication1) return fractionString2;
        else return "equal";
    }

    private static int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b) a = a % b;
            else b = b % a;
        }
        if(a==0) return b;
        else return a;
    }
}
