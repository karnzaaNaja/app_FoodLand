package com.example.msi_gl62.karn.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class FoodModel(val food_name: String? = null,
                     val food_type: String? = null,
                     val detail: String? = null,
                     val image: String? = null,
                     val ingredients: String? = null,
                     val vote: String? = null,
                     val Cooking_Recipe: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(food_name)
        writeString(food_type)
        writeString(detail)
        writeString(image)
        writeString(ingredients)
        writeString(vote)
        writeString(Cooking_Recipe)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FoodModel> = object : Parcelable.Creator<FoodModel> {
            override fun createFromParcel(source: Parcel): FoodModel = FoodModel(source)
            override fun newArray(size: Int): Array<FoodModel?> = arrayOfNulls(size)
        }
    }
}

data class ListFood(@SerializedName("data") var results: List<FoodModel>? = null)