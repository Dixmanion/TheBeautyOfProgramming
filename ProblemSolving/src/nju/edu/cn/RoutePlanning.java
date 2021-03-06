package nju.edu.cn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * POJ：http://poj.org/problem?id=3394
 * 思路：用dfs遍历所有路径，记录下最短的
 * @author eureka
 *
 */
public class RoutePlanning {
	
	ArrayList<Integer>[] graph;
	ArrayList<Integer>[] weights;
	ArrayList<Integer> middleSpots;
	int spotsNum;
	int routeNum;
	
	int lengthOfRoute;
	int startSpot;
	int endSpot;

	
	@SuppressWarnings("unchecked")
	void processInput(){
		try {
			Scanner scanner =  new Scanner(new File("input/RoutePlanning.txt"));
			spotsNum = scanner.nextInt();
			routeNum = scanner.nextInt();
			
			graph = new ArrayList[spotsNum + 5];
			weights = new ArrayList[spotsNum + 5];
			
			for (int i = 1; i <= spotsNum; i++) {
				
				graph[i] = new ArrayList<Integer>();
				weights[i] = new ArrayList<Integer>();
				
				int toWeight;
				
				for (int j = 1; j <= spotsNum; j++) {
					toWeight = scanner.nextInt();
					if (toWeight != 0) {
						graph[i].add(j);
						weights[i].add(toWeight);
					}
				}
				
			}
			
			for (int i = 0; i < routeNum; i++) {
				//进行调用
				middleSpots = new ArrayList<Integer>();
				String temp = scanner.nextLine();
				while (temp == null || temp.isEmpty() || temp =="") {
					temp = scanner.nextLine();
					
				}
				String[] routes = temp.split(" ");
				for (int j = 0; j < routes.length; j++) {
					if (j == 0) {
						startSpot = Integer.parseInt(routes[j]);
					}else if (j == routes.length-1) {
						endSpot = Integer.parseInt(routes[j]);
					}else{
						middleSpots.add(Integer.parseInt(routes[j]));
					}
					
				}
				process();
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	void process(){
		lengthOfRoute = 0;
		dfs(startSpot, 0);
		System.out.println(lengthOfRoute);
	}
	
	/**
	 * @param x 最新被添加进路径的点
	 * @param length 目前为止路径的长度
	 */
	void dfs(int x, int length){
		//结束条件
		if (middleSpots.isEmpty() && graph[x].contains(endSpot)) {
			if (lengthOfRoute == 0) {
				lengthOfRoute = length + weights[x].get(graph[x].indexOf(endSpot));
			}else if (length + weights[x].get(graph[x].indexOf(endSpot)) < lengthOfRoute){
				lengthOfRoute = length + weights[x].get(graph[x].indexOf(endSpot));
			}
			
		}
		
		for (int i = 0; i < middleSpots.size(); i++) {
			
			int next = middleSpots.get(i);
			if (graph[x].contains(next)) {
				int indexOfNext = graph[x].indexOf(next);
				middleSpots.remove(i);
				
				dfs(next, length + weights[x].get(indexOfNext));
				
				//RESET
				middleSpots.add(i, next);
			}
		}
	}

	public static void main(String[] args) {
		RoutePlanning routePlanning = new RoutePlanning();
		routePlanning.processInput();
	}

}
