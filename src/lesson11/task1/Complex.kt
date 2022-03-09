@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import kotlin.math.pow

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    var res: Complex = Complex(0.0, 0.0)
    for (i in s) {
        if (i == '+')
            res = Complex(s.split("+")[0].toDouble(), s.split("+")[1].dropLast(1).toDouble())
        else if (i == '-')
            res = Complex(s.split("-")[0].toDouble(), -s.split("-")[1].dropLast(1).toDouble())
    }
    return res
}


/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, (im + other.im))

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-re, -im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, (im - other.im))

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex((re * other.re - im * other.im), (re * other.im + im * other.re))

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        return Complex(
            (re * other.re + im * other.im) / (other.re.pow(2.0) + other.im.pow(2.0)),
            (im * other.re - re * other.im) / (other.re.pow(2.0) + (other.im.pow(2.0)))
        )
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other is Complex) {
            if (this === other || re == other.re && im == other.im) return true
        }
        return false
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = re.toString() + im.toString()
}
