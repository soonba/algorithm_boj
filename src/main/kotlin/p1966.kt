package ee

//큐를 순회하며 내 앞까지 같은 값 개수를 구하고, 전체에서의 순위를 구한다.
//3
//1 0
//5
//4 2
//1 2 3 4
//6 0
//1 1 9 1 1 1
fun main() {
    val T = readln().toInt()

    val sb = StringBuilder()
    repeat(T) {
        //N개수, M찾고자하는 index 0~
        val (N, M) = readln().split(" ").map { it.toInt() }
        val target = readln().split(" ").map { it.toInt() }
        val importantArr = IntArray(10)
        var cnt = 0
        for (i in 0..N - 1) {
            val now = target[i]
            if (i == M) {
                cnt = importantArr[now]
            }
            importantArr[now]++
        }

        for (i in target[M]..9) {
            cnt += importantArr[i]
        }
        sb.append(cnt).append("\n")
    }
    print(sb)
}