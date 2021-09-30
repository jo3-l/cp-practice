#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n'

using namespace std;

template <typename T> ostream &operator<<(ostream &out, const vector<T> &vec) {
	out << '[';
	for (int i = 0; i < vec.size(); i++) {
		if (i > 0) out << ", ";
		out << vec[i];
	}
	return out << ']';
}

template <typename T> ostream &operator<<(ostream &out, const priority_queue<T> pq) {
	out << '{';
	while (!pq.empty()) {
		out << pq.top();
		pq.pop();
		if (!pq.empty()) out << ", ";
	}
	return out << '}';
}

template <typename T> ostream &operator<<(ostream &out, const queue<T> q) {
	out << '{';
	while (!q.empty()) {
		out << q.top();
		q.pop();
		if (!q.empty()) out << ", ";
	}
	return out << '}';
}

template <typename T> ostream &operator<<(ostream &out, const stack<T> s) {
	out << '{';
	while (!s.empty()) {
		out << s.top();
		s.pop();
		if (!s.empty()) out << ", ";
	}
	return out << '}';
}

template <typename T> ostream &operator<<(ostream &out, const deque<T> &dq) {
	out << '[';
	for (int i = 0; i < dq.size(); i++) {
		if (i > 0) out << ", ";
		out << dq[i];
	}
	return out << ']';
}

template <typename K, typename V> ostream &operator<<(ostream &out, const unordered_map<K, V> &mp) {
	out << '{';
	for (auto it = mp.begin(); it != mp.end(); it++) {
		if (it != mp.begin()) out << ", ";
		out << it->first << ": " << it->second;
	}
	return out << '}';
}

template <typename K, typename V> ostream &operator<<(ostream &out, const map<K, V> &mp) {
	out << '{';
	for (auto it = mp.begin(); it != mp.end(); it++) {
		if (it != mp.begin()) out << ", ";
		out << it->first << ": " << it->second;
	}
	return out << '}';
}

template <typename T> ostream &operator<<(ostream &out, const unordered_set<T> &s) {
	out << '{';
	for (auto it = s.begin(); it != s.end(); it++) {
		if (it != s.begin()) out << ", ";
		out << *it;
	}
	return out << '}';
}

template <typename T> ostream &operator<<(ostream &out, const set<T> &s) {
	out << '{';
	for (auto it = s.begin(); it != s.end(); it++) {
		if (it != s.begin()) out << ", ";
		out << *it;
	}
	return out << '}';
}

template <typename T0, typename T1> ostream &operator<<(ostream &out, const pair<T0, T1> p) {
	return out << '{' << p.first << ", " << p.second << '}';
}

template <typename T0, typename T1> struct PairHash {
	size_t operator()(const pair<T0, T1> p) const {
		size_t h0 = hash<T0>{}(p.first), h1 = hash<T1>{}(p.second);
		return 3 * (h0 ^ (h0 >> 2)) + (h1 ^ (h1 >> 3));
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	return 0;
}