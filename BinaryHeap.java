//Imports
import static java.lang.Math.*;

// Class for the Binary Heap
public class BinaryHeap {
    private Node head;
    private int size;

//Default Constructor
    public BinaryHeap(){
        head = null;
        size = 0;
    }

//Heap Operations
public void insert(int newNum){
    //Case for if head does not exist
    if(head == null){
        set_head(new Node(newNum));
    }else{
        //Find next slot and make new node
        Node curr = get_next_slot(size, get_head());
        Node newNode = new Node(newNum);
        //Try to place new node on left then right
        if(curr.get_left() == null){
            curr.set_left(newNode);
        }else{
            curr.set_right(newNode);
        }
        //Update head and maintain order
        newNode.set_parent(curr);
        percolateUp(newNode);
    }
    //Increment Size
    size++;
}

public void extractMax(){
    //Use get next on size-1 to find previous
    Node last = get_next_slot(size-1, head);
    //If both nodes are null we have the target node already
    if(last.get_left() == null && last.get_right() == null){
        swap(head, last);
        //Check which if the current node is right or left for the parent and sever the tie
        if(last.get_parent().get_right()!= null){
            last.get_parent().set_right(null);
            last.set_parent(null);
        }else{
            last.get_parent().set_left(null);
            last.set_parent(null);
        }
    //If statement checks left and right in opposite order as insert
    }else if(last.get_right() != null){
        //Cut ties to the right node
        swap(head, last.get_right());
        last.get_right().set_parent(null);
        last.set_right(null);

    }else{
        //Cut ties to the left node
        swap(head, last.get_left());
        last.get_left().set_parent(null);
        last.set_left(null);
    }
    //Call percolate down and decrease size
    percolateDown(head);
    size--;
}



public void display(){
    System.out.println("-----------------------------");
    display_recursive(head, 0);
    System.out.println("-----------------------------");
}

// display recursive helper
private void display_recursive(Node stroot, int level){
    if(stroot != null){
        display_recursive(stroot.get_right(), level+1);
        for(int i=0; i < level; i++){
            System.out.print("     ");
        }
        System.out.println(stroot.get_num());
        display_recursive(stroot.get_left(), level+1);
    }
}

//Helper Functions
public Node get_next_slot(int tSize, Node curr){
    //Get the Height of the heap
    double height = floor(Math.log(tSize)/ Math.log(2.0));

    //Base case for if a Node has an open spot or we only have 2 height
    if(curr.get_left() == null || curr.get_right() == null){
        return curr;
    }

    //Geometric Sequence for the number of elements NOT on the bottom layer
    int notBottomCount = 0;
    //Height -1 so you dont include bottom layer. Start i at 0 because first layer is 2^0, second is 2^1, etc.
    for(var i = 0; i <= height-1; i++){
        notBottomCount+= Math.pow(2, i);
    }
    //Calculate how many nodes are on the bottom level
    int bottomCount = tSize - notBottomCount;
    
    //Max number on Bottom is 2^height. If less than half of that is filled go left. If more than half is filled go right. If all is filled go left.
    //Increase depth by 1 and get the size for the half of the heap that you still have. Use floor round because the Node that you are on will always appear to have one on the layer.
    if(bottomCount < (Math.pow(2, height))/2 || bottomCount == (Math.pow(2,(int) height))){
        return(get_next_slot((int) (floor(notBottomCount/2)+ bottomCount% (Math.pow(2,(int) height)/2)), curr.get_left()));
    }else{
        return(get_next_slot((int) (floor(notBottomCount/2)+ bottomCount% (Math.pow(2,(int) height)/2)), curr.get_right()));
    }
}


public void percolateUp(Node curr){
    //If child is greater than parent, swap them
    if(curr.get_parent() != null && curr.get_num() > curr.get_parent().get_num()){
        swap(curr, curr.get_parent());
        percolateUp(curr.get_parent());
    }
}

public void percolateDown(Node curr){
    //Define a node to hold the node we are comparing to
    Node compNode = null;
    //If one of the nodes is null
    if(curr.get_left()==null || curr.get_right() == null){
        //Check only left because left cannot be null if right is not null
        if(curr.get_left() != null){
            compNode = curr.get_left();
        }
    //Both nodes are not null
    }else{
        //Take greater node
        if(curr.get_left().get_num()> curr.get_right().get_num()){
            compNode = curr.get_left();
        }else{
            compNode = curr.get_right();
        }
    }
    //If we found a new node that is greater than current swap and recursive call on the new node
    if(compNode != null && compNode.get_num()> curr.get_num()){
        swap(curr, compNode);
        percolateDown(compNode);
    }
}

public void swap(Node n1, Node n2){
    //Store n1 value in temp then swap
    int temp = n1.get_num();
    n1.set_num(n2.get_num());
    n2.set_num(temp);
}

// Getters and Setters
    public Node get_head(){
        return head;  
    }

    public void set_head(Node newNode){
        head = newNode;
    }

}