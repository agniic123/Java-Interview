package Graph;

import java.util.*;

public class BFS {
public static void BFSHelper(Map<Integer, List<Integer>> adjList,int nodes,int start){
    boolean [] visited=new boolean[nodes];
    Queue<Integer> resultque=new LinkedList<>();
    resultque.offer(start);
    visited[start]=true;

    while (!resultque.isEmpty()){
        int node = resultque.poll();
        System.out.println("traversal:::"+node);
        for(int n : adjList.getOrDefault(node,new ArrayList<>())){
             if(!visited[n]){
                 visited[n]=true;
                 resultque.offer(n);
             }
        }
    }

}
    public static void main(String[] args) {
        int numsofNode=6;
        Map<Integer, List<Integer>> adjList=new HashMap<>();

        adjList.put(0,Arrays.asList(1,2));
        adjList.put(1,Arrays.asList(3));
        adjList.put(2,Arrays.asList(4,5));
        adjList.put(4, new ArrayList<>());
        adjList.put(5, new ArrayList<>());
        BFSHelper(adjList,numsofNode,0);
    }
}
