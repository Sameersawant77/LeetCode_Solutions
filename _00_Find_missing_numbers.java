import java.util.HashSet;

public class _00_Find_missing_numbers {

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 2, 1, 0, 5};

        boolean found;

        for (int i = 0; i < arr1.length; i++) {
            found = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Missing number is: " + arr1[i]);
                break;
            }
        }
    }
}
