package com.example;

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
		sort4(myDatas);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas, "冒泡排序");

		System.out.print(sdf.format(new Date())+"\n");
		sort3(myDatas);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas, "插入排序");
		
		System.out.print(sdf.format(new Date())+"\n");
		sort2(myDatas,0,myDatas.length-1);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas,"快速排序");
	
		System.out.print(sdf.format(System.currentTimeMillis())+"\n");
		sort1(myDatas);
		System.out.print(sdf.format(new Date())+"\n");
		pirnt(myDatas,"选择排序");
	}

	/**
	 * 冒泡排序
	 * @param datas
	 */
	public static void sort4(int[] datas){
		int temp;
		for(int i=0;i<datas.length;i++){
			for(int j=i+1;j<datas.length;j++){
				if(datas[i]>datas[j]){
					temp=datas[i];
					datas[i]=datas[j];
					datas[j]=temp;
				}
			}
		}
	}

	/**
	 * 插入排序  工作原理:通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
	 * @param datas
	 */
	public static void sort3(int[] datas){
		int temp;
		for(int i=1;i<datas.length;i++){
			for (int j=0;j<i;j++){
				if(datas[i]<datas[j]){
					temp=datas[i];
					//把datas[i]放在datas[j]所在位置,所以把i到j之间到数往后挪一位
					for(int k=i;k>=j;k--){
						if (k<1)break;
						datas[i]=datas[i-1];
					}
					datas[j]=temp;
				}
			}
		}
	}

	//快速排序
	public static void sort2(int[] datas,int s,int e){
		if(s<e){
			int left=s;//下次递归的最小坐标值；
			int right=e;//下次递归的最大坐标值
			//取一个参考值；
			int provit=datas[s];
			//把myDatas分开成左右两个部分；
			while(left<right){
				//在右边找出小于provit的值，并放到provit的左边
				while(left<right&&datas[right]>provit){
					right--;
				}
				datas[left]=datas[right];
				//在左边找出一个大于provit的值，并放到provit的右边
				while(left<right&&datas[left]<=provit){
					left++;
				}
				datas[right]=datas[left];
			}
			//把参考值放在坐标left=right的坐标点上
			datas[left]=provit;//此时坐标值left=right
			//递归排序provit左边数；
			sort2(datas,s,left-1);
			//递归排序provit右边数；
			sort2(datas,left+1,e);
		}
		
	}

	//选择排序 工作原理:首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。以此类推，直到所有元素均排序完毕
	public static void sort1(int[] datas){
		int j=0;
		for (int i=0; i < datas.length; i++) {
			for (int k = i; k < datas.length; k++) {
				if(datas[i]>datas[k]){
					j=datas[k];
					datas[k]=datas[i];
					datas[i]=j;
				}
			}
		}
	}

	public static void initDatas(int[] datas,int n){
		for (int i=0;i<n;i++) {
			datas[i]=random.nextInt(n);
		}
	}
	
	public static void pirnt(int[] in ,String str){
		System.out.print(str + ":\n");
		for (int i : in) {
			System.out.print(i+",");
		}
		System.out.println("\n");
	}
	
}
