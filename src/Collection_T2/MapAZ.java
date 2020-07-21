package Collection_T2;

import java.util.HashMap;
import java.util.Map;

public class MapAZ {
    public HashMap MapAZ() {
        Map<String, Integer> mapaz = new HashMap<>();
        mapaz.put(String.valueOf('a'),0);
        mapaz.put(String.valueOf('b'),0);
        mapaz.put(String.valueOf('c'),0);
        mapaz.put(String.valueOf('d'),0);
        mapaz.put(String.valueOf('e'),0);
        mapaz.put(String.valueOf('f'),0);
        mapaz.put(String.valueOf('g'),0);
        mapaz.put(String.valueOf('h'),0);
        mapaz.put(String.valueOf('i'),0);
        mapaz.put(String.valueOf('j'),0);
        mapaz.put(String.valueOf('k'),0);
        mapaz.put(String.valueOf('l'),0);
        mapaz.put(String.valueOf('m'),0);
        mapaz.put(String.valueOf('n'),0);
        mapaz.put(String.valueOf('o'),0);
        mapaz.put(String.valueOf('p'),0);
        mapaz.put(String.valueOf('q'),0);
        mapaz.put(String.valueOf('r'),0);
        mapaz.put(String.valueOf('s'),0);
        mapaz.put(String.valueOf('t'),0);
        mapaz.put(String.valueOf('u'),0);
        mapaz.put(String.valueOf('v'),0);
        mapaz.put(String.valueOf('w'),0);
        mapaz.put(String.valueOf('x'),0);
        mapaz.put(String.valueOf('y'),0);
        mapaz.put(String.valueOf('z'),0);
        mapaz.put(String.valueOf('A'),0);
        mapaz.put(String.valueOf('B'),0);
        mapaz.put(String.valueOf('C'),0);
        mapaz.put(String.valueOf('D'),0);
        mapaz.put(String.valueOf('E'),0);
        mapaz.put(String.valueOf('F'),0);
        mapaz.put(String.valueOf('G'),0);
        mapaz.put(String.valueOf('H'),0);
        mapaz.put(String.valueOf('I'),0);
        mapaz.put(String.valueOf('J'),0);
        mapaz.put(String.valueOf('K'),0);
        mapaz.put(String.valueOf('L'),0);
        mapaz.put(String.valueOf('M'),0);
        mapaz.put(String.valueOf('N'),0);
        mapaz.put(String.valueOf('O'),0);
        mapaz.put(String.valueOf('P'),0);
        mapaz.put(String.valueOf('Q'),0);
        mapaz.put(String.valueOf('R'),0);
        mapaz.put(String.valueOf('S'),0);
        mapaz.put(String.valueOf('T'),0);
        mapaz.put(String.valueOf('U'),0);
        mapaz.put(String.valueOf('V'),0);
        mapaz.put(String.valueOf('W'),0);
        mapaz.put(String.valueOf('X'),0);
        mapaz.put(String.valueOf('Y'),0);
        mapaz.put(String.valueOf('Z'),0);
        return (HashMap) mapaz;
    }

    public void search(String text) {

        if (MapAZ().containsKey(String.valueOf(text))){
            int y = (int) MapAZ().get(String.valueOf(text));
            MapAZ().put(String.valueOf(text), y+1);
        }

    }
}
