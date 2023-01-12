package edu.byu.cs329;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner for Dijkstra.
 *
 */
public class DijkstraMain {


  /**
   * Supply a graph to the Dijkstra solver.
   *
   * @param args commandline arguments (for compatibility, not used)
   */
  public static void main(String[] args) {
    final Logger logger = LoggerFactory.getLogger(Dijkstra.class);
    final int[][] graph = { { 0, 2, 4, Dijkstra.M, Dijkstra.M, Dijkstra.M },
        { 2, 0, 1, 4, Dijkstra.M, Dijkstra.M }, { 4, 1, 0, 2, 6, Dijkstra.M },
        { Dijkstra.M, 4, 2, 0, 1, 3 }, { Dijkstra.M, Dijkstra.M, 6, 1, 0, 5 },
        { Dijkstra.M, Dijkstra.M, Dijkstra.M, 3, 5, 0 } };
    Dijkstra d = new Dijkstra(graph);
    int sp = d.shortestPath(0, 4);
    logger.info("d = " + sp);
  }

}
