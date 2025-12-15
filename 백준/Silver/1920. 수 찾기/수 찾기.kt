import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arrA = StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) { nextToken().toInt() }
    }
    val m = br.readLine().toInt()
    val arrB = StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) { nextToken().toInt() }
    }

    arrA.sort()
    arrB.forEach {
        if (isExist(it, arrA)) {
            println(1)
        } else {
            println(0)
        }
    }
}

private fun isExist(x: Int, arr: IntArray): Boolean {
    var l = 0
    var r = arr.size - 1

    while(l <= r) {
        val mid = (l + r) / 2

        if (x > arr[mid]) {
            l = mid + 1
        } else if (x < arr[mid]) {
            r = mid - 1
        } else {
            return true
        }
    }

    return false
}