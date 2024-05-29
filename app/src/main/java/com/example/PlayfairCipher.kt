package com.example


class Solution() {

    val KEYWORD = "MONARCHY"
    val ALPHABETS = "ABCDEFGHIKLMNOPQRSTUVWXYZ" // 'J' is excluded in Playfair cipher
    val BOGUS_LETTER = "X"
    val usedChars = mutableSetOf<Char>()
    val matrix = mutableListOf<MutableList<Char>>()

    //    val text = "HELLO"
    val text = "ME"
    val chunkedText = mutableListOf<String>()
    val encryptedText = mutableListOf<String>()


    init {
        var index = 0

        for (char in KEYWORD) {
            if (char !in usedChars) {
                val row = index / 5
                val col = index % 5
                if (matrix.size <= row) {
                    matrix.add(MutableList(5) { ' ' })
                }
                matrix[row][col] = char
                usedChars.add(char)
                index++
            }
        }

        for (char in ALPHABETS) {
            if (char !in usedChars) {
                val row = index / 5
                val col = index % 5
                if (matrix.size <= row) {
                    matrix.add(MutableList(5) { ' ' })
                }
                matrix[row][col] = char
                usedChars.add(char)
                index++

            }
        }
        print(matrix)
        var i = 0
        while (i < text.length) {
            if (i + 1 < text.length && text[i] != text[i + 1]) {
                chunkedText.add(text.substring(i, i + 2))
                i += 2
            } else if (text[i] == text[i + 1]) {
                chunkedText.add(text.substring(i, i + 1) + BOGUS_LETTER)
                i += 1

            } else {
                chunkedText.add(text.substring(i, i + 1) + BOGUS_LETTER)
                i += 2
            }
        }

        //encryption logic
        for (pairs in chunkedText) {
            if(pairInSameRowOrCol(pair = pairs))continue
            for (k in 0..matrix.size - 1) {

                for (matrixChar in matrix[k]) {
                }
            }


        }
    }

    fun pairInSameRowOrCol(pair: String): Boolean {

        //check whether in same row
        for (j in 0..matrix.size - 1) {
            if (pair[0] in matrix[j] && pair[1] in matrix[j]) {
//                encryptedText.add(matrix[j][ matrix[j].indexOf()])
                print(true)
                return true
            }

        }

        //check whether in same col
        var totalCharFound = 0
        for (i in 0 until matrix.size ) {
            for (j in 0 until matrix.size) {
                if (pair[0] == matrix[j][i] || pair[1] == matrix[j][i]) {
                    println("pairs are ${pair[0]}, ${pair[1]} and char is ${matrix[j][i]}")
                    totalCharFound += 1
                    if (totalCharFound == 2) {
                        println("found in col")
                        return true
                    }

                }
            }
            totalCharFound = 0
        }
        return false
    }
}

fun main() {
    val solution = Solution()

    print(solution)

}