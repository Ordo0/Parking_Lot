package parking

class Parking {

    fun isParking(_parking: Array<String>) {
        do {
            var parking = _parking

            val command = readLine()!!.split(" ").toList()

            if (command[0] != "exit") {
                when {
                    command[0] == "park" -> if (parking.contains("0")) {
                        println("${command[2]} car parked in spot ${parking.indexOf("0") + 1}.")
                        parking[parking.indexOf("0")] = "${command[1]} ${command[2]}"
                    } else println("Sorry, the parking lot is full.")

                    command[0] == "leave" -> if (parking[command[1].toInt() - 1] != "0") {
                        println("Spot ${command[1]} is free.")
                        parking[command[1].toInt() - 1] = "0"
                    } else if (parking[command[1].toInt() - 1] == "0") {
                        println("There is no car in spot ${command[1]}.")
                    }

                    command[0] == "create" -> {
                        parking = Array(command[1].toInt()) { "0" }
                        println("Created a parking lot with ${command[1]} spots.")
                        isParking(parking)
                        break
                    }

                    command[0] == "status" -> Info().status(parking)

                    command[0] == "reg_by_color" -> Info().regByColor(parking, command[1])

                    command[0] == "spot_by_color" || command[0] == "spot_by_reg" -> Info().spotBy(parking, command[0], command[1])
                }
            } else break
        } while (true)
    }
}