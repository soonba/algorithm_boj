fun main() {
    val set = HashSet<Int>()
    repeat(10) {
        set.add(readln().toInt() % 42)
    }
    print(set.size)
}