/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newNode  = new Node(node.val);
        map.put(node, newNode);
        deepCopy(node, map);

        return newNode;
    }

    public void deepCopy(Node oldNode, Map<Node, Node> map) {
        if(oldNode == null) return;
        
        // List<Node> newNeighList = new ArrayList<>();
        for(Node oldNeigh : oldNode.neighbors) {
            if(map.containsKey(oldNeigh)) map.get(oldNode).neighbors.add(map.get(oldNeigh));
            else {
                Node newNeigh = new Node(oldNeigh.val);
                map.put(oldNeigh, newNeigh);
                map.get(oldNode).neighbors.add(newNeigh);
                deepCopy(oldNeigh, map);
            }
        }
    }
}