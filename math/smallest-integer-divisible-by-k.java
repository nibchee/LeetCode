class Solution {
    public int smallestRepunitDivByK(int k) {
     int modk=k%10;
     if(modk==2||modk==4||modk==5||modk==6||modk==8 ||modk%10==0)
     return -1;
     return 1;   
    }
}