package com.example.kotlin_1.dataclass

class Category {

    var id =""
    var tittle = ""
    var desc = ""

    constructor(id: String, tittle: String, imagepath: String) {
        this.id = id
        this.tittle = tittle
        this.desc = imagepath
    }
}