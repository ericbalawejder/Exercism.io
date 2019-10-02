fun transcribeToRna(dna: String): String {
    val dnaToRna = mapOf("C" to "G", "G" to "C", "T" to "A", "A" to "U")
    return dna.map { dnaToRna["$it"] }.joinToString(separator = "")
}

fun transcribeToRna2(dna: String): String {
    val dnaToRna = mapOf("C" to "G", "G" to "C", "T" to "A", "A" to "U")
    var rna = mutableListOf<String>()
    for (letter in dna) {
        if (dnaToRna.containsKey("$letter")) {
            rna.add(dnaToRna.getValue("$letter"))
        }
    }
    return rna.joinToString(separator = "")
}
