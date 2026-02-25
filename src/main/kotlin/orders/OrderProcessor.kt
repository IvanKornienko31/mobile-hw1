package orders

/**
 * Returns a human-readable description of the order status.
 * Use a `when` expression on [order].status:
 *   - Created  -> "Order {id} is new"
 *   - Paid     -> "Order {id} is paid"
 *   - Cancelled -> "Order {id} is cancelled: {reason}"
 */
fun processOrder(order: Order): String {
    val id: Int = order.id

    return when (val status = order.status) {
        is OrderStatus.Created -> "Order $id is new"
        is OrderStatus.Paid -> "Order $id is paid"
        is OrderStatus.Cancelled -> "Order $id is cancelled: ${status.reason}"
    }
}
