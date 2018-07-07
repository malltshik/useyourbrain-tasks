package ru.malltshik.tasks;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/**
 * This task should implement kind of file system directory tree
 */
public class FSTask {

    private static String[] p1 = new String[]{"home", "charley", "tasks.txt"};
    private static String[] p2 = new String[]{"home", "john", "FSTask.java"};
    private static String[] p3 = new String[]{"home", "john", "Node.java"};
    private static String[] p4 = new String[]{"usr", "local", "bin", "my.conf"};
    private static String[] p5 = new String[]{"usr", "local", "share", "apache", "vhost.conf"};
    private static String[] p6 = new String[]{"usr", "local"};
    private static String[] p7 = new String[]{"tmp", "trash", "remove_me.txt"};

    public static void main(String[] args) {
        FileSystem.tree(asList(p1, p2, p3, p4, p5, p6, p7)).print();
    }

}

class FileSystem {

    static class Node {

        String name;
        List<Node> children = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }

        public String toString() {
            String childrenStrings = children.stream().map(Node::toString).collect(joining(""));
            return String.format("%s \n \t %s", name, childrenStrings);
        }

        void print() {
            print("", true);
        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                children.get(children.size() - 1)
                        .print(prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }


    static Node tree(List<String[]> paths) {
        Node root = new Node("/");
        root.children.addAll(tree(paths, 0));
        return root;
    }

    private static List<Node> tree(List<String[]> paths, int level) {
        Map<String, Node> namesToNode = new HashMap<>();

        paths.forEach(path -> {
            String name = path[level];
            if (!namesToNode.containsKey(name)) {
                Node node = new Node(name);
                if (level < path.length - 1) {
                    List<String[]> filteredPaths = paths.stream()
                            .filter(x -> level < x.length - 1)
                            .filter(x -> Objects.equals(x[level], name))
                            .collect(toList());
                    node.children.addAll(tree(filteredPaths, level + 1));
                }
                namesToNode.put(name, node);
            }
        });
        return new ArrayList<>(namesToNode.values());
    }
}
