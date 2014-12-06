package nju.edu.cn;

public class CakeState {
	
	int[] cakeArray;
	String path;
	
	public CakeState(int[] array, String path){
		this.cakeArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			cakeArray[i] = array[i];
		}
		this.path = path;
	}
	
	public boolean isSorted(){
		for (int i = 1; i < cakeArray.length; i++) {
			if (cakeArray[i - 1] > cakeArray[i]) {
				return false;
			}
		}
		return true;
	}
	
	public long hash(){
		//DJB
		long hash = 5381;  
		for (int i = 0; i < cakeArray.length; i++) {
			hash = ((hash << 5) + hash) + cakeArray[i];
		}
		return hash;
		
	}

}
