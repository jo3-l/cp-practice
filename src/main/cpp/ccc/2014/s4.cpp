#include <bits/stdc++.h>

using namespace std;

struct tinted_glass {
	int x1, y1, x2, y2, tint;
};

struct coord_compress {
	coord_compress(vector<int> coords_) : coords(coords_) {
		assign();
	}

	int get_orig(int n) {
		return compressed_to_orig[n];
	}

	int operator[](int n) {
		return orig_to_compressed[n];
	}

	int size() {
		return size_;
	}

private:
	unordered_map<int, int> orig_to_compressed;
	vector<int> compressed_to_orig;
	vector<int> coords;
	int size_;

	void assign() {
		orig_to_compressed.clear();
		compressed_to_orig.resize(coords.size());

		sort(coords.begin(), coords.end());
		auto it = coords.begin();
		int n = 0;
		while (it != coords.end()) {
			orig_to_compressed[*it] = n;
			compressed_to_orig[n] = *it;
			it = find_if_not(it, coords.end(), [&](int x) { return x == *it; });
			n++;
		}
		size_ = n;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, t;
	cin >> n >> t;
	vector<tinted_glass> glass_pieces(n);
	vector<int> x_coords, y_coords;
	x_coords.reserve(n * 2);
	y_coords.reserve(n * 2);
	for (auto& p : glass_pieces) {
		cin >> p.x1 >> p.y1 >> p.x2 >> p.y2 >> p.tint;
		x_coords.push_back(p.x1);
		x_coords.push_back(p.x2);
		y_coords.push_back(p.y1);
		y_coords.push_back(p.y2);
	}
	coord_compress compressed_x(move(x_coords)), compressed_y(move(y_coords));

	vector<vector<int>> diff(compressed_y.size(), vector<int>(compressed_x.size()));
	for (auto& p : glass_pieces) {
		for (int y = compressed_y[p.y1]; y < compressed_y[p.y2]; y++) {
			diff[y][compressed_x[p.x1]] += p.tint;
			diff[y][compressed_x[p.x2]] -= p.tint;
		}
	}

	int64_t total_area = 0;
	for (int y = 0; y < compressed_y.size() - 1; y++) {
		int64_t height = compressed_y.get_orig(y + 1) - compressed_y.get_orig(y);
		int tint = 0;
		for (int x = 0; x < compressed_x.size() - 1; x++) {
			tint += diff[y][x];
			int64_t width = compressed_x.get_orig(x + 1) - compressed_x.get_orig(x);
			if (tint >= t) total_area += height * width;
		}
	}
	cout << total_area << '\n';
}