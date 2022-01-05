#include <bits/stdc++.h>

using namespace std;
using ull = unsigned long long;

struct chash {
	ull operator()(ull x) const {
		// http://xorshift.di.unimi.it/splitmix64.c
		static const int R = chrono::steady_clock::now().time_since_epoch().count();
		x += 0x9e3779b97f4a7c15;
		x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
		x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
		return x ^ (x >> 31) ^ R;
	}
};