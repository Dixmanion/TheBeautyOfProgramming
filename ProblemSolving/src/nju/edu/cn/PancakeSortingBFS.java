package nju.edu.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS解决pancake排序问题
 * 类似于贪吃蛇问题
 * @author eureka
 *
 */
public class PancakeSortingBFS {
	
	int[] cakeArray;
	int cakeCounter;
	Queue<CakeState> queue;
	ArrayList<Long> statesChecked;//判重
	int step;
	
	public PancakeSortingBFS(){
		cakeCounter = 0;
	}
	
	void run(int[] pancakeArray){
		init(pancakeArray);
		CakeState state = new CakeState(cakeArray, "");
		queue.offer(state);
		CakeState answer = bfs();
		if (answer != null) {
			System.out.println(answer.path);
		}else{
			System.out.println("No answer!");
		}
		
	}
	
	void init(int[] pancakeArray){
		assert( pancakeArray!=null );
		assert( pancakeArray.length > 0);
		
		
		cakeCounter = pancakeArray.length;
		cakeArray = new int[pancakeArray.length];
		for (int i = 0; i < pancakeArray.length; i++) {
			cakeArray[i] = pancakeArray[i];
		}
		
		queue = new LinkedList<CakeState>();
		statesChecked = new ArrayList<Long>();
		step = 0;
	}
	
	CakeState bfs(){
		
		while (!queue.isEmpty()) {
			//从queue中取出一个元素
			CakeState state = queue.poll();
			if (state.isSorted()) {
				return state;
			}
			if (!statesChecked.contains(state.hash())) {
				//放入stateChecked
				statesChecked.add(state.hash());
				
				for (int i = 1; i < cakeArray.length; i++) {
					CakeState temp = revert(0, i, state);
					queue.offer(temp);
				}
			}
		}
		return null;
	}
	
	/**
     * 交换数组中从nBegin到nEnd的元素的顺序
     * @param nBegin
     * @param nEnd
     */
    CakeState revert(int nBegin, int nEnd, CakeState state){
    	assert(nEnd > nBegin);
    	assert(state != null);
    	CakeState newState = null;
    	int[] newCakeArray = new int[state.cakeArray.length];
    	for (int i = 0; i < newCakeArray.length; i++) {
			newCakeArray[i] = state.cakeArray[i];
		}
    	int t = 0;
    	for (int i = nBegin, j = nEnd; i < j; i++,j--) {
			t = newCakeArray[i];
			newCakeArray[i] = newCakeArray[j];
			newCakeArray[j] = t;
		}
    	
    	//为了输出好看
    	if (state.path.equals("")) {
    		newState = new CakeState(newCakeArray, state.path + String.valueOf(nEnd));
		}else{
			newState = new CakeState(newCakeArray, state.path + ", " + String.valueOf(nEnd));
		}
    	
    	return newState;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PancakeSortingBFS pancakeSortingBFS = new PancakeSortingBFS();
		int[] cakeArray = {3,2,1,6,5,4};
		pancakeSortingBFS.run(cakeArray);
	}

}
