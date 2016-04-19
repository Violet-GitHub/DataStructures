package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

public class TestData2 {
	private static int n;
	private static int[] alist;
	private static int[] blist;
	private static Random random=new Random();
	private ArrayList<Integer> aIndex=new ArrayList<>();
	
	public static void main(String[] args) {
		TestData2 td=new TestData2();
		n=8;
		alist=new int[n];
		blist=new int[n];
		td.initAList(n);
		//td.printInt(alist);
		
		td.initBList();
		td.printInt(blist);
	}
	
	public void initBList() {
		for(int i=0;i<alist.length;i++){
			if(alist[i]==0){
				blist[i]=alist.length-4;
			}else if(alist[i]==1){
				blist[i]=2;
			}else if(alist[i]==2){
				blist[i]=1;
			}else if(alist[i]==alist.length-4){
				blist[i]=1;
			}else{
				blist[i]=0;
			}
		}
	}

	public void initAList(int n) {
		int j,k;
		while(true){
			j=random.nextInt(n);
			if(aIndex.size()<n&&!aIndex.contains(j)){
				aIndex.add(j);
			}else if(aIndex.size()>=n){
				break;
			}
		}
		printList(aIndex);
		alist[aIndex.get(0)]=0;
		alist[aIndex.get(1)]=n-4;
		alist[aIndex.get(2)]=1;
		alist[aIndex.get(3)]=2;
		for (int i = 4; i < aIndex.size(); i++) {
			while(true){
				k=random.nextInt(n);
				if(k!=0&&k!=n-4&&k!=1&&k!=2){
					alist[aIndex.get(i)]=k;
					break;
				}
			}
		}
		printInt(alist);
	}
	
	public void printInt(int[] list) {
		for (Integer in : list) {
			System.out.print(in+",");
		}
		System.out.print("\n");
	}
	
	public void printList(ArrayList<Integer> list) {
		for (Integer in : list) {
			System.out.print(in+",");
		}
		System.out.print("\n");
	}

}
