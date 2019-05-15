package com.example.basekt.widgets

/**
 * @author 20888
 * @date 2019/5/15 15:35
 */
fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (t in source) {
        target.add(t)
    }
}

fun main() {
    var ccc: Int = 3
    val source: List<Int> = arrayListOf(ccc)
    val target: ArrayList<Int> = arrayListOf(ccc)
    println(target)
    target[0] = 6
    println(target)
    println(source)

    //不转化为序列 输出的顺序是先走完map 再走filter
    val filter = listOf(1, 2, 3, 4, 5, 6)
        .map { print("map($it)");it * it }
        .find { it > 3 }
    //.filter { print("filter($it)");it % 2 == 0 }
    println(filter)

    //怎么都觉得是序列好啊。。。
    val toList = listOf(1, 2, 3, 4, 5, 6)
        .asSequence()
        .map { print("map($it)");it * it }
        .find { it > 3 }
    //.filter { print("filter($it)");it % 2 == 0 }
    //.toList()
    println(toList)

    //序列
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    generateSequence(0) { it + 1 }.takeWhile { it <= 100 }.sum()
    println(numbersTo100.sum())

    //不使用with
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    println(result.toString())

    //使用with
    with(StringBuilder()){
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        println(this.toString())
    }

}