fun reverse(word: String): String {
    if (word.isEmpty()) return word
    println(word)
    return reverse(word.substring(1)) + word[0]
}

fun reverseWithApi(word: String): String = reverse(word)