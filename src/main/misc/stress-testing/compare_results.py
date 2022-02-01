import os
import random
import subprocess
import sys

ORACLE = "./oracle.out" # known working solution to produce expected output
TARGET = "./target.out" # unreliable solution to test

sys.setrecursionlimit(10 ** 9)

def gen():
	# returns a list of lines
	# to retry, return gen() recursively
	return []

def run(sol, lines):
	input_bytes = bytes(os.linesep.join(lines), "utf8")
	p = subprocess.Popen(sol, stdin=subprocess.PIPE, stdout=subprocess.PIPE)
	got, _ = p.communicate(input=input_bytes)
	return str(got, "utf8")

cases = 0
while True:
	generated = gen()
	want, got = run(ORACLE, generated), run(TARGET, generated)
	if want != got:
		print("wrong output")
		print("input:")
		print("\n".join(generated))
		print()
		print("expected:")
		print(want)
		print()
		print("got:")
		print(got)
		break

	cases += 1
	if cases % 100 == 0:
		print(f"ran {cases} cases")

