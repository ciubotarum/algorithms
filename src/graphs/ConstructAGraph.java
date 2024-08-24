package graphs;

import java.awt.*;
import java.util.Arrays;

public class ConstructAGraph {
    public static char[][] build(Point[] points) {
        double Xmax = Integer.MIN_VALUE;
        double Xmin = Integer.MAX_VALUE;
        double Ymin = Integer.MAX_VALUE;
        double Ymax = Integer.MIN_VALUE;


        for (Point point : points) {
            Xmax = Math.max(Xmax, point.x);
            Xmin = Math.min(Xmin, point.x);
            Ymax = Math.max(Ymax, point.y);
            Ymin = Math.min(Ymin, point.y);
        }

        Xmax = Math.max(Xmax, 0);
        Xmin = Math.min(Xmin, 0);
        Ymax = Math.max(Ymax, 0);
        Ymin = Math.min(Ymin, 0);

        int rows = (int) (Ymax - Ymin + 1);
        int cols = (int) (Xmax - Xmin + 1);

        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        int xOrigin = (int) -Xmin;
        int yOrigin = (int) Ymax;


        matrix[yOrigin][xOrigin] = '+';
        for (Point point : points) {
            int x = point.x + xOrigin;
            int y = yOrigin - point.y;
            matrix[y][x] = '*';
        }

        // Draw the axes
        for (int i = 0; i < cols; i++) {
            if (matrix[yOrigin][i] == ' ') {
                matrix[yOrigin][i] = '-';
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][xOrigin] == ' ') {
                matrix[i][xOrigin] = '|';
            }
        }


        return matrix;
    }

    public static void main(String[] args) {
//        ConstructAGraph.build(new Point[]{ new Point(0, 0), new Point(1, 4)});

        System.out.println(Arrays.deepToString(ConstructAGraph.build(new Point[]{new Point(2, 2), new Point(-2, -2)})));
    }
}
