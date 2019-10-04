object Pangram {
    fun isPangram(sentence: String): Boolean {
        val set = HashSet<Int>()

        sentence.toLowerCase().chars()
                .filter { Character.isAlphabetic(it) }
                .forEach { character ->
                    if (!set.contains(character)) {
                        set.add(character)
                    }
                }
        return set.size == 26
    }

}
