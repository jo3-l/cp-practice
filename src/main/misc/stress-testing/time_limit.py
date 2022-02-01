import os
import random
import subprocess
import sys
import time

TARGET = "./target.out" # solution to test
TIME_LIMIT_SECS = 1

sys.setrecursionlimit(10 ** 9)

def gen():
	# returns a list of lines
	# to retry, return gen() recursively
	return []

cases = 0
while True:
	p = subprocess.Popen(TARGET, stdin=subprocess.PIPE, stdout=subprocess.PIPE)
	generated = gen()
	input_bytes = bytes(os.linesep.join(generated), "utf8")
	
	start = time.time()
	p.communicate(input=input_bytes)
	elapsed = time.time() - start

	if elapsed >= TIME_LIMIT_SECS:
		print("found slow case")
		print("\n".join(generated))
		break
	
	cases += 1
	if cases % 100 == 0:
		print(f"ran {cases} cases")
