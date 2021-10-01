package DataStructure;

public class LinkedList<T> {

    public Node<T> head = null;

    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null)
            head = new Node<>(data);
        else {
            Node<T> node = this.head;
            while (node.next!=null)
                node = node.next;

            node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if (head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null)
            addNode(data);
        else {
            Node<T> node = new Node<>(data);
            node.next = searchedNode.next;
            searchedNode.next = node;
        }
    }

    public boolean delNode(T isData){
        if (this.head != null){
            Node<T> node = this.head;
            if (node.data == isData){
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null){
                    if (node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    } else {
                        node = node.next;
                    }
                }
            }
        }
        return false;
    }

    public Node<T> search(T data){
        if (this.head != null) {
            Node<T> node = this.head;
            while (node.data != null){
                if (node.data == data){
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public static void main(String args[]){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);

        linkedList.addNodeInside(5,1);
        linkedList.delNode(2);
        linkedList.printAll();
    }
}