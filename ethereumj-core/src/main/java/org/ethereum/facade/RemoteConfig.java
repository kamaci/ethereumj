package org.ethereum.facade;

import org.ethereum.db.BlockStore;
import org.ethereum.db.InMemoryBlockStore;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author: Roman Mandeleil
 * Created on: 27/01/2015 01:05
 */
@Configuration
@Import(CommonConfig.class)
public class RemoteConfig {

    @Autowired CommonConfig commonConfig;

    @Bean
    @Transactional(propagation = Propagation.SUPPORTS)
    public BlockStore blockStore(SessionFactory sessionFactory){

        BlockStore blockStore = new InMemoryBlockStore();
        blockStore.setSessionFactory(sessionFactory);
        return blockStore;
    }
}
