#include <bits/stdc++.h>

using namespace std;

constexpr int SECOND_WINS = 1 << 0, FIRST_WINS = 1 << 1;

constexpr int MP = 31;
int dp[MP][MP][MP][MP];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int a = 0; a < MP; a++) {
		for (int b = 0; b < MP; b++) {
			for (int c = 0; c < MP; c++) {
				for (int d = 0; d < MP; d++) {
					auto apply = [&](int da, int db, int dc, int dd) {
						if (a >= da && b >= db && c >= dc && d >= dd)
							dp[a][b][c][d] |= ~dp[a - da][b - db][c - dc][d - dd];
					};

					apply(2, 1, 0, 2);
					apply(1, 1, 1, 1);
					apply(0, 0, 2, 1);
					apply(0, 3, 0, 0);
					apply(1, 0, 0, 1);
					if (!dp[a][b][c][d]) dp[a][b][c][d] = SECOND_WINS;
				}
			}
		}
	}

	int n;
	cin >> n;
	while (n--) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		cout << (dp[a][b][c][d] == SECOND_WINS ? "Roland" : "Patrick") << '\n';
	}

	return 0;
}
