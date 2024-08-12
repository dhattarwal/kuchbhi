public class SingleSourceShortestPath {
    public static void shortestpath(int v, double cost[][], double dist[], int n)
    {
        boolean s[] = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            dist[i] = Double.MAX_VALUE;
            s[i] = false;
        }
        dist[v] = 0.0;
        for(int count = 0; count < n - 1; count++)
        {
            int u = -1;
            double minDist = Double.MAX_VALUE;
            for(int i = 0; i < n; i++)
            {
                if(!s[i] && dist[i] < minDist)
                {
                    minDist = dist[i];
                    u = i;
                }
            }
            s[u] = true;
            for(int w = 0; w < n; w++)
            {
                if(!s[w] && cost[u][w] != 0 && dist[u] != Double.MAX_VALUE && dist[u] + cost[u][w] < dist[w])
                {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        double cost[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        int source = 0;
        double distance[] = new double [n];
        shortestpath(source, cost, distance, n);
        System.out.println("Shortest distance from vertex : " + source);
        for(int i = 0; i < n; i++)
            System.out.println("To vertex " + i + " " + distance[i]);
    }
}