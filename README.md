# Minimizing Array Score

## 💡 Overview

This project implements an efficient solution to the **"Array and Operations"** competitive programming problem. The goal is to calculate the **minimum possible score** achievable after performing exactly $k$ pair-wise removal operations on an array of $n$ integers.

The final score is composed of two parts:
1.  The accumulated sum from the $k$ operations.
2.  The sum of the $n - 2k$ remaining elements.

The challenge lies in making strategic choices for the $k$ pairs to minimize this total score.

## 🧠 Theoretical Approach: Greedy Strategy

To achieve the minimum score, a **greedy strategy** is employed, addressing the two components of the score simultaneously:

### 1. Minimizing the Sum of Remaining Elements
This component is minimized by ensuring the **$2k$ largest elements** of the initial array are the ones chosen for removal. The $n - 2k$ smallest elements are guaranteed to be the ones that remain, contributing the minimum possible base sum to the final score.

### 2. Minimizing the Operations Score
The value added in each operation is $\left\lfloor \frac{\min(a_i, a_j)}{\max(a_i, a_j)} \right\rfloor$. This value is either $\mathbf{0}$ (if $a_i \neq a_j$) or $\mathbf{1}$ (if $a_i = a_j$). To minimize the total operations score, we want to maximize the count of operations that yield $\mathbf{0}$.

### The Optimal Pairing

By **sorting the array** $A$ initially, we isolate the set $R$ of the $2k$ largest elements. To maximize the chance of $a_i \neq a_j$ in a pair, we partition $R$ into two halves:

* $L$: The $k$ smallest elements in $R$ (i.e., elements $a_{n-2k+1}$ to $a_{n-k}$).
* $G$: The $k$ largest elements in $R$ (i.e., elements $a_{n-k+1}$ to $a_n$).

The optimal pairing strategy is to match the **$i$-th element of $L$** with the **$i$-th element of $G$**. This pairing ensures the largest possible difference between the two elements in a pair, which in turn minimizes the quotient $\lfloor a_{\text{smaller}} / a_{\text{larger}} \rfloor$, thereby minimizing the total accumulated operations score.

## 🛠️ Project Architecture (Java)

The solution is structured to separate the **I/O handling** from the **core algorithm logic**, following good object-oriented principles.

### `MinScoreApp.java` (Application Entry Point)

* Handles reading the number of test cases ($t$).
* For each test case, it reads $n$, $k$, and the array elements.
* Calls the dedicated `ArrayScoreCalculator` to compute the minimum score.
* Handles printing the final result to the console.
* *It utilizes native Java methods or external libraries like `algs4` (e.g., for sorting) for efficient data processing.*

### `score/ArrayScoreCalculator.java` (Core Logic)

This class contains the static method(s) implementing the optimized algorithm.

1.  **Input:** An integer array $A$, and the number of operations $k$.
2.  **Steps:**
    * **Sort** the input array $A$.
    * Calculate the **Base Score** (sum of the $n-2k$ smallest elements).
    * Iterate $k$ times to calculate the **Operations Score** by pairing $A[i]$ and $A[i+k]$ within the $2k$ largest elements.
    * Return the sum of the Base Score and the Operations Score.