package org.array;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SumitHappines {
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
	
	static class Node {
		long data;
		Node next;
		Node(long data){
			this.data = data;
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		long time = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		//FileReader fileReader = 
        //        new FileReader("input2.txt");
		
		//BufferedReader br = new BufferedReader(fileReader);
		Reader br = new Reader("input2.txt");
		
		int T = br.nextInt();
		//int T = sc.nextInt();
		for (int j = 0; j < T; j++) {
			int n = br.nextInt();
			//int n = sc.nextInt();
			long[] a = new long[n];
			int size = 0;
			//String[] sA = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				
				//long num = sc.nextLong();
				long num = br.nextLong();
				int k = -1;
				for (int m = 0; m < size; m++) {
					if (a[m] > num) {
						k = m;
						break;
					}
				}
				if (k != -1) {
					for (int m = size; m > k; m--) {
						a[m] = a[m - 1];
					}
					a[k] = num;
				}else {
					a[size] = num;
				}
				size++;

			}
			System.out.println();
            System.out.println( System.currentTimeMillis()-time);
			// find index positve/zero
			long sump = 0;
			long sumn = 0;
			int bindex = 0;
			long max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (a[i] >= 0) {
					sump = sump + a[i];
				} else {
					bindex = i;
					sumn = sumn + a[i];
				}
			}

			int i = 0;
			for (i = bindex; i >= 0; i--) {
				if ((sump + a[i] * (n - 1 - i)) > 0) {
					sumn = sumn - a[i];
					sump = (sump + a[i]);
				}else {
					break;
				}
			}
			
			max = sumn + sump * (n - 1 - i); 
			System.out.println(max);
			
			
			// Write your code here

		}
		System.out.println(System.currentTimeMillis() - time);
	}

}
