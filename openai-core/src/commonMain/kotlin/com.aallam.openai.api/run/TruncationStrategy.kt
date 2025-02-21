package com.aallam.openai.api.run

import com.aallam.openai.api.BetaOpenAI
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Controls for how a thread will be truncated prior to the run. Use this to control the initial context window of the run.
 */
@BetaOpenAI
@Serializable
@SerialName("truncation_strategy")
public sealed interface TruncationStrategy {
    @BetaOpenAI
    @Serializable
    @SerialName("last_messages")
    public class LastMessagesTruncationStrategy(
        @SerialName("last_messages")
        public val lastMessages: Int,
    ) : TruncationStrategy
}
