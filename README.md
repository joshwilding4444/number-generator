## Number Generator

This program generates a file with a specified number of random integers, then sorts the random numbers, and outputs the random numbers to another file.

### Usage

This program takes the following command-line parameters:
1. Flag to generate new random numbers or to use an existing file.
2. When we use `-g` to generate a new random file we enter:
    1. The number of integers to generate.
    2. The name of the file that contains random values
    3. The name of the file that contains sorted values
3. When we use `-e` to use an existing file we enter:
    1. The name of the file that contains random values
    2. The name of the file that contains sorted values

For example, to generate one million values, save the random values to "oneMillionRandom.txt" and the sorted values to "oneMillionSorted.txt", we use the following parameters:
`-g 1000000 oneMillionRandom.txt oneMillionSorted.txt`

If there is an existing file "tenThousandRandom.txt" we can use, and we wish to write sorted output to "tenThousandSorted.txt", we can use the following parameters:
`-e tenThousandRandom.txt tenThousandSorted.txt`

### Assumptions

To simplify this program, we make the following assumptions:
- The random numbers to be generated are signed 32-bit integers
- Input and output should be to a line-delimited plain-text file
