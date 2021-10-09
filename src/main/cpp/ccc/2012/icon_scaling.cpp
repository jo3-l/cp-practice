#include <bits/stdc++.h>

using namespace std;

string icon[]{"*x*", " xx", "* *"};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k;
	cin >> k;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < k; j++) {
			for (int z = 0; z < 3; z++) {
				for (int a = 0; a < k; a++)
					cout << icon[i][z];
			}
			cout << '\n';
		}
	}

	return 0;
}