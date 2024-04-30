package com.neo.chatbot.api.domain.ai.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReplyDTO {
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("text")
    private String text;
    @JsonProperty("textList")
    private Object textList;
    @JsonProperty("clarifyGuide")
    private Object clarifyGuide;
    @JsonProperty("replySource")
    private String replySource;
    @JsonProperty("showDocumentSource")
    private Object showDocumentSource;
    @JsonProperty("documents")
    private Object documents;
    @JsonProperty("docDebug")
    private Object docDebug;
    @JsonProperty("faqSearch")
    private Object faqSearch;
    @JsonProperty("slotCollectInfo")
    private Object slotCollectInfo;
}
