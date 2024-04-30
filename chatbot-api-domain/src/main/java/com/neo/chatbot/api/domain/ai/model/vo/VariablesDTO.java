package com.neo.chatbot.api.domain.ai.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VariablesDTO {
    @JsonProperty("LLM_rewrite_query")
    private String llmRewriteQuery;
    @JsonProperty("last_response")
    private String lastResponse;
    @JsonProperty("last_user_response")
    private String lastUserResponse;
}
