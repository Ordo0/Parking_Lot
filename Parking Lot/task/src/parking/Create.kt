package parking

class Create {
    fun createParkingLot(): Array<String> {
        val parkingLot: Array<String>

        do {
            val input = readLine()!!.split(" ").toList()
            if (input[0] == "create") {
                parkingLot = Array(input[1].toInt()) { "0" }
                println("Created a parking lot with ${input[1]} spots.")
                break
            } else if (input[0] != "create" && input[0] != "exit") {
                println("Sorry, a parking lot has not been created.")
            } else if (input[0] == "exit") {
                parkingLot = arrayOf("exit")
                break
            }
        } while (true)
        return parkingLot
    }
}