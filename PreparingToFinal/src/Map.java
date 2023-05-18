import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        java.util.Map<String, Integer> map = new HashMap<>();
        map.put("key1", 2);
        map.put("key2", 3);
        map.put("key3", 4);
        map.put("key4", 5);
        Integer key2 = map.get("key");

        map.remove("key1");
        // out keys
        for(String k : map.keySet()){
            System.out.println(k);
        }
        // out values
        for (Integer values : map.values()){
            System.out.println(values);
        }

        // check key
        System.out.println(map.containsKey("key2"));

        // check values
        System.out.println(map.containsValue(4));
    }
}