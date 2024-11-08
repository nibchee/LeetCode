class Solution { 
public: 
    int req=0; 
    void solve(int i, vector<int>& candidates, int mask, int ans){ 
        if(i>=candidates.size()){ 
            if(mask>0){ 
                req=max(req, ans); 
            }  
            return; 
        } 
        solve(i+1, candidates, mask, ans); 
        mask = mask & candidates[i]; 
        solve(i+1, candidates , mask, ans+1); 
    } 
    int largestCombination(vector<int>& candidates) { 
      //  int mask =1; 
         
        solve(0, candidates, ~0, 0); 
        return req; 
    } 
};