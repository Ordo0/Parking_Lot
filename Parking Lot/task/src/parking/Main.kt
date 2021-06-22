package parking

fun main() {
    val p = Parking()
    val c = Create()
    val parkingLot = c.createParkingLot()
    if (!parkingLot.contains("exit")) {
        p.isParking(parkingLot)
    }
}