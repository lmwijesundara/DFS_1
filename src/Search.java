import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Search {

    private static final String START = "A";
    private static final String END = "B";
    static Map<Integer, LinkedList<String>> paths;
    int count=2;
    
    public static void main(String[] args) throws FileNotFoundException {
    	 Graph graph = new Graph();
        // this graph is directional
    	System.out.print("Enter graph input file name: ");
    	Scanner input = new Scanner(System.in);
    	
		String file = input.nextLine();
		Scanner sc=new Scanner(new File(file));
		
		while(sc.hasNext()){
			 graph.addEdge(sc.next(), sc.next());
		}
        LinkedList<String> visited = new LinkedList();
        visited.add(START);
        //new Search().depthFirst(graph, visited);
        new Search().getPaths(graph, visited);
       System.out.println(paths);
    }

    private void getPaths(Graph graph, LinkedList<String> visitedNodes) {
        LinkedList<String> adjacent = graph.getAdjacent(visitedNodes.getLast());
        for(String node : adjacent){
            if(visitedNodes.contains(node)){
                continue;
            }
            if(node.equals(END)){
                visitedNodes.add(node);
                //printPath(visitedNodes);
                storePath(visitedNodes);
                visitedNodes.removeLast();
            }
            visitedNodes.add(node);
            getPaths(graph, visitedNodes);
            visitedNodes.removeLast();  
        }
       
    }

    private void printPath(LinkedList<String> visited) {
        for (String node : visited) {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
        
       
    }
    private void storePath(LinkedList<String> visited) {
      
        
        if(paths==null){
        	this.paths=new HashMap();
        	this.paths.put(count, visited);
        	count+=count;
        }
        else{
        	this.paths.put(count, visited);
        	count+=count;
        }
        System.out.println(paths);
    }
}