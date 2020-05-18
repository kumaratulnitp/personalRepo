package com.personal.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Graph {
	private int size;
	private List<Vertex> vertices;
	
	public Graph() {
		size = 0;
		vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
		size++;
	}

	private Vertex findNodeDFS(Vertex vertex, Map<Vertex, Boolean> visitedNode, int data) {
		System.out.println(vertex.getData() + "," + visitedNode );
		if (vertex.getData() == data) {
			return vertex;
		}
		if (vertex.getNeighbors() == null ) {
			return null;
		}
		for (Vertex neighbor:vertex.getNeighbors()) {
			if (!visitedNode.containsKey(neighbor)) {
				visitedNode.put(neighbor, true);
				return findNodeDFS(neighbor, visitedNode, data);
			} else { 
				System.out.println("visited node contains " + vertex.getData());
			}
		}

		return null;
	}

	public Vertex findNodeDFS(int data) {
		if (size == 0) {
			return null;
		}
		Vertex result = null;
		for (Vertex vertex: vertices) {
			result = findNodeDFS(vertex, new HashMap<Vertex, Boolean>(), data);
			if (result != null) {
				break;
			}
		}
		return result;
	}
}
