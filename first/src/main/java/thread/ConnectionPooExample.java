package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConnectionPooExample {
	
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPool();
		ThreadCon f1 =new ThreadCon(cp);
		ThreadCon f2 =new ThreadCon(cp);
		ThreadCon f3 =new ThreadCon(cp);
		ThreadCon f4 =new ThreadCon(cp);
		ThreadCon f5 =new ThreadCon(cp);
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
		
		Callable callable;
		Future fu;
		FutureTask ft;
		
	}

}
