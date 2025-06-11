fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    var count = 0
    var sum = arr[0]
    var r = 0

    for (l in 0 until n) {
        while (r < n - 1 && sum < m) {
            sum += arr[++r]
        }

        if (sum == m) {
            count++
        }
        sum -= arr[l]
    }
    println(count)
}
