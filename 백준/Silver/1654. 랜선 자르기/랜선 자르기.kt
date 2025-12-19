import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val (k, n, arr) = input()
    println(solve(k, n, arr))
}

private fun solve(k: Int, n: Int, arr: LongArray): Long {
    var l: Long = 1
    var r: Long = arr[k - 1]
    var answer: Long = 0

    while (l <= r) {
        val mid = ((l + r) / 2)
        if (cutLen(arr, mid) < n) {
            r = mid - 1
        } else {
            answer = mid
            l = mid + 1
        }
    }
    return answer
}

private fun cutLen(lens: LongArray, cuttingSize: Long): Long = lens.sumOf { (it / cuttingSize) }

private fun input(): Triple<Int, Int, LongArray> {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (k, n) = StringTokenizer(br.readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val arr = LongArray(k) {
        br.readLine().toLong()
    }.apply { sort() }

    return Triple(k, n, arr)
}
