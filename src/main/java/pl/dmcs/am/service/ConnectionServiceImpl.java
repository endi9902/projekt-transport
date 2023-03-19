package pl.dmcs.am.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.am.dao.ConnectionRepository;
import pl.dmcs.am.domain.Address;
import pl.dmcs.am.domain.Connection;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("connectionService")
@Transactional
public class ConnectionServiceImpl implements ConnectionService {

    private ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionServiceImpl(ConnectionRepository connectionRepository){this.connectionRepository = connectionRepository;}

    @Transactional
    public void addConnection(Connection connection){connectionRepository.save(connection);}

    @Transactional
    public void editConnection(Connection connection){connectionRepository.save(connection);}

    @Transactional
    public List<Connection> listConnection(){ return connectionRepository.findAll();}

    @Transactional
    public void removeConnection(long id) {
        connectionRepository.delete(id);
    }

    @Transactional
    public Connection getConnection(long id) {
        return connectionRepository.findById(id);
    }

//    @Transactional
//    public List<Connection> listConnectionFiltered(String startStation, String endStation, Date date){
//        return connectionRepository.findAll();
//    }
}
