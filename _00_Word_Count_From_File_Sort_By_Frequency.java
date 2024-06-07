import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class _00_Word_Count_From_File_Sort_By_Frequency {

    public static void main(String[] args){

        String file_path = "path/to/your/file.txt";
        HashMap<String,Integer> wordCountFrequency = countWordFrequency(file_path);
        List<Map.Entry<String,Integer>> sortedList = sortByFrequeny(wordCountFrequency);

        for(Map.Entry<String,Integer> entry: sortedList){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static HashMap<String,Integer> countWordFrequency(String file_path){
        HashMap<String,Integer> wordCountFrequency = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file_path))) {
            String line;
            while(( line=bufferedReader.readLine())!=null){
                String[] words = line.split("\\W+");
                for(String word:words){
                    if(!word.isEmpty()){
                        wordCountFrequency.put(word,wordCountFrequency.getOrDefault(word,0)+1);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return wordCountFrequency;
    }

    public static List<Map.Entry<String,Integer>> sortByFrequeny(HashMap<String,Integer> wordCountFrequency){
        return wordCountFrequency.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).toList();
    }
}
