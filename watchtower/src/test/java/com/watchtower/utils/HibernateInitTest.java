package com.watchtower.utils;

import org.hibernate.SessionFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateInitTest {

    @Test
    public void testSessionFactoryInitialization() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            assertNotNull("SessionFactory should not be null", sessionFactory);
            
            // Verify User entity is recognized
            boolean hasUser = sessionFactory.getMetamodel().getEntities().stream()
                    .anyMatch(e -> e.getName().equals("User"));
            
            assertTrue("Entity 'User' should be recognized by Hibernate", hasUser);
            System.out.println("Hibernate successfully recognized 'User' entity.");
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("SessionFactory initialization failed: " + e.getMessage());
        }
    }
}
