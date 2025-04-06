class Solution {
    public List<Integer> largestDivisibleSubset(int[] v) {
        
        //first of all we will sort the input array so that we will have to check only one conition i.e v[i]%v[j] such that i>j.
        Arrays.sort(v);
        int n=v.length;
        int [] dp=new int[n];
        
        //we will initialize the dp array with 1, because there is always a possible set with a single element.
        Arrays.fill(dp,1);
        
        //this step is pretty simple, it is almost exactly as same as Longest Increasing Sequence.
        for(int i=0;i<n;i++)
        {
            
            // for every v[i] we will check every v[j] before it and if it satisfies our condition i.e v[i]%v[j], we will update our dp[i].
            for(int j=0;j<i;j++)
            {
                if(v[i]%v[j]==0)
                {
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        
        //this step is just for finding the end position(max(dp[i])) of the required set and the size of that set.
        int ind=0;
        int m=0;
        
        for(int i=0;i<n;i++)
        {
            if(m<dp[i])
            {
                m=dp[i];
                ind=i;
            }
        }
        
        
        //Now we need m elements in our ans list, obviously the element  v[ind] will be our first element.
        
        List<Integer> ans=new ArrayList();
        ans.add(v[ind]);
        
        int last=v[ind];
        int left=m-1;
        ind--;
        //last is actually the last inserted element in the ans list.Because we have sorted the array in ascending order, the next coming           element should divide last inserted one.(we are iterating the array in reverse order) and dp[i] at that position should be equal to         left
        
        
        // Now we need m-1 more elements so we iterate the array from ind-1 and whenever we find and index with dp[i]=left and the last inserted element , last is divisible by v[i] we will insert v[i] into ans list and update last element and elements left to be inserted.
        for(int i=ind;i>=0;i--)
        {
            if(left==0)break;
            if(dp[i]==left&&last%v[i]==0)
            {
                ans.add(v[i]);
                last=v[i];
                left--;
            }
        }
        return ans;
    }
}