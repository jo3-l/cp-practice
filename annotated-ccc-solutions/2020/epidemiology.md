# CCC '20 J2 - Epidemiology

**Problem Link:** [DMOJ](https://dmoj.ca/problem/ccc20j2)

## Foreward

We will not cover the (relatively) trivial solution to this problem. Instead, we discuss a much more performant algorithm for this problem. Of course, given that it is a J2 problem, this approach is **not at all necessary for obtaining full marks.**

## Analysis

Define $F(k)$ as the number of people infected on the $k^{th}$ day. As the number of people infected form a geometric series with start term $N$ and common ratio $R$, we can use the formula for the sum of a geometric series:

$$
F(k) = N \frac{1 - R^{k + 1}}{1 - R}
$$

> **Note:** This only works if $R \ne 1$ due to division-by-zero problems. We special-case the $R = 1$ case to handle this.

$R^{k + 1}$ can be computed in $\log k$ time using [binary exponentation](https://cp-algorithms.com/algebra/binary-exp.html) (and thus $F(k)$ can be computed for arbitrary $k$ in logarthmic time).

Now that we know how to compute $F(k)$ fast we can get to solving the actual problem. We are looking for the first $k$ where $F(k) \gt P$. This can be done using binary search (more precisely, a variant of binary search known as [exponential search](https://en.wikipedia.org/wiki/Exponential_search).)

> **Note:** As we have a closed-form equation for $F(k)$ we can actually solve the inequality directly, but as the result requires logarithms it is not very performant (nor practical, due to precision issues) in practice.

## Implementation (C++)

```cpp
#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int p, n, r;

ll binpow(ll x, int d) {
	ll ans = 1;
	for (; d > 0; x *= x, d >>= 1) {
		if (d & 1) ans *= x;
	}
	return ans;
}

ll f(int k) {
	return (binpow(r, k + 1) - 1) / (r - 1) * n;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin >> p >> n >> r;

	if (r == 1) {
		// handle r = 1 separately to avoid division by zero
		cout << p / n << '\n';
		return 0;
	}
	int lo = 0, hi = 1;
	while (f(hi) <= p) hi <<= 1;
	while (lo < hi) {
		int mid = (lo + hi) >> 1;
		if (f(mid) > p) hi = mid;
		else lo = mid + 1;
	}
	cout << lo << '\n';
	return 0;
}
```

## Time Complexity

A tighter bound may be found but $\mathcal{O}(\log^2 P)$ is a fairly good estimate.

## Space Complexity

$\mathcal{O}(1)$.
