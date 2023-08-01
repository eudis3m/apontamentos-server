package br.com.ibrowse.projeto.util;

public interface JsonParseable {

    default String toJson() {
        return JacksonUtils.toJson(this);
    }

}
