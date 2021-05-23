package heap;

import java.util.Comparator;



public class NodeComparator implements Comparator<HashNode>{

	@Override
	public int compare(HashNode o1, HashNode o2) {

		return o2.freq-o1.freq;
	}

}
