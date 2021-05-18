package robertcinciuc.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MergeSort {

    public ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int l, int r){

        if(r - l >= 1){

            int m = (int)(r-l)/2 + l;
            ArrayList<Integer> left = this.mergeSort(arr, l, m);
            ArrayList<Integer> right = this.mergeSort(arr, m+1, r);
            ArrayList<Integer> res = this.merge(left, right);
            return res;

        }else{

            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(arr.get(l));
            return res;
        }
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){

        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while( i < left.size() && j < right.size()){

            if(left.get(i) < right.get(j)){

                res.add(left.get(i));
                i += 1;

            }else{

                res.add(right.get(j));
                j += 1;
            }
        }

        if( i < left.size()){
            for(int ii = i; ii < left.size(); ++ii){
                res.add(left.get(ii));
            }
        }else if( j < right.size()){
            for(int jj = j; jj < right.size(); ++jj){
                res.add(right.get(jj));
            }
        }

        return res;
    }
}
