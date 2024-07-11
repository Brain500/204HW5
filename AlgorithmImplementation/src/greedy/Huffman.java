package greedy;

import java.util.*;

public class Huffman {

    class Node {
        int freq;
        char c;
        Node left, right;

        Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    class MyComparator implements Comparator<Node> {
        public int compare(Node x, Node y) {
            return x.freq - y.freq;
        }
    }

    public void huffman(char[] charArray, int[] charFreq) {
        int n = charArray.length;
        PriorityQueue<Node> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            Node hn = new Node(charArray[i], charFreq[i]);
            q.add(hn);
        }

        Node root = null;
        while (q.size() > 1) {
            Node x = q.peek();
            q.poll();
            Node y = q.peek();
            q.poll();

            Node f = new Node('-', x.freq + y.freq);
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root, "");
    }

    public void printCode(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "   |  " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
