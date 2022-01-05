from dataclasses import dataclass
from collections import Counter
from typing import Iterable, Union, Counter

Item = Union["Element", "Group"]


@dataclass
class Element:
    name: str
    count: int

    def element_counts(self):
        return Counter({self.name: self.count})


def multiply_counter(counter: Counter, multiplier: int):
    return Counter({k: v * multiplier for k, v in counter.items()})


def combine_element_counts(items: Iterable[Item]):
    return sum((item.element_counts() for item in items), Counter())


@dataclass
class Group:
    items: list[Item]
    count: int

    def element_counts(self):
        return multiply_counter(
            combine_element_counts(self.items),
            self.count,
        )


class Parser:
    def __init__(self, txt: str):
        self.txt = txt
        self.pos = 0

    def run(self):
        items: list[Item] = []
        while not self._done:
            items.append(self._parse_item())
        return items

    def _parse_item(self) -> Item:
        assert self.txt[self.pos].isupper() or self.txt[self.pos] == "("
        return (
            self._parse_element()
            if self.txt[self.pos].isupper()
            else self._parse_group()
        )

    def _parse_element(self):
        name: list[str] = [self.txt[self.pos]]
        self.pos += 1
        while not self._done and self.txt[self.pos].islower():
            name.append(self.txt[self.pos])
            self.pos += 1
        count = 1
        if not self._done and self.txt[self.pos].isdigit():
            count = self._parse_num()
        return Element("".join(name), count)

    def _parse_group(self):
        self.pos += 1  # skip "("
        items: list[Item] = []
        while self.txt[self.pos] != ")":
            items.append(self._parse_item())
        self.pos += 1  # skip ")"
        count = 1
        if not self._done and self.txt[self.pos].isdigit():
            count = self._parse_num()
        return Group(items, count)

    def _parse_num(self):
        n = 0
        while not self._done and self.txt[self.pos].isdigit():
            n = (n * 10) + int(self.txt[self.pos])
            self.pos += 1
        return n

    @property
    def _done(self):
        return self.pos >= len(self.txt)


txt = input()
items = Parser(txt).run()
for name, count in sorted(combine_element_counts(items).items()):
    print(name, end="")
    if count > 1:
        print(count, end="")
print()
