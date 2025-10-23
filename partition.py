#!/usr/bin/env python3
# partition.py

# Introduction to Algorithms, Fourth edition
# Linda Xiao

#########################################################################
#                                                                       #
# Copyright 2022 Massachusetts Institute of Technology                  #
#                                                                       #
# Permission is hereby granted, free of charge, to any person obtaining #
# a copy of this software and associated documentation files (the       #
# "Software"), to deal in the Software without restriction, including   #
# without limitation the rights to use, copy, modify, merge, publish,   #
# distribute, sublicense, and/or sell copies of the Software, and to    #
# permit persons to whom the Software is furnished to do so, subject to #
# the following conditions:                                             #
#                                                                       #
# The above copyright notice and this permission notice shall be        #
# included in all copies or substantial portions of the Software.       #
#                                                                       #
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,       #
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF    #
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                 #
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS   #
# BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN    #
# ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN     #
# CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE      #
# SOFTWARE.                                                             #
#                                                                       #
#########################################################################


from random import randint


def randomized_partition(A, p, r):
	"""Rearrange A[p: r+1] into two (possible empty) sublists/subarrays
	such that all elements of a[p: q] <= a[q] <= a[q+1: r+1].  The pivot
	is chosen randomly from the elements of A[p: r+1].

	Arguments:
	A -- a list or numpy array to be sorted
	p -- index of the beginning of the sublist/subarray
	r -- index of the end of the sublist/subarray

	Returns:
	The index where the pivot ends up.
	"""
	i = randint(p, r)  # random index from p to r
	# Exchange a[r] with a[i], so new pivot is a[i].
	A[i], A[r] = A[r], A[i]  # exchange A[r] with A[i], so that A[i] becomes the pivot

	return partition(A, p, r)



def partition(A, p, r):
	"""Rearrange A[p: r+1] into two (possible empty) sublists/subarrays
	such that all elements of a[p: q] <= a[q] <= a[q+1: r+1].
	A[r] is chosen as the pivot.

	Arguments: 
	A -- a list or numpy array to be sorted
	p -- index of the beginning of the sublist/subarray
	r -- index of the end of the sublist/subarray

	Returns:
	The index where the pivot ends up.
	"""
	x = A[r]  # select the last element as the pivot

	i = p - 1  # highest index into the low side
	for j in range(p, r):  # process each element other than the pivot
		if A[j] <= x:  # does this element belong on the low side?
			i += 1  # index of a new slot in the low side
			A[i], A[j] = A[j], A[i]  # put this element there

	A[i + 1], A[r] = A[r], A[i + 1]  # the pivot does just to the right of the low side
	return i + 1  # return the new index of the pivot


# To test hoare_partition, replace the call to partition in quicksort
# by a call to hoare_partition, and change the first recursive call
# to quicksort by quicksort(A, p, q).
def hoare_partition(A, p, r):
	"""Rearrange A into two (possible empty) sublists/subarrays
	such that all elements of a[p: j+1] <= a[j+1: r+1].

	Arguments:
	A -- a list or numpy array to be sorted
	p -- index of the beginning of the sublist/subarray
	q -- index of the end of the sublist/subarray

	Returns:
	j -- index of dividing point
	"""
	x = A[p]
	i = p-1
	j = r+1
	while True:
		while True:  # Python version of repeat-until loop
			j -= 1
			if A[j] <= x:
				break

		while True:  # Another repeat-until loop
			i += 1
			if A[i] >= x:
				break

		if i < j:
			A[i], A[j] = A[j], A[i]
		else:
			return j
