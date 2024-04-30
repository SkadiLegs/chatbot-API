package com.neo.chatbot.api.domain.ai;

import java.io.IOException;

public interface IOpenAI {
    String doUnit(String question)throws IOException;
}
