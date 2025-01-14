class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set=new HashSet<>();
        int n=A.length;

        int ans[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
             if(set.contains(A[i])){
                c++;
                set.remove(A[i]);
             }else{
                set.add(A[i]);
             }

             if(set.contains(B[i])){
                c++;
                set.remove(B[i]);
             }else{
                set.add(B[i]);
             }
             ans[i]=c;
        }
     return ans;
    }
}