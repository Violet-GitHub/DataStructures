package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestData3 {
	public static int[] myDatas;
	public static Random random=new Random();
	public static int myN=0;
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		myN=5000;
		myDatas=new int[myN];
		initDatas(myDatas,myN);
		
		System.out.print(sdf.format(new Date())+"\n");
		sort2(myDatas,0,myDatas.length-1);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas);
	
		System.out.print(sdf.format(System.currentTimeMillis())+"\n");
		sort1(myDatas);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas);
	}
	
	public static void initDatas(int[] datas,int n){
		for (int i=0;i<n;i++) {
			datas[i]=random.nextInt(n);
		}
	}
	
	public static void sort2(int[] myDatas,int s,int e){
		if(s<e){
			int left=s;//下次递归的最小坐标值；
			int right=e;//下次递归的最大坐标值
			//取一个参考值；
			int provit=myDatas[s];
			//把myDatas分开成左右两个部分；
			while(left<right){
				//在右边找出小于provit的值，并放到provit的左边
				while(left<right&&myDatas[right]>provit){
					right--;
				}
				myDatas[left]=myDatas[right];
				//在左边找出一个大于provit的值，并放到provit的右边
				while(left<right&&myDatas[left]<=provit){
					left++;
				}
				myDatas[right]=myDatas[left];
			}
			//把参考值放在坐标left=right的坐标点上
			myDatas[left]=provit;//此时坐标值left=right
			//递归排序provit左边数；
			sort2(myDatas,s,left-1);
			//递归排序provit右边数；
			sort2(myDatas,left+1,e);
		}
		
	}
	
	public static void sort1(int[] datas){
		int j=0;
		for (int i=0; i < datas.length; i++) {
			for (int k = 0; k < datas.length; k++) {
				if(datas[i]>datas[k]){
					j=datas[k];
					datas[k]=datas[i];
					datas[i]=j;
				}
			}
		}
	}
	
	public static void pirnt(int[] in){
		for (int i : in) {
			System.out.print(i+",");
		}
		System.out.println("\n");
	}
	
}
