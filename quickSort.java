import java.util.*;

public class quickSort {
    public static int partition(List<Integer> arr, int low, int high){
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while(i<j){
            while(arr.get(i)<=pivot && i<=high-1){
                i++;
            }
            while (arr.get(j)>pivot && j>=low +1){
                j--;
            }
            if(i<j){
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }
    public static void qs (List<Integer> arr, int low, int high){
        if(low<high){
            int pivot = partition(arr,low,high);
            qs(arr,low,pivot-1);
            qs(arr,pivot+1,high);
        }
    }
    public static List<Integer> quickSorting(List<Integer> arr){
        qs( arr, 0, arr.size()-1);
        return arr;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{4, 2, 7, 5, 8, 4, 1}));
        List<Integer> sortedList = new ArrayList<>();
        int n = list.size();
        sortedList = quickSorting(list);
        for(Integer integer : sortedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
