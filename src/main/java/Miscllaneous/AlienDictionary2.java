package Miscllaneous;

import java.util.*;

public class AlienDictionary2 {

    // https://leetcode.com/problems/verifying-an-alien-dictionary/
    // https://medium.com/@dimko1/alien-dictionary-6cf2da24bf3c

    public static void main(String[] args) {
//        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = new String[]{"z", "z"};
//        String[] words = new String[]{"zydd", "zx"};
        String[] words = new String[]{"za","zb","ca","cb"};
//        String[] words = new String[]{"z", "x"};
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(words));
    }
}

class Solution {
    Map<Character, Node> characterNodeMap;
    Queue<Node> tps;
    HashSet<Node> visited;

    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];

        characterNodeMap = new HashMap<>();
        int left = 0, right;
        for (right = 1; right < words.length; right++) {
            compareTwoWords(words[left], words[right]);
            left++;
        }

        Iterator itr = characterNodeMap.keySet().iterator();
        tps = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        visited = new HashSet<>();
        while (itr.hasNext()) {
            char key = (char) itr.next();
            if (characterNodeMap.get(key).degree == 0) {
                tps.offer(characterNodeMap.get(key));
            }
        }

        while (!tps.isEmpty()) {
            Node nextNode = tps.poll();
            visited.add(nextNode);
            res.append(nextNode.val);
            if (nextNode.neighbors.isEmpty()) continue;
            for (Node neighbor : nextNode.neighbors) {
                neighbor.degree -= 1;
                if (neighbor.degree == 0 && !visited.contains(neighbor)) {
                    tps.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        if (res.length() < characterNodeMap.size()) return "";
        return res.toString();
    }

    private void compareTwoWords(String w1, String w2) {
        if (w2.equals(w1)) {
            for (char c : w2.toCharArray()) {
                putNewWordIntoDict(c);
            }
            return;
        }
        if (w1.startsWith(w2)) compareTwoWords(w2, w1);
        if (w2.startsWith(w1)) {
            for (char c : w2.toCharArray()) {
                putNewWordIntoDict(c);
            }
            return;
        }

        for (char c : w2.toCharArray()) {
            putNewWordIntoDict(c);
        }
        for (char c : w1.toCharArray()) {
            putNewWordIntoDict(c);
        }
        int w1Itr = 0, w2Itr = 0;
        while (w1Itr != w1.length() && w2Itr != w2.length()) {
            char w1Char = w1.charAt(w1Itr);
            char w2Char = w2.charAt(w2Itr);
            if (w1Char != w2Char) {
                Node w1Node = characterNodeMap.get(w1Char);
                Node w2Node = characterNodeMap.get(w2Char);
                if (!w1Node.neighbors.contains(w2Node)) {
                    w1Node.neighbors.add(w2Node);
                    w2Node.degree += 1;
                }
                break;
            }
            w1Itr++;
            w2Itr++;
        }
    }

    private void putNewWordIntoDict(char c) {
        if (!characterNodeMap.containsKey(c)) {
            Node newChar = new Node(c, new ArrayList<>());
            characterNodeMap.put(c, newChar);
        }
    }

    class Node {
        char val;
        List<Node> neighbors;
        int degree;

        Node() {
        }

        Node(char val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
            this.degree = 0;
        }
    }
}
