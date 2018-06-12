package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {



    /**
     * 判断树是否为空
     * @return
     */
    public boolean isEmpty(){
        return  size == 0;
    }
    /**
     * 获取树的元素个数
     */

    public int getSize(){
        return size;
    }

    /**
     * 向树中添加元素
     * @param e
     */
    public void add(E e){
        Node node = new Node(e);
        root =  add(e,root);
    }
    /**
     * 中序遍历
     */
    public void middleOrder(){
        middleOrder(root);
    }
    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }
    /**
     * 后续遍历
     */
    public void postOrder(){
        postOrder(root);
    }
    /**
     * 树中是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return cotains(root,e);
    }

    /**
     *  获取树的深度
     * @return
     */
    public int getHeight(){
        return getHeight(root);
    }

    /**
     * 层序遍历
     */
    public void deepOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node current = q.remove();
            System.out.println("层序遍历："+current.toString());
            if(current.left!=null){
                q.add(current.left);
            }
            if(current.right!=null){
                q.add(current.right);
            }
        }
    }


    /**
     * 寻找树的最小元素
     */
    public E miniLeft(){
            return miniLeft(root).e;
    }

    private Node miniLeft(Node node){
            if(node.left !=null){
                return miniLeft(node.left);
            }
            return node;
    }

    /**
     * 寻找树的最大元素

     */

    public E maxNode(){
        return maxNode(root).e;
    }

    private Node maxNode(Node node){
        if(node.right == null)
            return node;
        else
            return maxNode(node.right);
    }


    /**
     * 删除最小的节点
     */
    public E removeMini(){
        E ret = miniLeft();
        RemoveMini(root);
        return ret;
    }
    private Node RemoveMini(Node node ){
      if(node.left==null){
          Node right = node.right;
          node.right = null;
          size -- ;
          return right;
      }
     node.left =   RemoveMini(node.left);
      return node;
    }


    public E removeMax(){
        E ret = maxNode();
        removeMax(root);
        return  ret;
    }

    public void remove(E e){
        remove(root,e);
    }

    private Node remove(Node node,E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else {
            //待删除的左节点为空
            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size -- ;
                return right;
            }
            //带删除的右节点为空
            if(node.right == null){
                Node left = node.left;
                node.left = null;
                size -- ;
                return left;
            }
            //待删除的左右节点都不为空
                Node sucessor = miniLeft(node.right);
                sucessor.right = RemoveMini(node.right);
                node.left = node.right =null;
                return sucessor;
        }
    }

    /**
     * 删除以Node为根的二分搜索树中的最小节点
     * 返回新树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node left = node.left ;
            node.left = null;
            size -- ;
            return left;
        }
        node.right = node.left;
        return node;
    }
    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.right);
        postOrder(node.left);
        System.out.println("后续遍历："+node.e);
    }
    private void preOrder(Node node ){
        if(node == null)
            return;
        System.out.println("前序："+node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    private boolean cotains(Node node,E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e)<0)
           return cotains(node.left,e);
        else {
            return cotains(node.right,e);
        }
    }

    public void middleOrder( Node root){
        if(root == null){
            return;
        }else {
            middleOrder(root.left);
            System.out.println("输出数据啊、");
            System.out.println(root.e+"");
            middleOrder(root.right);
        }
    }

    //向二分搜索树中添加元素
    private Node add(E e,Node root){
        if(root == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(root.e)>0){//当前的数据比root大
            root.right = add(e,root.right);
        }else {
            root.left = add(e,root.left);
        }
        return root;
    }

    private int getHeight(Node node){
        if(node == null)
            return 0;
        return Math.max(getHeight(node.right)+1,getHeight(node.left)+1);
    }

    public  void preOrderbyFei(){
        if(root == null)
            return;
        while (true){
        }
    }
    /**
     * Node 结点
     */
    private class Node{
        E e;
        Node left,right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size = 0;
    public BST(){
        root = null;
        size = 0;
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         