package main.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

import main.data.BaseEntity;
import main.dao.GeneralDAO;

@SuppressWarnings("serial")
@Service
public class GeneralService implements Serializable {

    public List<BaseEntity> retrieveAll(Class<? extends BaseEntity> cls)
    {
        GeneralDAO dao = new GeneralDAO();
        List<BaseEntity> es = dao.retrieveAll(cls);
        dao.terminate();
        return es;
    }

    public List<BaseEntity> retrieveActive(Class<? extends BaseEntity> cls)
    {
        GeneralDAO dao = new GeneralDAO();
        List<BaseEntity> es = dao.retrieveActive(cls);
        dao.terminate();
        return es;
    }

    public BaseEntity insert(BaseEntity e, String user)
    {
        GeneralDAO dao = new GeneralDAO();
        e.setAvaja(user);
        e.setVersion(e.getVersion() + 1);
        e = dao.insert(e);
        dao.terminate();
        return e;
    }

    public BaseEntity update(BaseEntity e, String user)
    {
        GeneralDAO dao = new GeneralDAO();
        e.setMuutja(user);
        e.setVersion(e.getVersion() + 1);
        e = dao.update(e);
        dao.terminate();
        return e;
    }
    
    public BaseEntity delete(BaseEntity e, String user)
    {
        GeneralDAO dao = new GeneralDAO();
        e.setSulgeja(user);
        e.setVersion(e.getVersion() + 1);
        e = dao.update(e);
        dao.terminate();
        return e;
    }

}
