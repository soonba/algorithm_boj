import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n1 = br.readLine().toInt()
    val n2 = br.readLine().toInt()
    val n3 = br.readLine().toInt()
    val multi = (n1 * n2 * n3).toString()
    val array = IntArray(10)

    for (ch in multi) {
        array[ch.digitToInt()] ++
    }

    val sb = StringBuilder()
    array.forEach { el -> sb.append(el).append("\n") }
    print(sb)
}