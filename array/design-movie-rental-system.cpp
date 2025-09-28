#include <bits/stdc++.h>
using namespace std;

class MovieRentingSystem {
    // available[movie] = set of (price, shop)
    unordered_map<int, set<pair<int,int>>> available;
    // rented = set of (price, shop, movie) ordered lexicographically -> price, shop, movie
    set<tuple<int,int,int>> rented;
    // price lookup: pack (shop, movie) into 64-bit key -> price
    unordered_map<long long,int> priceOf;

    static long long keyOf(int shop, int movie) {
        return ( (long long)shop << 32 ) | (unsigned long long)movie;
    }

public:
    MovieRentingSystem(int n, vector<vector<int>>& entries) {
        for (auto &e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            available[movie].insert({price, shop});
            priceOf[keyOf(shop, movie)] = price;
        }
    }

    vector<int> search(int movie) {
        vector<int> res;
        auto it = available.find(movie);
        if (it == available.end()) return res;
        int c = 0;
        for (auto itr = it->second.begin(); itr != it->second.end() && c < 5; ++itr, ++c) {
            res.push_back(itr->second); // itr->second is shop
        }
        return res;
    }

    void rent(int shop, int movie) {
        long long k = keyOf(shop, movie);
        int price = priceOf[k];
        // remove from available
        auto it = available.find(movie);
        if (it != available.end()) {
            it->second.erase({price, shop});
            // if set becomes empty we may optionally erase the key to save memory:
            if (it->second.empty()) available.erase(it);
        }
        // insert into rented
        rented.insert({price, shop, movie});
    }

    void drop(int shop, int movie) {
        long long k = keyOf(shop, movie);
        int price = priceOf[k];
        // remove from rented
        rented.erase({price, shop, movie});
        // add back to available
        available[movie].insert({price, shop});
    }

    vector<vector<int>> report() {
        vector<vector<int>> ans;
        int c = 0;
        for (auto it = rented.begin(); it != rented.end() && c < 5; ++it, ++c) {
            int price, shop, movie;
            tie(price, shop, movie) = *it;
            ans.push_back({shop, movie});
        }
        return ans;
    }
};
