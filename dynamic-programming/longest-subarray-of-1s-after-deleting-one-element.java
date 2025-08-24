class Solution {
    public int longestSubarray(int[] a) {
   int i=0;
   int j=0;
   int s=0;
   int ms=0;
   int  c=0;
   int n=a.length;
   while(i<n && j<n){
         s+=a[j];
         ms=Math.max(ms,s);
         if(a[j]==0)
         c++;

        if(c>1){
         while(c>1){
             s-=a[i];
             if(a[i]==0)
             c--;
             i++;
         }
        }
         j++;
   }

   if(ms==n)
   ms=n-1;
return ms;
}
}