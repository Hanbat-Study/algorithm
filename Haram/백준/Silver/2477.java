package com.personal.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] inputs = new int[6];
		
		int ridx = 0;
		int cidx = 0;
		
		int r = 0;
		int c = 0;
		
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if(d == 3 || d == 4) {
				if(r < l) {
					r = l;
					ridx = i;
				}
			}
			
			if(d == 1 || d == 2) {
				if(c < l) {
					c = l;
					cidx = i;
				}
			}
			
			inputs[i] = l;
		}
		
		int a = (ridx + 4) % 6;
		int b = (cidx + 8) % 6;

		System.out.println(K * (r * c - inputs[a] * inputs[b]));
	}
}