package pl.dmcs.am.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.am.domain.Connection;
import pl.dmcs.am.service.ConnectionService;

public class ConnectionConverter implements Converter<String, Connection> {

    private ConnectionService connectionService;

    @Autowired
    public ConnectionConverter(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public Connection convert(String source) {
        return connectionService.getConnection(Integer.parseInt(source));
    }
}
