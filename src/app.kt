/*
Programmer: Oryan Omer
Date 15/11/2019
 */
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime


class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        var mapDailySales = emptyMap<DayOfWeek, Int>().toMutableMap()
        var DAY: DayOfWeek
        for (order in orders) {
            DAY = order.creationDate.dayOfWeek
            for (orderLine in order.orderLines) {
                if (mapDailySales.containsKey(DAY)) {
                    mapDailySales[DAY] = orderLine.quantity + mapDailySales[DAY]!!
                } else {
                    mapDailySales[DAY] = orderLine.quantity
                }
            }

        }
        return mapDailySales
    }

}

fun main() {
    //test
    val collectionOrders = listOf(
        OrdersAnalyzer.Order(
            orderId = 554,
            creationDate = LocalDateTime.now(), // Saturday
            orderLines = listOf(
                OrdersAnalyzer.OrderLine(
                    productId = 9872,
                    name = "Pencil",
                    quantity = 3,
                    unitPrice = BigDecimal(3.3)
                )
            )
        )
    )

    val orderAnalyzer = OrdersAnalyzer()
    println(orderAnalyzer.totalDailySales(collectionOrders))

}