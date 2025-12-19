import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val (k, n, arr) = input()
    println(solve(k, n, arr))
}

private fun solve(n: Int, m: Int, budgets: IntArray): Int {
    budgets.sort()
    // 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
    val totalRequestedBudget = budgets.sum()
    if (totalRequestedBudget <= m) {
        return budgets[n - 1]
    }

    // 2. 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
    var l = 1
    var r = budgets[n - 1]

    var maxBudget = 0
    while (l <= r) {
        val mid = (l + r) / 2
        val givenBudget = budgets.sumOf { minOf(it, mid) }

        if (givenBudget > m) {
            r = mid - 1
        } else {
            maxBudget = max(maxBudget, mid)
            l = mid + 1
        }
    }

    return maxBudget
}

private fun input(): Triple<Int, Int, IntArray> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) { nextToken().toInt() }
    }
    val m = br.readLine().toInt()

    return Triple(n, m, arr)
}
