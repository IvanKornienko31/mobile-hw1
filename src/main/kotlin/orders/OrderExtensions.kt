package orders

/**
 * Applies a percentage discount to every product in the order.
 *
 * Hint: use [products] to read the current list, [removeProductById] and
 * [addProduct] to replace each product with a discounted copy.
 * Use [Product.copy] to create a new product with a modified price.
 *
 * @param discountPercent discount percentage (e.g. 10 means 10%)
 * @param logger optional callback invoked with a log message for each product
 */
fun Order.applyDiscount(
    discountPercent: Int,
    logger: ((String) -> Unit)? = null
) {
    products.forEach { product ->
        val priceWithDiscount = product.price - product.price * discountPercent / 100

        product.copy(price = priceWithDiscount)
            .also {
                discountedProduct ->
                logger?.invoke("Discount is applied for product with ID = ${discountedProduct.id}. Now it costs ${discountedProduct.price}")
            }
            .let { discountedProduct ->
                this.removeProductById(productId = product.id)
                this.addProduct(product = discountedProduct)
            }
    }
}
