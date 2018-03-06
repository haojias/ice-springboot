package xin.haojias.ice.other;

import java.util.Arrays;

public class demo {

    public static void main(String[] args){
        int[] a={0,2,5,3,1,6,9,3};
        mp(a);
        int s=ef(a,3);
        System.out.println(s);
    }

    //冒泡排序
    static void mp(int a[]){
        int swap=0;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                if (a[j]>a[i]){
                    swap=a[i];
                    a[i]=a[j];
                    a[j]=swap;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    //二分查找
    static int ef(int[] a,int tag){
        int first=0;
        int end=a.length;
        for (int i=0;i<a.length;i++){
            int middle=(first+end)/2;
            if (tag==a[middle]){
                return middle;
            }
            if (tag>a[middle]){
                first=  middle+1;
            }
            if (tag<a[middle]){
                end=  middle-1;
            }

        }
        return 0;
    }

}
