#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	cout << "The largest square has side length " << floor(sqrt(n)) << '.' << '\n';

	return 0;
}