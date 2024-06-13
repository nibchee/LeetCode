class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        wordList.push_back(beginWord);
        int n=wordList.size();
        unordered_map<string,vector<string>>m;

       for (int i = 0; i < n; i++) {
            string a = wordList[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    string b = wordList[j];
                    if (a.size() == b.size()) {
                        int len = a.size();
                        int c = 0;
                        for (int k = 0; k < len; k++) {
                            if (a[k] != b[k]) {
                                c++;
                            }
                        }
                        if (c == 1) {
                            m[a].push_back(b);
                        }
                    }
                }
            }
        }
            
        //   for(int i=0;i<n;i++){
        //         string a=wordList[i];cout<<a<<"     ";
        //         for(auto j:m[a]){
        //             cout<<j<<" ";
        //         }
        //         cout<<" "<<endl;
        //     }


        set<string>s(wordList.begin(),wordList.end());
            queue<pair<int,string>>q;
            q.push({1,beginWord});
            s.insert(beginWord);

        while (!q.empty()) {
            pair<int, string> p = q.front();
            q.pop();
            string r = p.second;
            int level = p.first;

            if (r == endWord) {
                return level;
            }

            for (const string& neighbor : m[r]) {
                if (s.find(neighbor) != s.end()) {
                    q.push({level + 1, neighbor});
                    s.erase(neighbor); 
                }
            }
        }

        return 0;
    }
};

  