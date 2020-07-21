package Collection_T2;

public class Main {
    public static void main  (String[] args) {
        String text = String.valueOf('i');
        MapAZ mapaz = new MapAZ();
        mapaz.search(text);
        System.out.println(mapaz.MapAZ().get((text)));
        System.out.println(mapaz.MapAZ().containsKey(text));
        System.out.println(String.valueOf("i"));
    }
}
