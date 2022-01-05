# CCC '21 J4 - Arranging Books

**Problem Link:** [DMOJ](https://dmoj.ca/problem/ccc21j4)<br>

## Analysis

We begin by introducing the notion of _sections_. Given a shelf (not necessarily sorted) we will refer to the contiguous subsequence containing books of type $t$ within the sorted shelf as the $t$ section.

For example, consider the following shelf:

```
L L S L M M S L M L L S S L
```

The sorted shelf is as follows:

```
L L L L L L L M M M S S S S
```

We would then say that the large section is

```
L L L L L L L M M M S S S S
^ ^ ^ ^ ^ ^ ^
```

whereas the medium section is

```
L L L L L L L M M M S S S S
              ^ ^ ^
```

and likewise for the small section.

The boundaries of sections can be computed based off the number of books of the type. Let $C(T)$ be the count of books of type $T$, i.e., $C(L)$ is the number of large books. Observe that in the sorted shelf, there must be $C(L)$ large books, then $C(M)$ medium books, then $C(S)$ small books. It follows that

- The large book section is $[0, C(L))$,
- The medium book section is $[C(L), C(L) + C(M))$
- The small book section is $[C(L) + C(M), C(L) + C(M) + C(S))$.

---

Now we return to the original task.

For convenience we break down the action of sorting the shelf into two steps:

1. Swap all the large books not in the large section into the large section.
2. Swap all the medium-sized books not in the medium section into the medium section.

At the end of this sequence of steps all large books are in their correct positions, as are all medium books. Thus all small books are correctly placed and it is not necessary to consider them separately.

The question now reduces to counting the optimal number of swaps needed for both steps. We consider each one separately.

**Step One**

Consider an arbitrary large book in the wrong section. Without loss of generality, say it is in the small section. It is clear that to get closer to our goal of sorting all large books, we need to swap this book with one in the large section.

Now, say that we have a choice between swapping this large book with a small book in the large section _or_ a medium book in the large section. Observe that in this case it is locally optimal to always choose to swap our large book in the small section with a small book in the large section, as that gets both the large and small book in their corresponding sections. (Had we opted to swap the large book with a medium one, the medium book would be in the small section, i.e., not in the right section.)

This observation motivates a greedy approach where we attempt to make as many swaps that **get both books involved to their proper sections** as possible, then make as many swaps that **get only the large book to the large section** as necessary to sort all large books.

How many swaps are required for this in total? Let $F(A, B)$ be the number of $A$-type books in the $B$ section, i.e., $F(L, S)$ corresponds to the number of large books in the small section.

The number of swaps that get both books to their proper section can be further split into two types: those involving large books in the small section & small books in the large section, and those involving large books in the medium section & medium books in the large section. The number of such swaps is then the total of these two, which is

$$
\min(F(L, S), F(S, L)) + \min(F(L, M), F(M, L))
$$

The number of remaining swaps is simply the total number of misplaced large books excluding the above:

$$
F(L, S) + F(L, M) - \min(F(L, S), F(S, L)) - \min(F(L, M), F(M, L))
$$

In fact, looking at the above, the number of swaps needed to sort the large section is just

$$
F(L, S) + F(L, M)
$$

**Step Two**

Similar logic applies for sorting the medium section. We omit intermediary steps for brevity and only give the final number of swaps, which is

$$
F(M, L) + F(M, S) - \min(F(L, M), F(M, L))
$$

---

The total number of swaps required is thus

$$
F(L, S) + F(L, M) + F(M, L) + F(M, S) - \min(F(L, M), F(M, L))
$$

## Implementation (C++)

```cpp
#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string shelf;
    cin >> shelf;
    int l_cnt = count(shelf.begin(), shelf.end(), 'L'),
        m_cnt = count(shelf.begin(), shelf.end(), 'M');

    int l_in_m = 0, l_in_s = 0, m_in_l = 0, m_in_s = 0;
    for (int i = 0; i < shelf.size(); i++) {
        if (i < l_cnt) {
            if (shelf[i] == 'M') m_in_l++;
        } else if (i < l_cnt + m_cnt) {
            if (shelf[i] == 'L') l_in_m++;
        } else {
            if (shelf[i] == 'L') l_in_s++;
            else if (shelf[i] == 'M') m_in_s++;
        }
    }
    cout << l_in_s + l_in_m + m_in_l + m_in_s - min(l_in_m, m_in_l) << '\n';
    return 0;
}
```

## Time Complexity

$\mathcal{O}(N)$ where $N$ is the length of the shelf.

## Space Complexity

$\mathcal{O}(N)$ where $N$ is the length of the shelf.
