package T2_3;



public class Twolink  {
    int size;
    Node head;
    Node end;

        Twolink (String [] arr){
                this.addall(arr);
        }
     private void addall (String [] arr){
         for (int i = 0; i <arr.length ; i++) {
             if (this.size == 0) {
                 head = new Node(null , null , arr[i]);
             }
             else {
                 Node element = this.end == null ? this.head : this.end;
                 this.end = new Node (null , element , arr[i]);
                 element.next = this.end;
             }
             this.size++;
         }
     }

private class Node{
    private String value;
    private Node next;
    private Node preview;

    Node(Node next, Node preview, String value) {
        this.preview = preview;
        this.next = next;
        this.value = value;
    }
}
}