//There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
//
//The rules of the game are as follows:
//
//Start at the 1st friend.
//Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
//The last friend you counted leaves the circle and loses the game.
//If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
//Else, the last friend in the circle wins the game.
//Given the number of friends, n, and an integer k, return the winner of the game.

public class _1823_josephus_problem {
    public int findTheWinner(int n, int k) {
        if(n==1) return 1;
        return (findTheWinner(n-1,k)+k-1)%n+1;
    }
}
//Let's explain the solution step by step:
//
//Base case: if(n==1) return 1;
//
//If there's only one friend left, that friend is the winner.
//
//
//Recursive case: return (findTheWinner(n-1,k)+k-1)%n+1;
//
//This is where the magic happens. Let's break it down further:
//a. findTheWinner(n-1,k) solves the problem for n-1 friends
//b. +k-1 adjusts the position based on the current elimination
//c. %n ensures the result wraps around the circle
//d. +1 converts the 0-based index to 1-based index
//
//
//
//Now, let's walk through an example to understand how this works:
//Example: n = 5, k = 2
//
//First call: findTheWinner(5, 2)
//
//It will recursively call findTheWinner(4, 2)
//
//
//Second call: findTheWinner(4, 2)
//
//It will recursively call findTheWinner(3, 2)
//
//
//Third call: findTheWinner(3, 2)
//
//It will recursively call findTheWinner(2, 2)
//
//
//Fourth call: findTheWinner(2, 2)
//
//It will recursively call findTheWinner(1, 2)
//
//
//Fifth call: findTheWinner(1, 2)
//
//Base case is reached, returns 1
//
//
//
//Now, let's go back up the recursion stack:
//
//Fourth call: returns (1 + 2 - 1) % 2 + 1 = 2
//Third call: returns (2 + 2 - 1) % 3 + 1 = 3
//Second call: returns (3 + 2 - 1) % 4 + 1 = 4
//First call: returns (4 + 2 - 1) % 5 + 1 = 3
//
//So, the final answer is 3, meaning the 3rd friend wins the game.