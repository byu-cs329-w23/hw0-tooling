package edu.byu.cs329;

import java.util.HashSet;
import java.util.Set;

/**
 * Shortest path algorithm.
 */
public class Dijkstra {
  static final int M = Integer.MAX_VALUE;
  private final int[][] graph;
  private int[][] lengthArray = null;

  /**
   * Initialize with graph.
   *
   * @param g graph
   */
  public Dijkstra(int[][] g) {
    if (g == null) {
      throw new IllegalArgumentException("The graph must be non-null");
    }
    int dimension = g.length;
    if (dimension == 0) {
      throw new IllegalArgumentException("The graph must be non-empty");
    }
    for (int[] ints : g) {
      if (ints.length != dimension) {
        throw new IllegalArgumentException("The graph must be square");
      }
    }
    graph = g;
  }

  /**
   * Find all shortest paths.
   *
   */
  private void allShortestPathLengths() {
    int[][] lengths = new int[graph.length][graph.length];
    initializeL(graph, lengths);
    for (int[] thisL : lengths) {
      Set<Integer> s = new HashSet<>();
      while (s.size() < lengths.length) {
        int u = getMinimumIndex(thisL, s);
        s.add(u);
        for (int v = 0; v < thisL.length; ++v) {
          if (s.contains(v)) {
            continue;
          }
          int newDistance = thisL[u] + graph[u][v];
          if (newDistance > 0 && newDistance < thisL[v]) {
            thisL[v] = newDistance;
          }
        }
      }
    }

    lengthArray = lengths;
  }

  /**
   * Find the single shortest path.
   *
   * @param from starting node
   * @param to ending node
   * @return shortest path
   */
  public int shortestPath(int from, int to) {
    if (from < 0 || to < 0) {
      throw new IllegalArgumentException("Indices must be nonnegative!");
    }
    if (from >= graph.length || to >= graph.length) {
      throw new IllegalArgumentException(
              "Indices must be within the graph's dimension!");
    }
    if (lengthArray == null) {
      allShortestPathLengths();
    }
    return lengthArray[from][to];
  }

  /**
   * Find the smallest available node to visit.
   *
   * @param thisL the length of edge
   * @param s s
   * @return minimal index
   */
  static int getMinimumIndex(final int[] thisL, final Set<Integer> s) {
    int u = M;
    final int length = thisL.length;
    for (int i = 0; i < length; ++i) {
      if (s.contains(i)) {
        continue;
      }
      if (u == M || thisL[i] < thisL[u]) {
        u = i;
      }
    }
    return u;
  }

  private void initializeL(int[][] graph, int[][] l) {
    for (int i = 0; i < graph.length; ++i) {
      for (int j = 0; j < graph.length; ++j) {
        if (i == j) {
          l[i][j] = 0;
        } else {
          l[i][j] = M;
        }
      }
    }
  }

}
