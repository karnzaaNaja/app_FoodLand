package com.example.msi_gl62.karn.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.CursorLoader
import android.view.View
import android.view.ViewPropertyAnimator
import android.widget.ImageView
import okhttp3.MediaType
import okhttp3.RequestBody

infix fun ImageView.load(url: String?) = this.apply {
    com.bumptech.glide.Glide.with(context).load(url).into(this)
}

fun View.simpleFadeInAnimation() = let {
    this.animate()
            .alpha(1.0f)
            .setListener(null)
    this.show()
}



@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun String?.requestBody(): RequestBody = RequestBody.create(MediaType.parse("text/plain"), (this
        ?: ""))

fun View.simpleFadeOutAnimation(): ViewPropertyAnimator = let {
    this.animate()
            .alpha(0.0f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    this@simpleFadeOutAnimation.hide()
                }
            })
}

fun View.hide() = let {
    this.visibility = View.GONE
}

fun View.show() = let {
    this.visibility = View.VISIBLE
}

fun Uri.getPath(context: Context): String? {
    val arrData = arrayOf(MediaStore.Images.Media.DATA)
    val loader = CursorLoader(context, this, arrData, null, null, null)
    val cursor = loader.loadInBackground()
    val columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    cursor?.moveToFirst()
    val result = columnIndex?.let { cursor.getString(it) }
    cursor?.close()
    return result
}






