//You are given two integers red and blue representing the count of red and blue colored balls. You have to arrange these balls to form a triangle such that the 1st row will have 1 ball, the 2nd row will have 2 balls, the 3rd row will have 3 balls, and so on.
//
//All the balls in a particular row should be the same color, and adjacent rows should have different colors.
//
//Return the maximum height of the triangle that can be achieved.

public class _3200_max_heigth_of_triangle {
    public int maxHeightOfTriangle(int red, int blue) {
        int temp1 = length(red,blue);
        int temp2 = length(blue,red);
        return Math.max(temp1,temp2);
    }
    private static int length(int a,int b){
        int flag = 0, row = 1, length = 0;
        while(a > 0 || b > 0){
            if(flag==0){
                if(a>=row){
                    a = a - row;
                }else{
                    break;
                }
            }else{
                if(b>=row){
                    b = b - row;
                }else{
                    break;
                }
            }
            length++;
            row++;
            flag = flag ^ 1;
        }
        return length;
    }
}

// here we check for both cases starting from red and blue instead of starting with the greater element.
// Suppose we have:
//red = 5
//blue = 4
//If we start with red (the color with more balls), we get:
//Row 1: R (1 red ball)
//Row 2: BB (2 blue balls)
//Row 3: RRR (3 red balls)
//Total height: 3
//But if we start with blue, we get:
//Row 1: B (1 blue ball)
//Row 2: RR (2 red balls)
//Row 3: BBB (3 blue balls)
//Row 4: R (1 red ball)
//Total height: 4
//In this case, starting with the color that has fewer balls actually results in a taller triangle.
