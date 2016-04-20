package com.example.demo;

public class TestData3 {
	public static int[] datas={4,56,89,2,3,0,9,6,8};
	public static int i=0,j=0;
	public static void main(String[] args) {
		for (; i < datas.length; i++) {
			sort(datas[i]);
		}
		pirnt(datas);
	}
	
	public static void sort(int data){
		for (int k = 0; k < datas.length; k++) {
			if(datas[k]>data){
				j=data;
				data=datas[k];
				datas[k]=data;
			}
			//sort(datas[k++]);
		}
		
	}
	
	public static void pirnt(int[] in){
		for (int i : in) {
			System.out.print(i+",");
		}
	}
	
}
