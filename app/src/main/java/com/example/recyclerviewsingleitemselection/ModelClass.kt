package com.example.recyclerviewsingleitemselection

class ModelClass(var name: String, var isSelected: Boolean) {
    override fun toString(): String {
        return "ModelClass{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}'
    }
}