#include <bits/stdc++.h>

using namespace std;

class RangeSumMatrix {
      public:
	RangeSumMatrix(vector<vector<int>> &matrix) {
		R = (int)matrix.size(), C = (int)matrix[0].size();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i > 0) matrix[i][j] += matrix[i - 1][j];
				if (j > 0) matrix[i][j] += matrix[i][j - 1];
				if (i > 0 && j > 0)
					matrix[i][j] -= matrix[i - 1][j - 1];
			}
		}

		sum = matrix;
	}

	int total(int r0, int c0, int r1, int c1) {
		return sum[r1][c1] - (r0 > 0 ? sum[r0 - 1][c1] : 0) -
		       (c0 > 0 ? sum[r1][c0 - 1] : 0) +
		       (r0 > 0 && c0 > 0 ? sum[r0 - 1][c0 - 1] : 0);
	}

      private:
	vector<vector<int>> sum;
	int R, C;
};