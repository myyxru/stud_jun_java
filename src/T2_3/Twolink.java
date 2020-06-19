package T2_3;



public class Twolink {
    int size;
    Node head;
    Node end;

    Twolink(String[] arr) {
        this.addall(arr);
    }

    private void addall(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (this.size == 0) {
                head = new Node(null, null, arr[i]);
            } else {
                Node element = this.end == null ? this.head : this.end;
                this.end = new Node(null, element, arr[i]);
                element.next = this.end;
            }
            this.size++;
        }
    }

    private class Node {
        private String value;
        private Node next;
        private Node preview;

        Node(Node next, Node preview, String value) {
            this.preview = preview;
            this.next = next;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPreview() {
            return preview;
        }

        public boolean type(Node node) {
            boolean type;
            if (node.getValue().contains("*") | node.getValue().contains("/") | node.getValue().contains("+") | node.getValue().contains("-")) {
                type = true;
            } else {
                type = false;
            }
            return type;
        }
    }

    public void sout(Twolink tl) {
        Node node = tl.head;
        for (int i = 0; i < tl.size; i++) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public void sout(Twolink tl, int index) {
        Node node = tl.head;
        for (int i = 0; i < tl.size; i++) {
            if (i + 1 == index) {
                System.out.println(node.getValue() + node.type(node));
            }
            node = node.getNext();
        }
    }

    public Node priority(Twolink tl) {
        Node node = tl.head.getNext();
        for (int i = 0; i < tl.size; i++) {
            if (node.getValue().contains("*")|node.getValue().contains("/")){
                break;
            }
            else {
                node = node.getNext();
            }
        }
        return node;
    }
}


