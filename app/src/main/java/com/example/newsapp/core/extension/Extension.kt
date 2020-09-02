package com.example.newsapp.core.extension

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView

fun View.setPaddingOptionally(
        left: Int = paddingLeft,
        top: Int = paddingTop,
        right: Int = paddingRight,
        bottom: Int = paddingBottom
) {
    setPadding(left, top, right, bottom)
}

class NullableComprehension {

    fun <T> T?.bind() : T {
        return this ?: throw Interrupt()
    }

    class Interrupt : Exception()
}

/**
 * val result: Int? =
 *      nullable {
 *          a.bind() + b.bind() + c.bind()
 *      }
 */
inline fun <R> nullable(block: NullableComprehension.() -> R) : R? {
    val context = NullableComprehension()
    return try {
        context.block()
    } catch (e: NullableComprehension.Interrupt) {
        null
    }
}

/**
 *  to avoid overriding unnecessary methods
 */
inline fun TextView.onTextChanged(crossinline action: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action.invoke(s.toString())
        }
    })
}