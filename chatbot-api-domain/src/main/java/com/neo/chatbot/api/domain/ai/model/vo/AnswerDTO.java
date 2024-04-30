package com.neo.chatbot.api.domain.ai.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neo.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnswerDTO {
    @JsonProperty("chunkId")
    private Integer chunkId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("topicId")
    private String topicId;
    @JsonProperty("blockId")
    private String blockId;
    @JsonProperty("nodeId")
    private String nodeId;
    @JsonProperty("reply")
    private ReplyDTO reply;
}
