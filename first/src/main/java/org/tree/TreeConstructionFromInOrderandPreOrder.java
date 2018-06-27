package org.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeConstructionFromInOrderandPreOrder {
	static class Node{
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data = data;			
		}
	}
	
	Node root;
	public static void main(String[] args) {
		char[] inorderArray = {'D','G','B','E','A','H','F','I','C' };
		char[] preOrderArray = {'A','B','D','G','E','C','F','H','I' };
		int il = inorderArray.length;
		int pl = preOrderArray.length;
		
		
		TreeConstructionFromInOrderandPreOrder bt = new TreeConstructionFromInOrderandPreOrder();
		int i = 0 ;
        while(i < il) {
        	bt.root = new Node(preOrderArray[i]);
        	int j = 0 ;
        	List<Character> leftsubinA = new ArrayList<Character>();
        	List<Character> rightsubinB = new ArrayList<Character>();
        	while(preOrderArray[i] != inorderArray[j]) {
        		leftsubinA.add(inorderArray[j]);
        		j++;
        	}
        	 
        	
       
        }
		
		
		
		
		
	}
	

}
