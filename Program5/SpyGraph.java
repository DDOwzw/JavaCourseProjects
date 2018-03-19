///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P5)
// Files:            (SpyGraph.java)
// Semester:         (CS367) Spring 2016
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      (Lecture 2)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     ()
// Email:            ()
// CS Login:         ()
// Lecturer's Name:  ()
// Lab Section:      ()
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
/**
 * Stores all vertexes as a list of GraphNodes.  Provides 
 * necessary graph operations as need by the SpyGame class.
 * 
 * @author strominger & Zhongwei
 *
 */
public class SpyGraph implements Iterable<GraphNode> {

	/** DO NOT EDIT -- USE THIS LIST TO STORE ALL GRAPHNODES */
	private List<GraphNode> vlist;
	private HashMap<GraphNode, GraphNode> hm;
	private List<GraphNode> visited;
	private List<Neighbor> a, unvisited;


	/**
	 * Initializes an empty list of GraphNode objects
	 */
	public SpyGraph(){
		// TODO initialize data member(s)
		vlist = new ArrayList<GraphNode>();
	}

	/**
	 * Add a vertex with this label to the list of vertexes.
	 * No duplicate vertex names are allowed.
	 * @param name The name of the new GraphNode to create and add to the list.
	 */
	public void addGraphNode(String name){
		// TODO implement this method
		// may not throw Exceptions!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(name == null) throw new IllegalArgumentException();
		// not a duplicate name
		if(getNodeFromName(name) == null){
			GraphNode newGraphNode = new GraphNode(name);
			vlist.add(newGraphNode);
		}else{
			// if it is a duplicated name, what shall i do????????????????????
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Adds v2 as a neighbor of v1 and adds v1 as a neighbor of v2.
	 * Also sets the cost for each neighbor pair.
	 *   
	 * @param v1name The name of the first vertex of this edge
	 * @param v2name The name of second vertex of this edge
	 * @param cost The cost of traveling to this edge
	 * @throws IllegalArgumentException if the names are the same
	 */
	public void addEdge(String v1name, String v2name, int cost) 
			throws IllegalArgumentException{
		// TODO implement this method
		if(v1name == null || v2name == null) 
			throw new IllegalArgumentException();
		if(v1name.equals(v2name)) throw new IllegalArgumentException();
		GraphNode v1, v2;
		// find v1 first
		v1 = getNodeFromName(v1name);
		// find v2;
		v2 = getNodeFromName(v2name);
		if(v1 != null && v2 != null){
			// Adds v2 as a neighbor of v1; set the cost of edge
			v1.addNeighbor(v2, cost);
			// adds v1 as a neighbor of v2; set the cost of edge
			v2.addNeighbor(v1, cost);
		}else{
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Return an iterator through all nodes in the SpyGraph
	 * @return iterator through all nodes in alphabetical order.
	 */
	public Iterator<GraphNode> iterator() {
		return vlist.iterator();
	}

	/**
	 * Return Breadth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in BFS traversal
	 * @param end Last node (match node) in BFS traversal
	 * @return The BFS traversal from start to end node.
	 * 
	 * 
	 * @throw IllegalArgumentException when the target node is not reachable.
	 */
	public List<Neighbor> BFS( String start, String end ) {
		// TODO implement this method
		// may need and create a companion method
		a = new ArrayList<Neighbor>();
		hm = new HashMap<GraphNode, GraphNode>();
		visited = new ArrayList<GraphNode>();
		// find the startNode
		GraphNode NodeStart = getNodeFromName(start);
		GraphNode NodeEnd = getNodeFromName(end);

		bfs(NodeStart, null, end);

		if(hm.containsKey(NodeEnd)){
			saveThePath(NodeEnd);
			convertToList();
		}else{
			// when the target node is not reachable
			throw new IllegalArgumentException();
		}

		return a;
	}
	/**Companion method for BFS
	 * 
	 * @param cur
	 * @param prede
	 * @param end
	 */
	private void bfs(GraphNode cur, GraphNode prede, String end) {

		Queue<GraphNode> queue = new LinkedList<GraphNode>();

		hm.put(cur, prede);
		queue.add(cur);
		while (!queue.isEmpty()) {
			GraphNode current = queue.poll();
			for (Neighbor k : current.getNeighbors()) {

				if (! hm.containsKey(k.getNeighborNode())){
					hm.put(k.getNeighborNode(), current);
					queue.add(k.getNeighborNode());
				} // end if k not visited
			} // end for every successor k
		} // end while queue not empty





	}

	/**
	 * @param name Name corresponding to node to be returned
	 * @return GraphNode associated with name, null if no such node exists
	 */
	public GraphNode getNodeFromName(String name){
		for ( GraphNode n : vlist ) {
			if (n.getNodeName().equalsIgnoreCase(name))
				return n;
		}
		return null;
	}

	/**
	 * Return Depth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in DFS traversal
	 * @param end Last node (match node) in DFS traversal
	 * @return The DFS traversal from start to end node.
	 * 
	 * @throw IllegalArgumentException when the target node is not reachable.
	 */
	public List<Neighbor> DFS(String start, String end) {
		// TODO implement this method
		// may need and create a companion method
		a = new ArrayList<Neighbor>();
		hm = new HashMap<GraphNode, GraphNode>();
		visited = new ArrayList<GraphNode>();
		// find the startNode
		GraphNode NodeStart = getNodeFromName(start);
		GraphNode NodeEnd = getNodeFromName(end);

		dfs(NodeStart, null, end);

		if(hm.containsKey(NodeEnd)){
			saveThePath(NodeEnd);
			convertToList();
		}else{
			// when the target node is not reachable
			throw new IllegalArgumentException();
		}

		return a;
	}

	/**Companion method for DFS
	 * 
	 * @param cur
	 * @param prede
	 * @param end
	 */
	private void dfs(GraphNode cur, GraphNode prede, String end){
		// store cur in the map
		hm.put(cur, prede);
		// if the cur is end
		if(cur.getNodeName().equals(end)){

		}else{
			// if the curr is not the end
			// check every successors
			for(Neighbor m: cur.getNeighbors()){
				// if it is not in the hm
				if ( !hm.containsKey(m.getNeighborNode())) {
					dfs(m.getNeighborNode(), cur, end);
				}
			}
		}
	}

	/**
	 * Copy the correct path to the list of Neighbors
	 * Be careful that the list of visited is in reversed ordered!
	 */
	private void convertToList() {

		for(int i = visited.size()-1; i > 0; i--){
			try {
				int cost = visited.get(i).getCostTo(
						visited.get(i-1).getNodeName());
				// String name = visited.get(i -1).getNodeName();
				//create a new neighbor with the cost and GraphNode
				Neighbor NNode = new Neighbor(cost, visited.get(i-1));
				a.add(NNode);
			} catch (NotNeighborException e) {

				e.printStackTrace();
			}
		}

	}
	/**
	 * save the path to the list
	 * @param nodeEnd
	 */
	private void saveThePath(GraphNode nodeEnd) {

		if(nodeEnd != null){
			visited.add(nodeEnd);
			saveThePath(hm.get(nodeEnd));
		}
	}



	/**
	 * OPTIONAL: Students are not required to implement Dijkstra's ALGORITHM
	 *
	 * Return Dijkstra's shortest path list of nodes on path 
	 * from one Node to another.
	 * @param start First node in path
	 * @param end Last node (match node) in path
	 * @return The shortest cost path from start to end node.
	 */
	public List<Neighbor> Dijkstra(String start, String end){

		// TODO: implement Dijkstra's shortest path algorithm
		// may need and create a companion method

		// initialize the visited mark
/*		a = unvisited = new ArrayList<Neighbor>();
		hm = new HashMap<GraphNode, GraphNode>();
		visited  = new ArrayList<GraphNode>();


		// initialize the total weight to Infinity
		for(GraphNode l: vlist){
			Neighbor nei = new Neighbor(l.NOT_NEIGHBOR, l);
			unvisited.add(nei);
		}
		// initialize the prede to null

		// find the startNode
		GraphNode NodeStart = getNodeFromName(start);
		GraphNode NodeEnd = getNodeFromName(end);

		ijk(NodeStart, null, end);

		if(hm.containsKey(NodeEnd)){
			saveThePath(NodeEnd);
			convertToList();
		}else{
			// when the target node is not reachable
			throw new IllegalArgumentException();
		}

		return a;
		
	*/	
		
		return new ArrayList<Neighbor>();
	}

	/**Companion method for DFS
	 * 
	 * @param cur
	 * @param prede
	 * @param end
	 */
	private void ijk(GraphNode cur, GraphNode prede, String end){
		PriorityQueue<Neighbor> pq = new PriorityQueue<Neighbor>();
		pq.add(getNeighborFromNode(cur));// check null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		
	}

	private Neighbor getNeighborFromNode(GraphNode cur) {
		Iterator<Neighbor> itr = unvisited.iterator();
		Neighbor neig = null;
		while(itr.hasNext()){
			Neighbor current = itr.next();
			if(current.getNeighborNode().getNodeName().equals(cur.getNodeName())){
				neig = current;
			}
		}
		return null;
	}

	/**
	 * DO NOT EDIT THIS METHOD 
	 * @return a random node from this graph
	 */
	public GraphNode getRandomNode() {
		if (vlist.size() <= 0 ) {
			System.out.println("Must have nodes in the graph before "
					+ "randomly choosing one.");
			return null;
		}
		int randomNodeIndex = Game.RNG.nextInt(vlist.size());
		return vlist.get(randomNodeIndex);
	}


}
