package Collection_T2;

import java.util.HashMap;

public class Search {
    public void search(HashMap hashmap,String text) {

       if (hashmap.containsKey(String.valueOf(text))){
           int y = (int) hashmap.get(String.valueOf(text));
            hashmap.put(String.valueOf(text), y+1);
        }

    }
}
