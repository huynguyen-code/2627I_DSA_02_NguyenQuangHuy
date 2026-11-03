class ArrayTreeNode {
    int data, firstChild = -1, nextSibling = -1;

    ArrayTreeNode(int data) {
        this.data = data;
    }
}

public class W9_25020183 {
    private ArrayTreeNode[] nodes;
    private int size;

    public W9_25020183(int capacity) {
        nodes = new ArrayTreeNode[capacity];
    }

    public int addNode(int data) {
        if (size == nodes.length) return -1;
        nodes[size] = new ArrayTreeNode(data);
        return size++;
    }

    public boolean addChild(int parent, int child) {
        if (parent < 0 || parent >= size || child <= 0 || child >= size || parent == child) return false;
        if (nodes[parent].firstChild == -1) {
            nodes[parent].firstChild = child;
        } else {
            int cur = nodes[parent].firstChild;
            while (nodes[cur].nextSibling != -1) cur = nodes[cur].nextSibling;
            nodes[cur].nextSibling = child;
        }
        return true;
    }

    public int getFirstChild(int i) {
        return (i >= 0 && i < size) ? nodes[i].firstChild : -1;
    }

    public int getNextSibling(int i) {
        return (i >= 0 && i < size) ? nodes[i].nextSibling : -1;
    }

    public int findParent(int target) {
        for (int i = 0; i < size; i++)
            for (int c = nodes[i].firstChild; c != -1; c = nodes[c].nextSibling)
                if (c == target) return i;
        return -1;
    }

    public void preOrder(int i) {
        System.out.print(nodes[i].data + " ");
        for (int c = nodes[i].firstChild; c != -1; c = nodes[c].nextSibling) preOrder(c);
    }

    public static void main(String[] args) {
        W9_25020183 t = new W9_25020183(10);
        for (int v = 1; v <= 6; v++) t.addNode(v);

        t.addChild(0, 1);
        t.addChild(0, 2);
        t.addChild(0, 3);
        t.addChild(3, 4);
        t.addChild(3, 5);

        System.out.print("Preorder: ");
        t.preOrder(0);
        System.out.println();
        System.out.println("Con truong cua chi so 0: " + t.getFirstChild(0));
        System.out.println("Em lien ke cua chi so 1: " + t.getNextSibling(1));
        System.out.println("Bo cua chi so 5: " + t.findParent(5));
    }
}