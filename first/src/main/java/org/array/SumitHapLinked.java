package org.array;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.array.SumitHappines.Reader;

public class SumitHapLinked {
	long sump = 0;
	long sumn = 0;

	static class Node {
		long d;
		Node next;

		Node(long d) {
			this.d = d;
		}
	}

	Node root;

	void add(long d) {
		if (d >= 0) {
			sump = sump + d;
		} else {
			sumn = sumn + d;
		}
		if (root == null) {
			root = new Node(d);
		} else {
			if (d >= root.d) {
				Node temp = new Node(d);
				temp.next = root;
				root = temp;
			} else {
				add(root, d);
			}

		}

	}

	void addnR(long d) {
//		if (d >= 0) {
//			sump = sump + d;
//		} else {
//			sumn = sumn + d;
//		}
		
		
		if (root == null) {
			root = new Node(d);
			return;
		}
		

		if (root.next == null) {
			if (d >= root.d) {
				Node temp = new Node(d);
				temp.next = root;
				root = temp;
				return;
			}
			root.next = new Node(d);
			return;
		}

		Node node = root;
		while (node.next != null) {
			if (d < node.d && d >= node.next.d) {
                Node temp = new Node(d);
                Node aft = node.next;
                
                node.next = temp;
                temp.next = aft;
                return ;
			}else {
				node = node.next;
			}
		}
		
		
		node.next = new Node(d);
		

	}

	void add(Node node, long d) {
		if (node.next != null) {
			if (d < node.d && d >= node.next.d) {
				Node temp = new Node(d);
				Node aft = node.next;
				node.next = temp;
				temp.next = aft;
				return;
			} else if (d < node.d && d < node.next.d) {
				add(node.next, d);
			}
		} else {
			node.next = new Node(d);
			return;
		}
	}

	void print() {
		if (root == null)
			return;

		print(root);
		System.out.println();

	}

	void print(Node node) {
		System.out.print(node.d + " ");
		if (node.next != null) {
			print(node.next);
		}
	}
  
	
	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		SumitHapLinked ln = new SumitHapLinked();
		//FileReader fileReader = new FileReader("input2.txt");

		//BufferedReader br = new BufferedReader(fileReader);
		Reader br = new Reader("input2.txt");
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			//int n = Integer.parseInt(br.readLine());
			int n = br.nextInt();
			
			//String[] a = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				//System.out.println(a[j]);
				//long d = 
				ln.addnR(br.nextLong());
			}
		}
//		 ln.addnR(8);
//		 ln.addnR(-1);
//		 ln.addnR(-18);
//		 ln.addnR(0);
//		 ln.addnR(2);
//		 ln.addnR(4);
//		 ln.addnR(3);
		ln.print();

	}

}
