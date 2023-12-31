package com.bizyback.play.recipe.datasources.local.entity

import kotlinx.serialization.Serializable
import java.sql.Timestamp
import java.util.Calendar
import java.util.Date

/**
 * @project : Recipe
 * @author  : mambo
 * @email   : mambobryan@gmail.com
 * @date    : Sun 31 December 2023
 * @time    : 5:45 pm
 */
@Serializable
data class QueryEntity(val value: String, val timestamp: Long = Date().time)