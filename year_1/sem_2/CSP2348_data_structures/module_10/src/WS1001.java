

import java.io.*;
// import ArrayQueue;

class WS1001{
	public static void main(String[] args){
		ArrayQueue q = new ArrayQueue(10);
		Integer j = null;
		int i;
		System.out.println("starting...");
		for(i=0;i<10;i++){
			j = new Integer((int)(Math.random() * 100));
			q.insert(j);
			System.out.println("insert: " + j);
		}
		while(!q.isEmpty()){
			System.out.println("remove: " + ((Integer)q.remove()));
		}
		System.out.println("Done ;-)\n\n");
	}
}
