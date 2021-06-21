package greedy;

public class QuantPrice implements Comparable<QuantPrice> {
	
	int quant;
	int value;
	
	public QuantPrice(int quant,int value) {
		this.quant=quant;
		this.value=value;
	}

	@Override
	public int compareTo(QuantPrice o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}

}
