class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<int>adj[n];
        for(int i=0;i<roads.size();i++){
            adj[roads[i][0]].push_back(roads[i][1]);
            adj[roads[i][1]].push_back(roads[i][0]);
        }
        priority_queue<pair<int,int>>pq;
        for(int i=0;i<n;i++){
            int c=0;
            for(auto it:adj[i]){
                c++;
            }
            cout<<i<<"  "<<c<<endl;
            pq.push({c,i});
        }
        int c=n;
        map<int,int>m;
        while(!pq.empty()){
            pair<int,int>p=pq.top();
            m[p.second]=n;
//            cout<<p.second<<"  "<<n<<endl;
            n--;
            pq.pop();
        }
        long long sum=0;
        for(int i=0;i<roads.size();i++){
            sum+=m[roads[i][0]]+m[roads[i][1]];
        }
        return sum;
    }
};