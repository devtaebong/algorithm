import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val (n, c, arr) = input()
    println(solve(n, c, arr))
}

private fun solve(n: Int, c: Int, internetModems: IntArray): Int {
    internetModems.sort()

    var result = 0
    var l = 1
    var r = internetModems[n - 1]

    while (l <= r) {
        val mid = (l + r) / 2
        val isInstall = countInstalledInternetModems(n, c, mid, internetModems)
        if (isInstall) {
            l = mid + 1
            result = mid
        } else {
            r = mid - 1
        }
    }

    return result
}

private fun countInstalledInternetModems(
    n: Int,
    c: Int,
    distance: Int,
    internetModems: IntArray,
): Boolean {
    var count = 1
    var before = internetModems[0]

    for (i in 1 until n) {
        val now = internetModems[i]
        if (now - before >= distance) {
            before = now
            count++
        }
    }
    return count >= c
}

private fun input(): Triple<Int, Int, IntArray> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, c) = StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) { nextToken().toInt() }
    }
    val arr = IntArray(n) { br.readLine().toInt() }

    return Triple(n, c, arr)
}
