package com.motycka.edu.lesson02

import kotlin.math.min

val coffeeOrders = mutableMapOf<Int, List<String>>()
val curOrderId = -1;

fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    val change = payment - totalToPay;
    if (change < 0) {
        throw IllegalStateException("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
    }

    completeOrder(orderId);
    println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")

    return change
}

fun placerOrder(items: List<String>): Int {
    val curOrderId = curOrderId + 1
    coffeeOrders.put(curOrderId, items)
    return curOrderId;
}

fun payOrder(orderId: Int): Double {
    val items = coffeeOrders[orderId] ?: throw IllegalStateException("Order ID $orderId not found.")
    var total = items.sumOf { item ->
        when (item) {
            ESPRESSO -> ESPRESSO_PRICE
            DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
            CAPPUCCINO -> CAPPUCCINO_PRICE
            LATTE -> LATTE_PRICE
            AMERICANO -> AMERICANO_PRICE
            FLAT_WHITE -> FLAT_WHITE_PRICE
            else -> error("$item is not on the menu!")
        }
    }

    if (items.size > 3) {
        var minPrice = Double.MAX_VALUE
        for (item in items) {
            minPrice = min(minPrice, when (item) {
                ESPRESSO -> ESPRESSO_PRICE
                DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
                CAPPUCCINO -> CAPPUCCINO_PRICE
                LATTE -> LATTE_PRICE
                AMERICANO -> AMERICANO_PRICE
                FLAT_WHITE -> FLAT_WHITE_PRICE
                else -> error("$item is not on the menu!")
            })
        }

        total -= minPrice;
    }
    return total;

}

fun completeOrder(orderId: Int) {
    if (!coffeeOrders.containsKey(orderId)) {
        throw IllegalStateException("Order ID $orderId not found.")
    }
    coffeeOrders.remove(orderId)
}

