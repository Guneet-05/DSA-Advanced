import java.util.*;

class Pair {
    int nbr;
    int wt;
    
    //for unweighted graph
    Pair(int nbr) {
        this.nbr = nbr;
    }
    
    //for weighted graph
    Pair(int nbr, int wt) {
        this.nbr = nbr;
        this.wt = wt;
    }
}

class Graph {
    ArrayList<Pair>[] adj;
    
    Graph(int n) {
        adj = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
    }
    
    //for unweighted graph
    public void addEdge(int src,int nbr,boolean isDirected) {
        adj[src].add(new Pair(nbr));
        if(!isDirected)
            adj[nbr].add(new Pair(src));
    }
    
    //for weighted graph
    public void addEdge(int src, int nbr, int wt,boolean isDirected) {
        adj[src].add(new Pair(nbr,wt));
        if(!isDirected)
            adj[nbr].add(new Pair(src,wt));
    }
    
    //for unweighted graph
    public void printAdjListUnweighted() {
        for(int i=0;i<adj.length;i++) {
            System.out.print(i + " --> ");
            for(Pair p : adj[i]) {
                System.out.print("(" + p.nbr + ") ");
            }
            System.out.println();
        }
    }
    
    //for weighted graph
    public void printAdjListWeighted() {
        for(int i=0;i<adj.length;i++) {
            System.out.print(i + " --> ");
            for(Pair p : adj[i]) {
                System.out.print("(" + p.nbr + "," + p.wt + ") ");
            }
            System.out.println();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        
        Graph g = new Graph(vtces);
        int edges = scn.nextInt();
        
        for(int i=0;i<edges;i++) {
            int src = scn.nextInt();
            int nbr = scn.nextInt();
            int wt = scn.nextInt();
            
            //addEdge
            g.addEdge(src,nbr,wt,true);
        }
        
        g.printAdjListWeighted();
    }
}
