class Solution {
public:
    int ans=0;
    int countDepth(long long n){
        if(n <= 1)
            return 0;
        

        int numberOfSetBit=0;
        while(n){
            n=n & (n-1);
            numberOfSetBit++;
        }
        return 1+countDepth(numberOfSetBit);  

    }
    void solve(int i, long long n, int k, long long  value, int setBit){
        if (value == 15)
        cout<<value<<"v"<<endl;
        if (value > n)
            return ;
        if(i> 63)
            return ;    
        if( countDepth(value)== k){
          cout<< value<<endl;
            if(value ==1) return;
            ans++;
            return;
        }
        
        solve(i+1, n, k, value, setBit);
        solve(i+1, n, k, value+(1LL << i), setBit+1);
        return ;
    }
    long long popcountDepth(long long n, int k) {
        if(n == 1 && k ==0) return 1;
        cout<<countDepth(15);
        solve(0, n , k, 0, 0);
        return ans;
    }
};