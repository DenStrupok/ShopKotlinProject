package com.example.shopkotlinproject.pojo

import android.os.Parcel
import android.os.Parcelable

class Book(var name: String, val author: String, val price: Int, val image: Int, var number: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(author)
        parcel.writeInt(price)
        parcel.writeInt(image)
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Book(name='$name', author='$author', price=$price, image=$image, number=$number)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (name != other.name) return false
        if (author != other.author) return false
        if (price != other.price) return false
        if (image != other.image) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + price
        result = 31 * result + image
        result = 31 * result + number
        return result
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}