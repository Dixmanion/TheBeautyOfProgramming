package nju.edu.cn.leetcode;

public class ZigZag {

	
	public String convert(String s, int nRows) {
        if (s.length() <= nRows || nRows == 1) return s;
        
        StringBuffer[] results = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) {
            results[i] = new StringBuffer();
        }
        
        int loopLength = 2 * nRows - 2;
        
        for (int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	int position = getPosition(i, loopLength, nRows);
        	results[position].append(temp);
        }
        StringBuffer zigzag = new StringBuffer();
        for (StringBuffer string : results) {
            zigzag.append(string);
        }
        return zigzag.toString();
    }
	/**
	 * 返回需要添加字符的StringBuffer的位置
	 * @param i
	 * @param loopLength
	 * @param nRows
	 * @return
	 */
	private int getPosition(int i, int loopLength, int nRows) {
		int index = i % loopLength;
		
		if (index < nRows) {
			return index;
		} else {
			return (nRows-1)*2 - index;
		}
	}

}
