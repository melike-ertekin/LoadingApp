package com.example.loadingapp


sealed class ButtonState(var buttonText: Int) {
    object Default : ButtonState(R.string.custom_button_text_default)
    object Loading : ButtonState(R.string.custom_button_text_loading)
    object Completed : ButtonState(R.string.custom_button_text_completed)
}

