package day_1_kotlin.langrus.assignments

// Workshop #5 - inheritance, abstract, interface

// Не исправляй! Дано:
// Объявляем контракт, представляющий некое свойство транспорта.
interface Driveable {
    fun drive()
}

// Объявляем класс пассажирского транспорта вцелом.
// Придадим такому транспорту свойство перемещаться под управлением водителя.
abstract class Transport(protected var passengersCount: Int): Driveable

// Создадим реальный транспорт: "Велосипед". Он может управляться водителем и перевозит одного пассажира.
class Bicycle: Transport(1) {
    override fun drive() {
        println("Ride a bicycle.")
    }
}



/* Рабочая зона */

// TODO 1: Создай свой интерфейс - контракт, который бы также подошел по смыслу классу транспорт.
//  См. ниже.
// ? Имена классов и файлов Котлин принято называть с заглавной буквы, в формате "camelCase".
// Например: "SomeLongClassName"
interface Fuelable {
    val fuelType: String
}

// TODO 2: Создай свои собственные классы, например "Bus" и "Car".
//  Эти классы не будут полностью написаны с нуля, они должны расширять общий класс "Transport",
//  и дополнительно реализовывать придуманный тобой интерфейс.
// ? Класс может наследовать только один класс, но реализовывать несколько интерфейсов, например:
// class Kitty(): Cat, Cuteable, Sleepable, Furryable {}
class Bus: Transport(20), Fuelable {
    override fun drive() {
        println("Bus driving witn $passengersCount passenger")
    }

    override val fuelType = "Gasoline"

}
class ElectricCar: Transport(4), Fuelable {
    override fun drive() {
        println("Electric car driving with $passengersCount passenger")
    }

    override val fuelType = "Electricity"

}

// TODO 3: Протестируй работоспособность твоего транспорта.
object VehiclesTest {

    // Запусти исполнение main() функции, для выполнения кода.
    @JvmStatic
    fun main(args: Array<String>) {
        testBus()
        testCar()
        testBicycle()
        testBusParts()
    }

    private fun testBus() {
        println("\nTesting how bus drives...")
        val bus = Bus()
        bus.drive()
        println("Bus fuel is ${bus.fuelType}")
    }

    private fun testCar() {
        println("\nTesting how car drives...")
        val electricCar = ElectricCar()
        electricCar.drive()
        println("Electric car fuel is ${electricCar.fuelType}")
    }

    private fun testBicycle() {
        println("\nTesting how bicycle drives...")
        val bicycle = Bicycle()
        bicycle.drive()
    }



    /* Бонусные задания */

    // TODO 4: Протестируй агрегаты автобуса, как независимые компоненты.
    //  Т.е. каждый набор независимых свойств - отдельно, чтобы в тестируемой сущности были скрыты все свойства,
    //  не принадлежащие к данному набору.
    private fun testBusParts() {
        val testBus = Bus()
        println("\nTesting bus's fuelable")
        val testFuelableBus = testBus as Fuelable
        println("FuelType = ${testFuelableBus.fuelType}")

        println("Testing bus's drivable")
        val testDrivableBus = testBus as Driveable
        testDrivableBus.drive()
    }
}