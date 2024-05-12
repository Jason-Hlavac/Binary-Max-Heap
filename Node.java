// Class for Nodes
public class Node{
    private Node left;
    private Node right;
    private Node parent;
    private int num;

// Default Constructor
    public Node(int value){
        left = null;
        right = null;
        parent = null;
        num = value;
    }
// Getters and Setters
    public Node get_left(){
        return left;
    }
    public void set_left(Node newNode){
        left = newNode;
    }
    public Node get_right(){
        return right;
    }
    public void set_right(Node newNode){
        right = newNode;
    }
    public Node get_parent(){
        return parent;
    }
    public void set_parent(Node newNode){
        parent = newNode;
    }
    public int get_num(){
        return num;
    }
    public void set_num(int newNum){
        num = newNum;
    }
}