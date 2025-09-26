class MovieRentingSystem {
public:
    struct Comparator {
    bool operator()(const pair<int, pair<int,int>>& p1,
                    const pair<int, pair<int,int>>& p2) const {
        if (p1.first == p2.first) {
            if (p1.second.first == p2.second.first)
                return p1.second.second > p2.second.second; // typo fixed
            return p1.second.first > p2.second.first;
        }
        return p1.first > p2.first;
    }
};

    map<int,set<pair<int,int>>>m_movie;
    map<pair<int,int>, int>findPrice;
    map<pair<int,int>, int>rentp;
    priority_queue<pair<int, pair<int,int>>, vector<pair<int, pair<int,int>>>, Comparator>pq;
    MovieRentingSystem(int n, vector<vector<int>>& entries) {
        for(int i=0;i<entries.size();i++){
            m_movie[entries[i][1]].insert({entries[i][2], entries[i][0]});
            findPrice[{entries[i][0], entries[i][1]}] = entries[i][2];
        }
    }
    
    vector<int> search(int movie) {
        vector<int>a;
        int c=0;
        set<pair<int, int>> ans= m_movie[movie];
        for(auto i: ans){
            c++;
            a.push_back(i.second);
            if(c==5)
                break;
        }
        return a;
    }
    
    void rent(int shop, int movie) {
        int price=findPrice[{shop, movie}];
        rentp[{shop, movie}] = price;
        pq.push({price,{shop, movie}});
    }
    
    void drop(int shop, int movie) {
        rentp.erase({shop, movie});
       
    }
    
    vector<vector<int>> report() {
    vector<vector<int>> ans;
    int c = 0;

    while (!pq.empty() && c < 5) {
        pair<int, pair<int,int>> p = pq.top();
        pq.pop();

        // assuming rentp is a map<pair<int,int>, bool>
        if (rentp[p.second]) {
            ans.push_back({p.second.first, p.second.second});
            c++;
        }
    }

    return ans;
}

};

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem* obj = new MovieRentingSystem(n, entries);
 * vector<int> param_1 = obj->search(movie);
 * obj->rent(shop,movie);
 * obj->drop(shop,movie);
 * vector<vector<int>> param_4 = obj->report();
 */