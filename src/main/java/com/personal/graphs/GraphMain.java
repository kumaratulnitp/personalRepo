package com.personal.graphs;

public class GraphMain {

	public static void main(String[] args) {
		Graph graph = new Graph();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		
		v1.addEdge(v2);
		v1.addEdge(v3);
		
		v2.addEdge(v3);
		
		//v3.addEdge(v4);
		
		Vertex result = graph.findNodeDFS(4);
		if (result != null) {
			System.out.println("found " + result.getData());
		} else {
			System.out.println("not found");
		}

	}

}
