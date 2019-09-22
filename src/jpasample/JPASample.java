/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpasample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author x-tion
 */
public class JPASample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map properties = new HashMap();
        EntityManager em = javax.persistence.Persistence.createEntityManagerFactory("JPASamplePU", properties).createEntityManager();
        Query q = em.createNamedQuery("Tblcustomer.findAll");
        List<entities.Tblcustomer> lst = q.getResultList();
        em.close();
        System.out.println(lst.size());
    }

}
