package pro.mynook.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Jaxichael on 2/16/2017.
 */
@Configuration
@Import({PropertyConfig.class, MvcConfig.class, DaoConfig.class, ControllerConfig.class})
public class MainConfig {
    @Autowired
    private DaoConfig daoConfig;

//    @Bean
//    public GameBoard gameBoard() {
//        return new GameBoard(this.daoConfig.pokemonLocationDao(), this.daoConfig.pokemonDao());
//    }
}
