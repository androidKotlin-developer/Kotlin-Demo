package com.example.kotlin_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_1.dataclass.Category


class CategoryViewModel  : ViewModel {

    constructor() : super()

    var id =""
    var tittle = ""
    var desc = ""

    constructor(category: Category) : super() {
        this.id = category.id
        this.tittle = category.tittle
        this.desc = category. desc
    }

    var Arraylistlivedata = MutableLiveData<ArrayList<CategoryViewModel>>()
    var arraylist = ArrayList<CategoryViewModel>()
    fun  getArraylist() : MutableLiveData<ArrayList<CategoryViewModel>>{

        var category1 = Category("1","Java","Java is a programming language and computing platform first released by Sun Microsystems in 1995. It has evolved from humble beginnings to power a large share of today’s digital world, by providing the reliable platform upon which many services and applications are built. New, innovative products and digital services designed for the future continue to rely on Java, as well.")
        var category2 = Category("2","Kotlin","Kotlin is a general purpose, free, open source, statically typed “pragmatic” programming language initially designed for the JVM (Java Virtual Machine) and Android that combines object-oriented and functional programming features. It is focused on interoperability, safety, clarity, and tooling support. Versions of Kotlin targeting JavaScript ES5.1 and native code (using LLVM) for a number of processors are in production as well.")


        val CategoryViewModel1 : CategoryViewModel  =  CategoryViewModel(category1)
        val CategoryViewModel2 : CategoryViewModel  =  CategoryViewModel(category2)


        arraylist.add(CategoryViewModel1)
        arraylist.add(CategoryViewModel2)

        Arraylistlivedata.value = arraylist

        return Arraylistlivedata








    }

}


