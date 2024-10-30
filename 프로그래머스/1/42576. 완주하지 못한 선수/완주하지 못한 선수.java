import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // completion 배열로 map 채우기
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // participant 배열을 순회하며 완주하지 못한 사람 찾기
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) - 1);
                if (map.get(name) == 0) {
                    map.remove(name);
                }
            } else {
                return name;
            }
        }
        return "";
    }
}
