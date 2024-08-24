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
        HashMap<Node, Node> map = new HashMap<>();

        return deepCopy(node, map);
    }

    public static Node deepCopy(Node oldNode, HashMap<Node, Node> map) {
        if(oldNode == null) return oldNode;
        if(map.containsKey(oldNode)) {
            return map.get(oldNode);
        }

        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);

        if(oldNode.neighbors != null) {
            for(Node n : oldNode.neighbors) {
                newNode.neighbors.add(deepCopy(n, map));
            }
        }
        return newNode;
    }
}