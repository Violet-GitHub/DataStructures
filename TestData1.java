package com.example;

import java.util.ArrayList;

public class TestData1 {
    public ArrayList<Integer> list=new ArrayList<Integer>();;
    public static int n=20;
    public static int m=21;

    public static void main(String[] args){
        TestData1 td=new TestData1();

        for (int j=n;j>0;j--){
            td.test(j,m);
            td.list.clear();
        }

    }

    public  void test(int n,int m){
        //求1到n之间到任意数字之和=m,需判断n和m的取值范围;
        if(n<2||m<3||m<=n){
            return;
        }
        int m1=m-n;
        //n<=m1具有去重作用,例如(1,9和9,1)和(9,9) ,同时可以确保m1的取值在n的范围内;
        if(n<=m1){
            return;
        }

        list.add(m1);
        toPrintList(list);
        toPrintInt(n);
        toPrintN();

        int nn=m1+1;
        test(n - nn, n);
    }

    public void toPrintList(ArrayList<Integer> li){
        for (Integer in:li){
            toPrintInt(in);
        }
    }

    public void toPrintInt(int in){
        System.out.print(in+" ");
    }

    public void toPrintN(){
        System.out.print("\n");
    }

}
