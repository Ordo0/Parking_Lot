package parking

class Info {
    fun status(parking: Array<String>) {
        var check = 0
        for (i in parking) {
            if (i != "0") {
                println("${parking.indexOf(i) + 1} $i")
                check = 1
            }
        }
        if (check == 0) {
            println("Parking lot is empty.")
        }
    }

    fun regByColor(parking: Array<String>, color: String) {
        val res = mutableListOf<String>()
        for (i in 0..parking.lastIndex) {
            if (parking[i].contains(color, ignoreCase = true)) {
                val regNumber = parking[i].substringBefore(' ')
                res.add(regNumber)
            }
        }
        if (res.isNotEmpty()) {
            println(res.joinToString())
        } else {
            println("No cars with color $color were found.")
        }
    }

    fun spotBy(parking: Array<String>, command: String, parametr: String) {
        val res = mutableListOf<Int>()
        for (i in 0..parking.lastIndex) {
            if (parking[i].contains(parametr, ignoreCase = true)) {
                if (command == "spot_by_color") {
                    val spotNumber = parking[i].substringAfter(' ')
                    if (spotNumber.equals(parametr, true)) {
                        res.add(i + 1)
                    }
                } else if (command == "spot_by_reg") {
                    val spotNumber = parking[i].substringBefore(' ')
                    if (spotNumber.equals(parametr, true)) {
                        res.add(i + 1)
                    }
                }

            }
        }
        if (res.isNotEmpty()) {
            println(res.joinToString())
        } else {
            if (command == "spot_by_color") {
                println("No cars with color $parametr were found.")
            } else if (command == "spot_by_reg") {
                println("No cars with registration number $parametr were found.")
            }
        }
    }
}