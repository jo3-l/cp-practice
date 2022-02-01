if [[ $# -eq 0 ]] ; then
	echo "usage: mk_tle_finder.sh <name>"
	exit 1
fi

project_dir=$(realpath $0 | xargs dirname | xargs dirname)
stress_testing_dir=$project_dir/src/main/misc/stress-testing
dir=$stress_testing_dir/$1
mkdir $dir
touch $dir/target.cpp
cp $stress_testing_dir/time_limit.py $dir/runner.py
