package com.neo.chatbot.api.domain.ai.model.aggregates;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neo.chatbot.api.domain.ai.model.vo.AnswerDTO;
import com.neo.chatbot.api.domain.ai.model.vo.VariablesDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class AIAnswer {

    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("queryId")
    private String queryId;
    @JsonProperty("replyStatus")
    private Integer replyStatus;
    @JsonProperty("answer")
    private List<AnswerDTO> answer;
    @JsonProperty("variables")
    private VariablesDTO variables;
    @JsonProperty("endTime")
    private Object endTime;
    @JsonProperty("recommendList")
    private List<?> recommendList;
    @JsonProperty("rewriteQuery")
    private String rewriteQuery;
    @JsonProperty("intent")
    private Object intent;
}
