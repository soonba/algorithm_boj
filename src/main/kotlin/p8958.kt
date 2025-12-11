fun main() {
    val T = readln().toInt()
    val sb = StringBuilder();
    repeat(T) {
        val line = readln()
        var score = 0
        var stack = 0
        line.forEach { char ->
            if(char == 'O') {
                score+=++stack
            } else {
                stack = 0
            }
        }
        sb.append(score).append("\n")
    }
    print(sb)
}