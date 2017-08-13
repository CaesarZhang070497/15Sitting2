import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PremiumCustomer extends Customer{
	
	private Map<String, String> freeGifts;
	public PremiumCustomer(String name,Map<String, String> map) {
		super(name);
		freeGifts=map;
	}
 
	public void giftsFrom(String item, int quantity){
		if(freeGifts.containsKey(item)){
			System.out.println(freeGifts.get(item)+ " x "+quantity);  
		}
	}
	
	public String toString(){
		String output = super.toString()+"\n";
		output += "Free gifts:"+"\n";
		
		for( String str: freeGifts.keySet()){
			output += freeGifts.get(str)+" on ordering "+str;
		}
		return output;
	}
	
	public int chocolateGifts(){
		Collection<String> set = freeGifts.values();
		int index = 0;
		for(String str : set){
			if(str.contains("chocolate")){
				index++;
			}
		}
		return index;
	}
	
public static void main(String[] args) {
		
		Map<String, String> m = new HashMap<String,String>();
		m.put("printer cartridge", "chocolate bar");
		m.put("box of paper", "biscuits");
		PremiumCustomer caesar = new PremiumCustomer("Caesar",m);
		
		System.out.println(caesar.toString());
		System.out.println(caesar.chocolateGifts());
	}
}
