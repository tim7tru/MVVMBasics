package com.timmytruong.retrofitkotlinexampleapp.utils

object CommonUtils
{
    fun formatString(formatTemplate: String, input1: String, input2: String): String
    {
        return String.format(formatTemplate, input1, input2)
    }
}