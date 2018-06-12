package linear.node;

public class RemoveElements {
    public static Node removeElements(Node head,int val){
        while (head==null&&head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        Node preNode = head;
        while (preNode.next!=null){
            if(preNode.next.val == val){
                preNode.next = preNode.next.next;
            }else {
                preNode = preNode.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
        int[] array = {1,2,6,3,4,5,6};
        Node node = new Node(array);
        System.out.println(node);
        removeElements(node,6);
        System.out.println(node);
    }
}
