#include <bits/stdc++.h>

using namespace std;

struct Query {
	char typ;
	int arg0, arg1;
};

unordered_map<int, int> compress;

int max_compressed_rating;
int bit[int(1e6) + 5];

int query(int i) {
	int ans = 0;
	for (i++; i > 0; i -= i & -i) ans += bit[i];
	return ans;
}

void incr(int i, int addend) {
	for (i++; i <= max_compressed_rating; i += i & -i) bit[i] += addend;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	vector<Query> queries(n);
	vector<int> ratings;
	for (auto& [typ, arg0, arg1] : queries) {
		cin >> typ >> arg0;
		if (typ == 'N' || typ == 'M') {
			cin >> arg1;
			ratings.push_back(arg1);
		}
	}
	sort(ratings.begin(), ratings.end(), greater<>{});
	max_compressed_rating = int(ratings.size());
	for (int i = 0; i < ratings.size(); i++) compress[ratings[i]] = i;

	unordered_map<int, int> person_to_score;
	unordered_map<int, int> score_to_person;
	for (auto [typ, arg0, arg1] : queries) {
		if (typ == 'N') {
			int person = arg0, rating = compress.at(arg1);
			person_to_score[person] = rating;
			score_to_person[rating] = person;
			incr(rating, 1);
		} else if (typ == 'M') {
			int person = arg0;
			int new_rating = compress.at(arg1);
			int old_rating = person_to_score.at(person);
			incr(old_rating, -1);
			incr(new_rating, 1);
			person_to_score[person] = new_rating;
			score_to_person.erase(old_rating);
			score_to_person[new_rating] = person;
		} else {
			assert(typ == 'Q');
			int k = arg0;
			int lo = 0, hi = max_compressed_rating;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (query(mid) >= k)
					hi = mid;
				else
					lo = mid + 1;
			}
			assert(query(lo) == k);
			cout << score_to_person.at(lo) << '\n';
		}
	}
	return 0;
}
