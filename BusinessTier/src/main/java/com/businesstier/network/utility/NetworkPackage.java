package com.businesstier.network.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkPackage {
    @JsonProperty
    private NetworkType Type;
    @JsonProperty
    private String Content;

    public NetworkPackage(NetworkType type, String content) {
        this.Type = type;
        this.Content = content;
    }

    public NetworkType getType() {
        return Type;
    }

    public String getContent() {
        return Content;
    }

    @Override
    public String toString() {
        return "NetworkPackage{" + "type=" + Type + ", content=" + Content + '}';
    }

}
