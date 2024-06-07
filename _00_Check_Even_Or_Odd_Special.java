
//check number is even or odd without using % or /
public class _00_Check_Even_Or_Odd_Special {
    public static void main(String[] args){
        int number = 10;

        if ((number & 1) == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}
