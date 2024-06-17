//A magician has various spells.
//
//You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.
//
//It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.
//
//Each spell can be cast only once.
//
//Return the maximum possible total damage that a magician can cast.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _3186_Maximum_Damage_By_Spell {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Long> damageFreqMap = new HashMap<>();
        for(int i=0;i<power.length;i++){
            damageFreqMap.put(power[i],damageFreqMap.getOrDefault(power[i],0L)+1);
        }

        ArrayList<Integer> UniqueDamageList = new ArrayList<>(damageFreqMap.keySet());
        Collections.sort(UniqueDamageList);
        int totalUniqueDamages = UniqueDamageList.size();
        long[] maxDamageDP = new long[totalUniqueDamages];

        maxDamageDP[0] = UniqueDamageList.get(0) * damageFreqMap.get(UniqueDamageList.get(0));

        for(int i=1;i<totalUniqueDamages;i++){
            int currentDamage = UniqueDamageList.get(i);
            long currentDamageValue = currentDamage * damageFreqMap.get(currentDamage);
            maxDamageDP[i] = maxDamageDP[i - 1];
            int prevIndex = i-1;
            while(prevIndex>=0 &&
                    (
                            UniqueDamageList.get(prevIndex) == currentDamage + 1 ||
                                    UniqueDamageList.get(prevIndex) == currentDamage - 1 ||
                                    UniqueDamageList.get(prevIndex) == currentDamage + 2 ||
                                    UniqueDamageList.get(prevIndex) == currentDamage - 2
                    )
            ){
                prevIndex--;
            }

            if(prevIndex>=0){
                maxDamageDP[i] = Math.max(maxDamageDP[i],maxDamageDP[prevIndex]+currentDamageValue);
            }else{
                maxDamageDP[i] = Math.max(maxDamageDP[i],currentDamageValue);
            }
        }
        return maxDamageDP[totalUniqueDamages-1];
    }
}
