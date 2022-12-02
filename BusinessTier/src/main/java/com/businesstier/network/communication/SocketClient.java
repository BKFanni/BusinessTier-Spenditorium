package com.businesstier.network.communication;

import com.businesstier.network.utility.NetworkPackage;

public interface SocketClient {
    void startClient();
    String communicate(NetworkPackage networkPackage);
    void disconnect();
}
