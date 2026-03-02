# Sorting Algorithms – Theoretical & Empirical Analysis

![Course](https://img.shields.io/badge/Course-CPCS223-orange)
![Language](https://img.shields.io/badge/Language-Java-blue)
![Topic](https://img.shields.io/badge/Topic-Algorithm%20Analysis-purple)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

This project presents a theoretical and experimental comparison of three sorting algorithms:

- Insertion Sort
- Merge Sort
- Quick Sort (Random Pivot)

Developed for CPCS223 – Analysis and Design of Algorithms  
King Abdulaziz University

---

## Project Overview

The goal of this project is to:

- Analyze sorting algorithms theoretically using asymptotic notation
- Measure their practical running time
- Compare performance across different input sizes
- Study behavior under different data distributions
- Evaluate pivot strategies in Quick Sort

The implementation was written in Java and measures time using nanoseconds.

---

## Implemented Algorithms

### 1. Insertion Sort

- Best Case: O(n)
- Average Case: O(n²)
- Worst Case: O(n²)
- Space Complexity: O(1)

Suitable for:
- Small datasets
- Nearly sorted arrays

---

### 2. Merge Sort

- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)
- Space Complexity: O(n)

Characteristics:
- Stable
- Consistent performance
- Requires extra memory

---

### 3. Quick Sort (Random Pivot)

- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n²)
- Space Complexity:
  - Average: O(log n)
  - Worst: O(n)

Uses:
- Random pivot selection
- In-place partitioning

---

## Experimental Setup

Array Sizes Tested:

10  
100  
1000  
10000  
100000  

Data Types Tested:

- Completely Unsorted
- Partially Sorted
- Nearly Sorted

Each test was run 5 times and averaged.

---

## Experimental Results Summary

For large N (100000):

Completely Unsorted:
- Insertion: ~1,003,837,659 ns
- Merge: ~13,458,480 ns
- Quick: ~16,193,320 ns

Partially Sorted:
- Insertion: ~475,229,339 ns
- Merge: ~6,844,259 ns
- Quick: ~12,896,840 ns

Nearly Sorted:
- Insertion: ~114,969,540 ns
- Merge: ~7,422,160 ns
- Quick: ~12,069,520 ns

Observation:

- Insertion Sort performs poorly for large datasets
- Merge Sort shows consistent O(n log n) behavior
- Quick Sort performs very efficiently in practice
- Nearly sorted data significantly improves Insertion performance

---

## Dual-Pivot QuickSort Analysis

The project also analyzes why Java adopts Dual-Pivot QuickSort.

Reasons:

1. Better partitioning (3 segments instead of 2)
2. Reduced swaps and comparisons
3. Improved cache performance
4. Balanced recursion depth
5. Space-efficient (in-place)
6. Faster practical performance on large datasets

Dual-pivot QuickSort maintains O(n log n) average time while reducing real-world overhead.

---

## Key Insights

- Theoretical complexity aligns with experimental results
- Merge Sort provides stable and predictable performance
- Quick Sort performs best overall for large random data
- Insertion Sort is efficient only for small or nearly sorted inputs
- Pivot strategy significantly affects Quick Sort performance

---

## Technologies Used

- Java
- System.nanoTime() for precise measurement
- Random data generation
- Experimental performance benchmarking

---

## Academic Information

Course: CPCS223 – Analysis and Design of Algorithms  
University: King Abdulaziz University  

---

## Team Members

Sultan Yasir Alasami – 2339663  
Ryan Abdullah Alsheri – 2336103  
Khaled Alshehri – 2338428  
Turki Alharbi – 2338473
