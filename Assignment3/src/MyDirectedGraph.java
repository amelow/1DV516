import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
 
/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 */
public class MyDirectedGraph implements A3Graph {
    private static List<List<Integer>> adjacency;
    private int numOfVertices;
 
    MyDirectedGraph(int amountOfVertices) {
        numOfVertices = amountOfVertices;
        adjacency = new ArrayList<List<Integer>>();
 
        for (int i = 0; i < amountOfVertices; i++) {
            adjacency.add(new LinkedList<Integer>());
        }
    }
 
    public List<List<Integer>> getAdjacency() {
        //      System.out.println(adjacency.toString());
        return adjacency;
    }
 
    @Override
    public void addVertex(int vertex) {
        adjacency.add(new LinkedList<Integer>());
        numOfVertices++;
 
    }
 
    @Override
    public void addEdge(int sourceVertex, int targetVertex) {
        adjacency.get(sourceVertex).add(targetVertex);
 
    }
 
    public void addReverseEdge(int sourceVertex, int targetVertex) {
        adjacency.get(targetVertex).add(sourceVertex);
 
    }
 
    @Override
    public boolean isConnected() {
        List<List<Integer>> Components = connectedComponents();
       
        /* boolean[] visited = new boolean[numOfVertices];
        List<Integer> s = new ArrayList<Integer>();
 
        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i] && adjacency.get(i).size() != 0) {
                connectionDFS(i, visited, s);
            }
 
        }
 
        return s.size() == numOfVertices;
         */
        return (Components.size() ==1);
    }
 
    /*
     * Reverse the edges of the graph.
     */
 
    /*
     * Reverse the edges of the graph.
     */
    public List<List<Integer>> reverseGraph() {
        //      MyDirectedGraph reverse = new MyDirectedGraph(numOfVertices);
        Stack<List<Integer>> reverse = new Stack<List<Integer>>();
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        List<List<Integer>> transpose = new ArrayList<List<Integer>>();
        //      reverse.addEdge(0, targetVertex);
 
        for (int i = 0; i < numOfVertices; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < numOfVertices; j++) {
                row.add(0);
            }
            matrix.add(row);
            //          transpose.add(row);
        }
 
        for (int i = 0; i < numOfVertices; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < numOfVertices; j++) {
                row.add(0);
            }
            transpose.add(row);
        }
 
        for (int i = 0; i < numOfVertices; i++) {
 
            for (int j = 0; j < getAdjacency().get(i).size(); j++) {
                matrix.get(i).set(getAdjacency().get(i).get(j), 1);
            }
 
        }
 
        System.out.println(matrix.toString());
 
        /*
         * Transpose the matrix
         */
 
        for (int i = 0; i < numOfVertices; i++) {
 
            for (int j = 0; j < numOfVertices; j++) {
                if (matrix.get(i).get(j) == 1) {
                    transpose.get(j).set(i, 1);
                }
 
            }
 
        }
 
        for (int i = 0; i < numOfVertices; i++) {
            reverse.add(new ArrayList<Integer>());
        }
 
        System.out.println("Hej: " + reverse.toString());
        System.out.println("Transpose: " + transpose.toString());
 
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                if (transpose.get(i).get(j) == 1) {
                    reverse.get(i).add(j);
                }
            }
        }
 
        /*
         * Add the transposed edges to the new graph.
         */
        //      MyDirectedGraph tGraph = new MyDirectedGraph(numOfVertices);
        ////        System.out.println("Reverse graph: " + reverse.toString());
        //
        //      for (int i = 0; i < numOfVertices; i++) {
        //
        //          if (reverse.get(i).size() != 0) {
        //              for (int j = 0; j < reverse.get(i).size(); j++) {
        //                  tGraph.addEdge(i, reverse.get(i).get(j));
        //              }
        //          }
        //
        //      }
 
        //      System.out.println("oooooo " + tGraph.getAdjacency().toString());
        return reverse;
 
    }
 
    @Override
    public boolean isAcyclic() {
        Stack<Integer> stack = new Stack<Integer>();
 
        boolean[] visited = new boolean[numOfVertices];
        int n = 0;
        while (n < visited.length) {
            if (!visited[n])
                if (!isAcyclicDFS(n, visited, stack))
                    return false;
            n++;
        }
 
        return true;
    }
 
    public static boolean isAcyclicDFS(int n, boolean[] isVisited, Stack<Integer> stack) {
        if (stack.contains(n))
            return false;
        isVisited[n] = true;
        stack.push(n);
        for (int curr : adjacency.get(n)) {
            if (n == curr)
                return false;
            if (isVisited[curr])
                continue;
            if (!isAcyclicDFS(curr, isVisited, stack))
                return false;
        }
        stack.pop();
        return true;
    }
 
    @Override
    public List<List<Integer>> connectedComponents() {
        boolean[] isVisited = new boolean[numOfVertices];
        System.out.println("hej");
        List<Integer> list = componentsDFS(numOfVertices-1, isVisited,adjacency);
 
        List<List<Integer>> connections = new ArrayList<List<Integer>>();
 
        //      List<Integer> temp = new ArrayList<Integer>();
        //
        //      List<List<Integer>> connections = new ArrayList<List<Integer>>();
        ////        System.out.println(connectionDFS(numOfVertices, isVisited, temp));
        //     
        //
 
        Collections.reverse(list);
        for (int i = 0; i < numOfVertices; i++) {
            if (!isVisited[i]) {
                connectionDFS(i, isVisited, list, adjacency);
            }
        }
        //
        ////        System.out.println("Stack components: " + s.toString());
        List<List<Integer>> reverseEdges = reverseGraph();
        //
 
 
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
 
        List<List<Integer>> reverseconnections = new ArrayList<List<Integer>>();
        //
        ////        List<Integer> temp = new ArrayList<Integer>();
        System.out.println("uuuuuuuuu " + list.toString());
        for (int i = 0; i < list.size(); i++) {
 
            int n = list.get(i);
 
            if (!isVisited[n]) {
                List<Integer> temp = new ArrayList<Integer>();
                connectionDFS(n, isVisited, temp,adjacency);
                connections.add(temp);
            }
 
        }
 
 
        isVisited = new boolean[numOfVertices];
        for (int i = 0; i < list.size(); i++) {
 
            int n = list.get(i);
 
            if (!isVisited[n]) {
                List<Integer> temp = new ArrayList<Integer>();
                connectionDFS(n, isVisited, temp, reverseEdges);
                reverseconnections.add(temp);
            }
 
        }
        System.out.println("Ordinary Connections : "+connections);
        System.out.println("Reverse connections : " +reverseconnections );
 
        ////        connections.add(temp);
        return FixConnected(connections, reverseconnections);
    }
 
    public List<List<Integer>> FixConnected (List<List<Integer>> connections, List<List<Integer>> reverseconnections) {
        List<List<Integer>> fixedList = new ArrayList<List<Integer>>();
        boolean connectionsIsBigger = false;
        if(connections.size() >= reverseconnections.size()) {
            connectionsIsBigger = true;
        }
        if (connectionsIsBigger) {
            for(int i= 0; i < connections.size(); i++) {
                List<Integer> TempList = connections.get(i);
                List<Integer> TempList2 = null;
                if (i <= reverseconnections.size()-1) {
                    TempList2 = reverseconnections.get(i);
                    if(TempList.retainAll(TempList2))
                        fixedList.add(TempList);
                        else {
                            fixedList.add(TempList);
                        }
                }
 
            }
        } else {
            for(int i= 0; i < reverseconnections.size(); i++) {
                List<Integer> TempList = reverseconnections.get(i);
                List<Integer> TempList2 = null;
                if (i <= connections.size()-1) {
                    TempList2 = connections.get(i);
                    if(TempList.retainAll(TempList2))
                    fixedList.add(TempList);
                    else {
                        fixedList.add(TempList);
                    }
                }
 
            }
 
 
 
            System.out.println("This is the fixed List: "+fixedList);
           
        }
        return fixedList;
    }
 
    public int getNumOfVertices() {
        return numOfVertices;
    }
 
    public void setNumOfVertices(int numOfVertices) {
        this.numOfVertices = numOfVertices;
    }
 
    public List<Integer> componentsDFS(int vertexIndex, boolean[] isVisited, List<List<Integer>> adjL) {
        //      isVisited[vertexIndex] = true;
 
        List<Integer> list = new ArrayList<Integer>();
 
        //      for(int i = 0; i < adjacency.get(i).size(); i++) {
        //          int temp = adjacency.get(vertexIndex).get(i);
        for (int curr : adjL.get(vertexIndex)) {
            //          System.out.println("qqqqqqqq " + list.toString());
            if (!isVisited[curr]) {
                connectionDFS(curr, isVisited, list, adjL);
 
            }
 
        }
 
        return list;
    }
 
    public void connectionDFS(int pos, boolean[] isVisited, List<Integer> list, List<List<Integer>> adjL) {
        isVisited[pos] = true;
        //      System.out.println("Pos: " + pos);
        List<Integer> ost = adjL.get(pos);
        for (int i = 0; i < ost.size(); i++) {
            if (!isVisited[ost.get(i)]) {
                System.out.println(ost.get(i)+" Is not visited. Visiting");
                connectionDFS(ost.get(i), isVisited, list, adjL);
            }
 
        }
 
        list.add(pos);
        //      return list;
    }
 
}