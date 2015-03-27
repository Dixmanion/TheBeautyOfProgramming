package nju.edu.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;


public class Test {

	public static void main(String[] args) {
//		Test test = new Test();
//		String s = "abcd";
//		Set<String> dict = new HashSet<String>();
//		dict.add("a");
//		dict.add("abc");
//		dict.add("b");
//		dict.add("cd");
//		List<String> answerList = test.wordBreak(s, dict);
//		System.out.println(answerList);
		Deque<List<String>> paths = new LinkedList<List<String>>();
		String s = "abcdefg";
		char c = 's';
		s = s + c;
		System.out.println(s);
	}
	
	List<String> sentences = new ArrayList<String>();//用来存储答案
    String string;
    Set<String> dictionary;
    public static int counter = 0;
    
    
    public List<String> wordBreak(String s, Set<String> dict) {
        string = s;
        dictionary = dict;
        dfs("", "", 0);
        return sentences;
    }
    
    private void dfs(String tempSentence, String tempWord, int index) {
        if (index >= string.length()) {	
        	if (!tempSentence.equals("") || !tempWord.equals("")) {
        		sentences.add(tempSentence+tempWord);
        	}
            return;
        }
        
        char current = string.charAt(index);
        
        if (dictionary.contains(tempWord)) {//先前的word已经存在于字典中
            String next = new String(tempSentence);
            if ( !(tempSentence.length() == 0)){
                next = next + " ";
            }
            next = next + tempWord;
            dfs(next, String.valueOf(current), index+1);
        }
        
        tempWord = tempWord + current;
        
        if (dictionary.contains(tempWord)) {//加空格
            String next = new String(tempSentence);
            if (!(tempSentence.length() == 0)){
                next = next + " ";
            }
            next = next + tempWord;
            dfs(next, new String(""), index+1);
        } else {//不加空格
            String next = new String(tempSentence);
            dfs(next, tempWord, index+1);
        }
    }
   
    

}
