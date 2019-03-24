import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Parsing {
    static ArrayList<String> readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> array = new ArrayList<>();
        String s = br.readLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(", ");
        array.addAll(Arrays.asList(str));
        return array;
    }

    static int numOfUnique(ArrayList<String> input) {
        Set<String> subArray = new TreeSet<String>(input);
        return subArray.size();
    }

    static int numOfSingle(ArrayList<String> input) {
        ArrayList<String> subArray = new ArrayList<>();
        ArrayList<String> subArray2 = new ArrayList<>();
        for (String anInput : input) {
            if (subArray.contains(anInput)) {
                subArray2.add(anInput);
            }
            subArray.add(anInput);
        }
        for (String aSubArray2 : subArray2) {
            if (subArray.contains(aSubArray2)) {
                for (int j = 0; j < subArray.size(); j++) {
                    subArray.remove(aSubArray2);
                }
            }
        }
        return subArray.size();
    }

    static ArrayList<String> maxCount(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> subArray = new ArrayList<>(input);
        ArrayList<Integer> arrCount = new ArrayList<>();
        int max = 0;
        Map<Integer, String> map = new HashMap<>();

        for(int i=0; i<subArray.size();i++){
            arrCount.add(Collections.frequency(subArray, subArray.get(i)));
            map.put(arrCount.get(i), subArray.get(i));
        }
        for (int i =0; i<arrCount.size(); i++){
            max = Math.max(max,arrCount.get(i));
        }
        String a = map.get(max);
        output.add(a);
        output.add(String.valueOf(max));
        return output;
    }
}
