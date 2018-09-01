package ru.malltshik.tasks;

import java.util.Objects;

/**
 * This problem was asked by Google.
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * <p>
 * For example, given the following Node class
 *  class Node:
 *      def __init__(self, val, left=None, right=None):
 *          self.val = val
 *          self.left = left
 *          self.right = right
 *
 * The following test should pass:
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

// TODO it doesn't work yet
public class TreeTransferTask {

    private final static String TEMPLATE =  "(%s%s%s)";

    public static String serialize(Node node) {
        if(node == null) return "()";
        return String.format(TEMPLATE, node.name, serialize(node.left), serialize(node.right));
    }

    public static Node deserialize(String str) {
        // TODO implement this function
        return null;
    }

    public static void main(String[] args) {
        Node node = new Node("root",
                new Node("left",
                        new Node("left.left"),
                        null),
                new Node("right"));
        Objects.equals(deserialize(serialize(node)).left.left.name, "left.left");
    }

    static class Node {

        public String name;
        public Node left;
        public Node right;

        public Node(String name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        public Node(String name) {
            this.name = name;
        }
    }

}
