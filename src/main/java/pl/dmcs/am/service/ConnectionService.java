package pl.dmcs.am.service;

import pl.dmcs.am.domain.Address;
import pl.dmcs.am.domain.Connection;

import java.util.List;

public interface ConnectionService {
    public void addConnection(Connection connection);
    public void editConnection(Connection connection);
    public List<Connection> listConnection();
    public void removeConnection(long id);
    public Connection getConnection(long id);
}
