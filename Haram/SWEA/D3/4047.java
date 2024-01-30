package com.personal.solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.FileInputStream;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d ", t+1);

			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] inputs = st.nextToken().split("");
			
			int[][] cardInfo = new int[4][13];
			
			for(int i = 0; i < inputs.length; i=i+3) {
				int cardNum = Integer.parseInt(inputs[i+1] + inputs[i+2]);
				
				setCardInfo(cardInfo, inputs[i], "S", 0, cardNum);
				setCardInfo(cardInfo, inputs[i], "D", 1, cardNum);
				setCardInfo(cardInfo, inputs[i], "H", 2, cardNum);
				setCardInfo(cardInfo, inputs[i], "C", 3, cardNum);		
			}
			
			boolean flag = false;
			int[] result = new int[4];
			
			for(int i = 0; i < 4; i++) {
				int num = 0;
				for(int j = 0; j < 13; j++) {
					if(cardInfo[i][j] > 1) {						
						flag = true;
					}
					if(cardInfo[i][j] == 0)
						num++;
				}
				result[i] = num;
			}
			
			if(flag) 
				System.out.println("ERROR");
			else {
				for(int i = 0; i < 4; i++)
					System.out.print(result[i] + " ");
				System.out.println();
			}
		}
	}

	private static void setCardInfo(int[][] cardInfo, String inputType, String cardType, int i, int j) {
		if(inputType.equals(cardType)) {
			cardInfo[i][j]++;
		}
	}
}