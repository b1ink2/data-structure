package test12;

import test7.NodeQueue;

public class BFSTraverse {
    private static boolean[] visited;

    public static void BFST(ALGraph G) throws Exception {
        visited = new boolean[G.getVexNum()];
        for (int v = 0; v < G.getVexNum(); v++)
            visited[v] = false;
        for (int v = 0; v < G.getVexNum(); v++)
            if (!visited[v])
                BFS(G, v);
    }

    private static void BFS(ALGraph G, int v) throws Exception {
        visited[v] = true;
        System.out.print(G.getVex(v).toString() + "");
        NodeQueue Q = new NodeQueue();
        Q.offer(v);
        while (!Q.isEmpty()) {
            int u = (Integer) Q.poll();
            for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)) {
                if (!visited[w]) {
                    visited[w] = true;
                    System.out.print(G.getVex(w).toString() + " ");
                    Q.offer(w);
                }
            }
        }
    }

}
