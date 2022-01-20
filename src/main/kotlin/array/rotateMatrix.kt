package array

fun <T> rotateMatrix(matrix: ArrayList<ArrayList<T>>) {
    if (matrix.isEmpty() || matrix.size != matrix[0].size) return

    val iterations = (matrix.size) / 2
    for (start in 0 until iterations) {
        val end = matrix.size - 1 - start
        for (i in start until end) {
            val offset = i - start
            val temp = matrix[start][i]

            matrix[start][i]            = matrix[end - offset][start]
            matrix[end - offset][start] = matrix[end][end - offset]
            matrix[end][end - offset]   = matrix[i][end]
            matrix[i][end]              = temp
        }
    }
}