package linear.node;

public class Node {
    int val;
    Node  next;
    public Node(int val){
        this.val = val;
    }

    public Node(int[] arry){
      if(arry == null||arry.length == 0)
          throw new IllegalArgumentException("数组不合法");
       this.val = arry[0];
       Node current = this;
        for(int i = 1;i<arry.length;i++){
           current.next =  new Node(arry[i]);
           current = current.next;
           System.out.println(arry[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("node:");
        Node current = this;
        while (current!=null){
            builder.append(current.val);
            builder.append(">");
            current = current.next;
        }
        return builder.toString();
    }
}

