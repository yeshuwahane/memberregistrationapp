package com.yeshuwahane.memberregistrationapp.presentation.utils



fun formatDate(input: String): String {
    val cleanInput = input.filter { it.isDigit() }
    val formatted = StringBuilder()

    if (cleanInput.length <= 10) { // Limit input length
        cleanInput.forEachIndexed { index, char ->
            formatted.append(char)
            if ((index == 1 || index == 3) && index < cleanInput.length - 1) {
                formatted.append("/")
            }
        }
    } else {
        // If input exceeds 10 digits, return the previous value
        return input.dropLast(1) // Drop the extra digit
    }

    return formatted.toString().take(10)
}