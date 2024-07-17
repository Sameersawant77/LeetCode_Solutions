//Given a string formula representing a chemical formula, return the count of each atom.
//
//The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
//
//One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
//
//For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
//Two formulas are concatenated together to produce another formula.
//
//For example, "H2O2He3Mg4" is also a formula.
//A formula placed in parentheses, and a count (optionally added) is also a formula.
//
//For example, "(H2O2)" and "(H2O2)3" are formulas.
//Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
//
//The test cases are generated so that all the values in the output fit in a 32-bit integer.

import java.util.*;

public class _726_chemical_formula {
    public String countOfAtoms(String formula) {
        ArrayDeque<Map<String,Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        for(int i=0;i<n;){
            if(formula.charAt(i)=='('){
                stack.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                Map<String,Integer> top = stack.pop();
                i++;
                int start = i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start<i ? Integer.parseInt(formula.substring(start,i)) : 1;
                for(String key:top.keySet()){
                    stack.peek().put(key,stack.peek().getOrDefault(key,0)+top.get(key)*multiplier);
                }
            }
            else{
                int start = i;
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start,i);
                start = i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int count = start<i ? Integer.parseInt(formula.substring(start,i)) : 1;
                stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
            }
        }
        Map<String,Integer> res = stack.pop();
        List<String> elements = new ArrayList<>(res.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for(String element: elements){
            sb.append(element);
            int count = res.get(element);
            if(count>1) sb.append(count);
        }
        return sb.toString();
    }
}
