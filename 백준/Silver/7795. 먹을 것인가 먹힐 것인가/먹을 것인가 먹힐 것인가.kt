import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    val T = br.readLine().toInt()

    repeat(T) {
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val A = IntArray(n)
        st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            A[i] = st.nextToken().toInt()
        }

        val B = IntArray(m)

        st = StringTokenizer(br.readLine())
        for (i in 0 until m) {
            B[i] = st.nextToken().toInt()
        }

        B.sort()
        var res = 0
        for (i in 0 until n) {
            val idx = upperBound(A[i], B)
            res += idx
        }
        println(res)
    }
}

fun upperBound(x: Int, arr: IntArray): Int {
    var l = 0
    var r = arr.size - 1
    var result = 0

    while (l <= r) {
        val mid = (l + r) / 2

        if (x > arr[mid]) {
            result = mid + 1
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return result
}