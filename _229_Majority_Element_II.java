import java.util.ArrayList;
import java.util.List;

public class _229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0, elm1 = 0, elm2 = 0;
        int target = nums.length/3;
        for(int num: nums){
            if(cnt1 == 0 && num != elm2){
                cnt1 = 1;
                elm1 = num;
            }
            else if(cnt2 == 0 && num != elm1){
                cnt2 = 1;
                elm2 = num;
            }
            else if(num == elm1) cnt1++;
            else if(num == elm2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for(int num: nums){
            if(elm1 == num) cnt1++;
            else if(elm2 == num) cnt2++;
        }
        if(cnt1 > target) result.add(elm1);
        if(cnt2 > target) result.add(elm2);
        return result;
    }
}
