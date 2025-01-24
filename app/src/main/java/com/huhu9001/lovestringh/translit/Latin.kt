package com.huhu9001.lovestringh.translit

object Latin {
    val ritems = arrayOf(
        Transliterator.RegexItem(Regex("..."), mapOf(
            "A:-" to "Ǟ", "a:-" to "ǟ",
            "AE-" to "Ǣ", "Ae-" to "Ǣ", "ae-" to "ǣ",
            "O:-" to "Ȫ", "o:-" to "ȫ",
            "U:-" to "Ǖ", "u:-" to "ǖ",
            "U-:" to "Ṻ", "u-:" to "ṻ",

            "AE/" to "Ǽ", "Ae/" to "Ǽ", "ae/" to "ǽ",
            "I:/" to "Ḯ", "i:/" to "ḯ",
            "U:/" to "Ǘ", "u:/" to "ǘ",

            "U:&" to "Ǚ", "u:&" to "ǚ",

            "U:\\" to "Ǜ", "u:\\" to "ǜ",
        )),
        Transliterator.RegexItem(Regex(".."), mapOf(
            "AE" to "Æ", "Ae" to "Æ", "ae" to "æ",
            "CZ" to "Ç", "Cz" to "Ç", "cz" to "ç",
            "OE" to "Œ", "Oe" to "Œ", "oe" to "œ",
            "SZ" to "ẞ", "Sz" to "ẞ", "sz" to "ß",

            "A:" to "Ä", "a:" to "ä",
            "E:" to "Ë", "e:" to "ë",
            "H:" to "Ḧ", "h:" to "ḧ",
            "I:" to "Ï", "i:" to "ï",
            "O:" to "Ö", "o:" to "ö",
            "t:" to "ẗ",
            "U:" to "Ü", "u:" to "ü",
            "Y:" to "Ÿ", "y:" to "ÿ",

            "A-" to "Ā", "a-" to "ā",
            "E-" to "Ē", "e-" to "ē",
            "G-" to "Ḡ", "g-" to "ḡ",
            "I-" to "Ī", "i-" to "ī",
            "O-" to "Ō", "o-" to "ō",
            "U-" to "Ū", "u-" to "ū",
            "Y-" to "Ȳ", "y-" to "ȳ",

            "A/" to "Á", "a/" to "á",
            "C/" to "Ć", "c/" to "ć",
            "E/" to "É", "e/" to "é",
            "G/" to "Ǵ", "g/" to "ǵ",
            "I/" to "Í", "i/" to "í",
            "K/" to "Ḱ", "k/" to "ḱ",
            "L/" to "Ĺ", "l/" to "ĺ",
            "M/" to "Ḿ", "m/" to "ḿ",
            "N/" to "Ń", "n/" to "ń",
            "O/" to "Ó", "o/" to "ó",
            "P/" to "Ṕ", "p/" to "ṕ",
            "R/" to "Ŕ", "r/" to "ŕ",
            "S/" to "Ś", "s/" to "ś",
            "U/" to "Ú", "u/" to "ú",
            "W/" to "Ẃ", "w/" to "ẃ",
            "Y/" to "Ý", "y/" to "ý",
            "Z/" to "Ź", "z/" to "ź",

            "A&" to "Ǎ", "a&" to "ǎ",
            "C&" to "Č", "c&" to "č",
            "D&" to "Ď", "d&" to "ď",
            "E&" to "Ě", "e&" to "ě",
            "G&" to "Ǧ", "g&" to "ǧ",
            "H&" to "Ȟ", "h&" to "ȟ",
            "I&" to "Ǐ", "i&" to "ǐ",
            "j&" to "ǰ",
            "K&" to "Ǩ", "k&" to "ǩ",
            "L&" to "Ľ", "l&" to "ľ",
            "N&" to "Ň", "n&" to "ň",
            "O&" to "Ǒ", "o&" to "ǒ",
            "R&" to "Ř", "r&" to "ř",
            "S&" to "Š", "s&" to "š",
            "T&" to "Ť", "t&" to "ť",
            "U&" to "Ǔ", "u&" to "ǔ",
            "Z&" to "Ž", "z&" to "ž",

            "A\\" to "À", "a\\" to "à",
            "E\\" to "È", "e\\" to "è",
            "I\\" to "Ì", "i\\" to "ì",
            "O\\" to "Ò", "o\\" to "ò",
            "U\\" to "Ù", "u\\" to "ù",
            "W\\" to "Ẁ", "w\\" to "ẁ",
            "Y\\" to "Ỳ", "y\\" to "ỳ",

            "A^" to "Â", "a^" to "â",
            "E^" to "Ê", "e^" to "ê",
            "I^" to "Î", "i^" to "î",
            "O^" to "Ô", "o^" to "ô",
            "U^" to "Û", "u^" to "û",
            "Y^" to "Ŷ", "y^" to "ŷ",
        )),
        Transliterator.RegexItem(Regex("."), mapOf(
            ":" to "\u0308",//Diaeresis
            "-" to "\u0304",//Macron
            "/" to "\u0301",//Acute
            "&" to "\u030C",//Caron
            "\\" to "\u0300",//Grave
            "^" to "\u0302",//Circumflex
        )),
    )
}