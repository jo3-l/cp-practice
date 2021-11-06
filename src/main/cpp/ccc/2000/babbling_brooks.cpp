#include <bits/stdc++.h>

using namespace std;

float streams[200];
int stream_count;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> stream_count;
	for (int i = 0; i < stream_count; i++) {
		int n;
		cin >> n;
		streams[i] = n;
	}

	int t;
	for (cin >> t; t != 77; cin >> t) {
		if (t == 99) {
			int n, p;
			cin >> n >> p;
			n--;
			memmove(streams + n + 2, streams + n + 1, (stream_count - n - 1) * sizeof(float));
			float orig = streams[n];
			streams[n] = streams[n] * p / 100;
			streams[n + 1] = orig - streams[n];
			stream_count++;
		} else {
			int n;
			cin >> n;
			n--;
			streams[n] += streams[n + 1];
			memmove(streams + n + 1, streams + n + 2, (stream_count - n - 2) * sizeof(float));
			stream_count--;
		}
	}

	for (int i = 0; i < stream_count; i++) {
		if (i > 0) cout << ' ';
		cout << (int)round(streams[i]);
	}
	cout << '\n';
	return 0;
}