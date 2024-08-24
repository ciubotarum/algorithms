package graphs;

import java.util.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPath {
    final class Node {
        String value;
        List<Node> edges = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, List<Node> edges) {
            this.value = value;
            this.edges = edges;
        }
    }
    public static boolean getRoute(Node a, Node b) {
        List<Node> currentList = a.edges;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(a);
        queue.add(a);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (Node neighbor : current.edges) {
                if (neighbor.equals(b)) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    @Nested
    class SolutionTest {
        private void doTest(Node a, Node b, boolean expected, String graphString) {
            String log = String.format("for getRoute(%s, %s) in graph:\n%s\n", a.value, b.value, graphString);
            boolean actual = CheckPath.getRoute(a, b);
            assertEquals(expected, actual, log);
        }

        @Test
        void testAcyclic() {
            String ascii = "A ----> B ----> D" + "\n" +
                    "↑       |" + "\n" +
                    "|       |     E" + "\n" +
                    "|       ↓" + "\n" +
                    "|-----> C" + "\n";
            Node E = new Node("E");
            Node D = new Node("D");
            Node C = new Node("C");
            Node B = new Node("B", Arrays.asList(C, D));
            Node A = new Node("A", Arrays.asList(B, C));

            Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
                    A, Map.of(
                            A, false, B, true, C, true, D, true, E, false),
                    B, Map.of(
                            A, false, B, false, C, true, D, true, E, false),
                    C, Map.of(
                            A, false, B, false, C, false, D, false, E, false),
                    D, Map.of(
                            A, false, B, false, C, false, D, false, E, false),
                    E, Map.of(
                            A, false, B, false, C, false, D, false, E, false));

            for (var a : adjacencyMatrix.keySet()) {
                for (var b : adjacencyMatrix.get(a).keySet()) {
                    doTest(a, b, adjacencyMatrix.get(a).get(b), ascii);
                }
            }
        }

        @Test
        void testLoop() {
            String ascii = "node----" + "\n" +
                    "↑      |" + "\n" +
                    "|      |" + "\n" +
                    "|------|" + "\n";

            Node node = new Node("node");
            node.edges = Arrays.asList(node);
            doTest(node, node, true, ascii);
        }

        @Test
        void testSimpleCyclic() {
            String ascii = "A----->B" + "\n" +
                    "↑      |" + "\n" +
                    "|      |       F" + "\n" +
                    "|      |" + "\n" +
                    "|      ↓" + "\n" +
                    "D<-----C ----> E" + "\n";

            Node E = new Node("E");
            Node F = new Node("F");
            Node A = new Node("A");
            Node D = new Node("D", Arrays.asList(A));
            Node C = new Node("C", Arrays.asList(D, E));
            Node B = new Node("B", Arrays.asList(C));
            A.edges.add(B);

            Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
                    A, Map.of(
                            A, true, B, true, C, true, D, true, E, true, F, false),
                    B, Map.of(
                            A, true, B, true, C, true, D, true, E, true, F, false),
                    C, Map.of(
                            A, true, B, true, C, true, D, true, E, true, F, false),
                    D, Map.of(
                            A, true, B, true, C, true, D, true, E, true, F, false),
                    E, Map.of(
                            A, false, B, false, C, false, D, false, E, false, F, false),
                    F, Map.of(
                            A, false, B, false, C, false, D, false, E, false, F, false));

            for (var a : adjacencyMatrix.keySet()) {
                for (var b : adjacencyMatrix.get(a).keySet()) {
                    doTest(a, b, adjacencyMatrix.get(a).get(b), ascii);
                }
            }
        }
    }

}
