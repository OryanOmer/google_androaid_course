## Google assignment for Androaid course

Implement order analzyer totalDailySales method which calc all the orders at specific day of week.
the class get as input collection of orders and the out is a map of DAY OF WEEK and amount of quantity in that day.

Example:
```python
    // declare a collection with one order
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

    // call function to calc total Daily sales
    val orderAnalyzer = OrdersAnalyzer()
    println(orderAnalyzer.totalDailySales(collectionOrders))
```
Output:
> {FRIDAY: 3}



>Hope you enjoy
