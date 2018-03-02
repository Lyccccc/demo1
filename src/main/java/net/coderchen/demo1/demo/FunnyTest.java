package net.coderchen.demo1.demo;

import org.apache.logging.log4j.core.pattern.MaxLengthConverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liuyuchen on 2018/03/02.
 */
public class FunnyTest {
    private static final String[] WORDS = {"A", "B", "C", "D"};
    private static Map<String,String> map2 = new HashMap<>();
    private static Map<String,Integer> map3 = new HashMap<>();
    private static Map<String,Integer> map9 = new HashMap<>();
    private static Map<String,Integer> map10 = new HashMap<>();

    static{
        map2.put("A", "C");
        map2.put("B", "D");
        map2.put("C", "A");
        map2.put("D", "B");

        map3.put("A", 3);
        map3.put("B", 6);
        map3.put("C", 2);
        map3.put("D", 4);

        map9.put("A", 6);
        map9.put("B", 10);
        map9.put("C", 2);
        map9.put("D", 9);

        map10.put("A", 3);
        map10.put("B", 2);
        map10.put("C", 4);
        map10.put("D", 1);
    }

    /**
     * 答案下标数组
     */
    private static int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        int time = 0;
        //下标数组最后一个不为3的数 +1
        for(arr[0] = 0 ; arr[0] < 4 ; arr[0]++){
            for(arr[1] = 0 ; arr[1] < 4 ; arr[1]++){
                for(arr[2] = 0 ; arr[2] < 4 ; arr[2]++){
                    for(arr[3] = 0 ; arr[3] < 4 ; arr[3]++){
                        for(arr[4] = 0 ; arr[4] < 4 ; arr[4]++){
                            for(arr[5] = 0 ; arr[5] < 4 ; arr[5]++){
                                for(arr[6] = 0 ; arr[6] < 4 ; arr[6]++){
                                    for(arr[7] = 0 ; arr[7] < 4 ; arr[7]++){
                                        for(arr[8] = 0 ; arr[8] < 4 ; arr[8]++){
                                            for(arr[9] = 0 ; arr[9] < 4 ; arr[9]++){
                                                time++;
                                                String[] answer = new String[] {WORDS[arr[0]], WORDS[arr[1]], WORDS[arr[2]], WORDS[arr[3]], WORDS[arr[4]], WORDS[arr[5]]
                                                        , WORDS[arr[6]], WORDS[arr[7]], WORDS[arr[8]], WORDS[arr[9]]};
                                                String str = WORDS[arr[0]]+ WORDS[arr[1]]+ WORDS[arr[2]]+ WORDS[arr[3]]+ WORDS[arr[4]]+ WORDS[arr[5]]
                                                        + WORDS[arr[6]]+ WORDS[arr[7]]+ WORDS[arr[8]]+ WORDS[arr[9]];
                                                System.out.println(str);
                                                boolean result = checkAnswer(answer);
                                                if(result){
                                                    System.out.println("第" + time + "次尝试");
                                                    System.out.println("answer is ：" + str);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean checkAnswer(String[] arr){
        //第一题不用check
        //第二题
        if(!checkQuestion2(arr)){
            return false;
        }
        //第三题
        if(!checkQuestion3(arr)){
            return false;
        }
        //第四题
        if(!checkQuestion4(arr)){
            return false;
        }
        //第五题
        if(!checkQuestion5(arr)){
            return false;
        }
        //第六题
        if(!checkQuestion6(arr)){
            return false;
        }
        //第七题
        if(!checkQuestion7(arr)){
            return false;
        }
        //第八题
        if(!checkQuestion8(arr)){
            return false;
        }
        //第九题
        if(!checkQuestion9(arr)){
            return false;
        }
        //第十题
        if(!checkQuestion10(arr)){
            return false;
        }
        return true;
    }

    private static boolean checkQuestion2(String[] arr){
        if(!arr[4].equals(map2.get(arr[1]))){
            return false;
        }
        return true;
    }

    private static boolean checkQuestion3(String[] arr){
        if("A".equals(arr[2])){
            if(arr[map3.get(arr[2])].equals(arr[map3.get("B")]) || arr[map3.get(arr[2])].equals(arr[map3.get("C")])
                    || arr[map3.get(arr[2])].equals(arr[map3.get("D")])){
                return false;
            }
        }else if("B".equals(arr[2])){
            if(arr[map3.get(arr[2])].equals(arr[map3.get("A")]) || arr[map3.get(arr[2])].equals(arr[map3.get("C")])
                    || arr[map3.get(arr[2])].equals(arr[map3.get("D")])){
                return false;
            }
        }else if("C".equals(arr[2])){
            if(arr[map3.get(arr[2])].equals(arr[map3.get("A")]) || arr[map3.get(arr[2])].equals(arr[map3.get("B")])
                    || arr[map3.get(arr[2])].equals(arr[map3.get("D")])){
                return false;
            }
        }else if("D".equals(arr[2])){
            if(arr[map3.get(arr[2])].equals(arr[map3.get("A")]) || arr[map3.get(arr[2])].equals(arr[map3.get("B")])
                    || arr[map3.get(arr[2])].equals(arr[map3.get("C")])){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion4(String[] arr){
        //1,5
        //2,7
        //1,9
        //6,10
        if("A".equals(arr[3])){
            if(!arr[0].equals(arr[4])){
                return false;
            }
        }else if("B".equals(arr[3])){
            if(!arr[1].equals(arr[6])){
                return false;
            }
        }else if("C".equals(arr[3])){
            if(!arr[0].equals(arr[8])){
                return false;
            }
        }else if("D".equals(arr[3])){
            if(!arr[5].equals(arr[9])){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion5(String[] arr){
        //8,4,9,7
        if("A".equals(arr[4])){
            if(!arr[7].equals(arr[4])){
                return false;
            }
        }else if("B".equals(arr[4])){
            if(!arr[3].equals(arr[4])){
                return false;
            }
        }else if("C".equals(arr[4])){
            if(!arr[8].equals(arr[4])){
                return false;
            }
        }else if("D".equals(arr[4])){
            if(!arr[6].equals(arr[4])){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion6(String[] arr){
        //2,4
        //1,6
        //3,10
        //5,9
        if("A".equals(arr[5])){
            if(!arr[7].equals(arr[1]) || !arr[7].equals(arr[3])){
                return false;
            }
        }else if("B".equals(arr[5])){
            if(!arr[7].equals(arr[0]) || !arr[7].equals(arr[5])){
                return false;
            }
        }else if("C".equals(arr[5])){
            if(!arr[7].equals(arr[2]) || !arr[7].equals(arr[9])){
                return false;
            }
        }else if("D".equals(arr[5])){
            if(!arr[7].equals(arr[4]) || !arr[7].equals(arr[8])){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion7(String[] arr){
        int[] count = new int[]{0,0,0,0};
        for (String s : arr) {
            if("A".equals(s)){
                count[0]++;
            }else if("B".equals(s)){
                count[1]++;
            }else if("C".equals(s)){
                count[2]++;
            }else if("D".equals(s)){
                count[3]++;
            }
        }
        int minValue = count[0];
        int position = 0;
        for (int i = 1; i < count.length; i++) {
            if(minValue > count[i]){
                minValue = count[i];
                position = i;
            }
        }
        //C,B,A,D
        if("A".equals(arr[6])){
            if(position != 2){
                return false;
            }
        }else if("B".equals(arr[6])){
            if(position != 1){
                return false;
            }
        }else if("C".equals(arr[6])){
            if(position != 0){
                return false;
            }
        }else if("D".equals(arr[6])){
            if(position != 3){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion8(String[] arr){
        //7,5,2,10
        if("A".equals(arr[0])){
            if("C".equals(arr[6]) || "D".equals(arr[6])){
                return false;
            }
        }else if("B".equals(arr[0])){
            if("D".equals(arr[4])){
                return false;
            }
        }else if("C".equals(arr[0])){
            if("A".equals(arr[1])){
                return false;
            }
        }else if("D".equals(arr[0])){
            if("A".equals(arr[9]) || "B".equals(arr[9])){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion9(String[] arr){
        boolean first;
        if(arr[0].equals(arr[5])){
            first = true;
        }else{
            first = false;
        }
        //X,5
        //6,10,2,9
        boolean second = arr[map9.get(arr[8]) - 1].equals(arr[4]);
        if(first){
            if(second){
                return false;
            }
        }else{
            if(!second){
                return false;
            }
        }
        return true;
    }

    private static boolean checkQuestion10(String[] arr){
        int[] count = new int[]{0,0,0,0};
        for (String s : arr) {
            if("A".equals(s)){
                count[0]++;
            }else if("B".equals(s)){
                count[1]++;
            }else if("C".equals(s)){
                count[2]++;
            }else if("D".equals(s)){
                count[3]++;
            }
        }
        int minValue = count[0];
        int maxValue = count[0];
        for (int i = 1; i < count.length; i++) {
            if(minValue > count[i]){
                minValue = count[i];
            }
            if(maxValue < count[i]){
                maxValue = count[i];
            }
        }
        int mul = maxValue - minValue;
        //3,2,4,1
        if(mul != map10.get(arr[9])){
            return false;
        }
        return true;
    }
}
