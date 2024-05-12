
public class Driver {
    public static void main(String[] args){
        //Test for BinaryHeap
        BinaryHeap myHeap = new BinaryHeap();
        myHeap.insert(4);
        myHeap.insert(5);
        myHeap.insert(6);
        myHeap.insert(7);
        myHeap.insert(14);
        myHeap.insert(74);
        myHeap.insert(89);
        myHeap.insert(-4);
        myHeap.insert(-5);
        myHeap.insert(-6);
        myHeap.insert(-7);
        myHeap.insert(-14);
        myHeap.insert(-74);
        myHeap.insert(-89);
        myHeap.insert(64);
        myHeap.insert(65);
        myHeap.insert(66);
        myHeap.insert(67);
        myHeap.insert(614);
        myHeap.insert(674);
        myHeap.insert(689);


        myHeap.display();
        myHeap.extractMax();
        myHeap.display();
        myHeap.extractMax();
        myHeap.display();
        myHeap.extractMax();
        myHeap.display();
    }
}
