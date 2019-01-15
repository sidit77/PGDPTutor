package kartoffel;

import java.util.ArrayList;
import java.util.List;

public class PinguGraph implements Graph {

    private List<Integer>[] adjalist;

    private Node[] nodes;

    private int count;

    public PinguGraph(int max){
        adjalist = new List[max];
        nodes = new Node[max];
        count = 0;
    }


    public int add(Node n){
        nodes[count] = n;
        adjalist[count] = new ArrayList<>();
        return count++;
    }

    public void add(int from, int to){
        adjalist[from].add(to);
    }


    @Override
    public Node getNode(int nodeIndex) {
        return nodes[nodeIndex];
    }

    @Override
    public int[] getEdges(int fromNode) {
        return adjalist[fromNode].stream().mapToInt(i -> i).toArray();
    }
}
