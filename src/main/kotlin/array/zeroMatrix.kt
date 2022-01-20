package array

fun zeroMatrix(matrix: ArrayList<ArrayList<Int>>) {
    val R = mutableSetOf<Int>()
    val C = mutableSetOf<Int>()

    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (matrix[row][col] == 0) {
                R.add(row)
                C.add(col)
            }
        }
    }

    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (R.contains(row) || C.contains(col)) {
                matrix[row][col] = 0
            }
        }
    }
}