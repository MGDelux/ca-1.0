package facades;

import dtos.SolidCodeDTO;
import entities.SolidCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public SolidCodeDTO create(SolidCodeDTO rm){
        SolidCode rme = new SolidCode(rm.getNavn(),rm.getStudentId(),rm.getFavTvShow());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new SolidCodeDTO(rme);
    }
    public SolidCodeDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new SolidCodeDTO(em.find(SolidCode.class, id));
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM SolidCode r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<SolidCodeDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<SolidCode> query = em.createQuery("SELECT r FROM SolidCode r", SolidCode.class);
        List<SolidCode> rms = query.getResultList();
        return SolidCodeDTO.getDtos(rms);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacade(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }

}
