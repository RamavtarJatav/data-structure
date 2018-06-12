import java.util.HashSet;
import java.util.Set;

public class Permutation {
	static Set<String> permutation(String data) {
		Set<String> p = new HashSet<String>();
		if (data == null) {
			return null;
		} else if (data.length() == 1) {
			p.add(data);
			return p;
		} else {
			String sf = data.substring(0, 1);
			int l = data.length();
			// System.out.println(data.substring(1 , l));
			Set<String> ls = permutation(data.substring(1));
			
			
			for (String su : ls) {
				
				StringBuilder sbs = new StringBuilder();
				
				sbs.append(sf);
			    sbs.append(su);
			    p.add(sbs.toString());
			    int suLength = su.length();
				for(int i = 1 ; i < suLength ; i++) {
					StringBuilder sm = new StringBuilder();
					String s1 = su.substring(0, i);
					String s2 = su.substring(i);
					sm.append(s1).append(sf).append(s2);
					p.add(sm.toString());
				}
				
	            StringBuilder sbe = new StringBuilder();	
				sbe.append(su);
			    sbe.append(sf);
			    p.add(sbe.toString());
			    
			    
				
                 
			}
			
			return p;
			
			
		}

	}

	public static void main(String[] args) {
		String data = "SHIVA";
		Set<String> setSt = permutation(data);
		int i = 0 ;
		for(String s: setSt) {
			System.out.print(s + " ");
			i++;
		}
		System.out.println("\n"+i);
	}

}
