

public class Lucas {

	private static long[] lucas;
	private static  double phiPlus = (Math.sqrt(5)+1)/2 ;
	private static  double phiMinus = (Math.sqrt(5)-1)/2 ;
	
	public static void upto(int n){
		 lucas = new long[n];
		 lucas[0] = 2;
		 lucas[1] = 1;
		 for(int i = 2; i < n; i++){
			 lucas[i] = lucas[i-1] + lucas[i-2];
		 }
	}
	
	public static boolean isPrime(long lucas2){
	if(lucas2 ==1){
		return false;
	}
	
	else{
		boolean result = true;
		for(int i = 2;i<lucas2;i++){
			if(lucas2%i ==0){
				result =false;
			}
		}
	return result;
	}
}
	
	public static void primes(){
		for(int i = 0;i<lucas.length;i++){
			if(isPrime(lucas[i])){
				System.out.println("L("+i+")="+lucas[i]);
			}
		}
	}
	
	public static double maxDiffClosedForm(){
		double[] com = new double[lucas.length];
		for(int i = 0; i < lucas.length; i++){
			com[i] = (Math.pow(phiPlus, i)) + Math.pow(-phiMinus, i) ;
		}
		double max = 0;
		for(int i = 0; i < com.length; i++){
			 double max2 = Math.abs(com[i] - lucas[i]);
			 if(max2 >= max){
				 max  = max2;
			 }
		}
		return max;
	}
	
public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]);
		if(a>=2&& a<=42){
			Lucas.upto(a);
			primes();
			System.out.printf("%.15f",maxDiffClosedForm());
			
		}
	}

}