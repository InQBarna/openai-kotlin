package com.aallam.openai.api.run

import com.aallam.openai.api.BetaOpenAI
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@BetaOpenAI
public sealed interface TemperatureParam

/**
 * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will
 * make the output more random, while lower values like 0.2 will make it more focused and deterministic.
 */
@BetaOpenAI
@Serializable
@JvmInline
public value class SamplingTemperature(public val temperature: Float): TemperatureParam {
    init {
        require(temperature in 0.0..2.0) { "Sampling temperature must be between 0 and 2" }
    }
}

/**
 * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass.
 * So 0.1 means only the tokens comprising the top 10% probability mass are considered.
 */
@BetaOpenAI
@Serializable
@JvmInline
public value class NucleusSamplingTemperature(public val percent: Int): TemperatureParam {
    init {
        require(percent in 0..100) { "Nucleus sampling temperature must be between 0 and 100" }
    }
}
