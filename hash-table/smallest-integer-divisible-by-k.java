class Solution {
    public int smallestRepunitDivByK(int k) {
     int modk=k%10;
     if(modk==2||modk==4||modk==5||modk==6||modk==8 ||modk%10==0)
     return -1;
     int ans=1;
     int len=1;
     while(ans%k!=0){
      ans=ans*10+1;
      len++;
     }
     return len;   
    }
}