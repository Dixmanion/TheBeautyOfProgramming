package nju.edu.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
    public int ladderLength(String start, String end, Set<String> dict) {
    	
    	if (dict == null || dict.isEmpty()) return 0;
    	if (dict.contains(start)) dict.remove(start);
    	if (dict.contains(end)) dict.remove(end);
    	
    	Queue<String> paths = new LinkedList<String>();
    	Queue<Integer> steps = new LinkedList<Integer>();
    	
    	paths.add(start);
    	steps.add(1);
    	
    	while (!paths.isEmpty()) {
			String tempPath = paths.poll();
			int tempStep = steps.poll();
			
			if (canBeTransferred(tempPath, end)) return (tempStep + 1);
			
			Set<String> candidates = getCandidates(tempPath, dict);
	    	for (String candidate : candidates) {
	    		paths.add(candidate);
	    		steps.add(tempStep + 1);
	    		dict.remove(candidate);
			}
		}
    	
    	return 0;
    }
    
    /**
     * 返回start的候选集
     * @param start
     * @param dict
     * @return
     */
    private Set<String> getCandidates(String start, Set<String> dict){
    	Set<String> candidates = new HashSet<String>();
    	
    	for (String word : dict) {
    		if (canBeTransferred(start, word))
    			candidates.add(word);
    	}
    	return candidates;
    }
    
    private boolean canBeTransferred(String from, String to){
    	//只允许有一个字母不一样，from和to的长度相同
    	int dif = 0;
    	for (int i = 0; i < from.length(); i++) {
			if (from.charAt(i) != to.charAt(i))
				dif++;
		}
    	return dif==1;
    }
    
    public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hit");
		dict.add("cog");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		int steps = wordLadder.ladderLength(start, end, dict);
		System.out.println(steps);
	}

}
