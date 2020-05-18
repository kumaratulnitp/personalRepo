package com.personal.graphs;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vertex {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((neighbors == null) ? 0 : neighbors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (data != other.data)
			return false;
		if (neighbors == null) {
			if (other.neighbors != null)
				return false;
		} else if (!neighbors.equals(other.neighbors))
			return false;
		return true;
	}

	private int data;
	private List<Vertex> neighbors;
	
	public Vertex(int data) {
		this.data = data;
	}
	
	public void addEdge(Vertex neighbor) {
		if (neighbors == null) {
			neighbors = new ArrayList<>();
		}
		neighbors.add(neighbor);
	}
}
