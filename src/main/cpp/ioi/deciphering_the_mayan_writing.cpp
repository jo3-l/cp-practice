#include <bits/stdc++.h>

using namespace std;

const int MW = 3001;
const int MS = 3'000'001;

char w[MW];
char s[MS];

int wfreq[128], sfreq[128];

int main() {
	int wlen, slen;
	scanf("%d %d %s %s", &wlen, &slen, w, s);
	if (wlen > slen) {
		printf("0\n");
		return 0;
	}

	for (int i = 0; i < wlen; i++) {
		wfreq[w[i]]++;
		sfreq[s[i]]++;
	}

	int r = 0;
	if (memcmp(wfreq, sfreq, sizeof(sfreq)) == 0) r++;

	for (int i = 0, j = wlen; j < slen; i++, j++) {
		sfreq[s[i]]--;
		sfreq[s[j]]++;
		if (memcmp(wfreq, sfreq, sizeof(sfreq)) == 0) r++;
	}
	printf("%d\n", r);

	return 0;
}