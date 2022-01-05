#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace std;
using namespace __gnu_pbds;

template <class K, class Cmp = less<K>> using ordered_set = tree<K, null_type, Cmp, rb_tree_tag, tree_order_statistics_node_update>;
template <class K, class V, class Cmp = less<K>> using ordered_map = tree<K, V, Cmp, rb_tree_tag, tree_order_statistics_node_update>;

template <class K, class V, class Hash> using hash_table = gp_hash_table<K, V, Hash>;
template <class K, class Hash> using hash_set = gp_hash_table<K, null_type, Hash>;
