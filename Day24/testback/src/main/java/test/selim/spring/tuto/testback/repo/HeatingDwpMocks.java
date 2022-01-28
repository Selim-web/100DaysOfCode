package test.selim.spring.tuto.testback.repo;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.selim.spring.tuto.testback.domain.HeatingDwp;
import test.selim.spring.tuto.testback.domain.RoomDigital;

import java.util.List;
import java.util.Random;

@Component
public class HeatingDwpMocks implements InitializingBean {

    @Autowired
    private HeatingDwpRepo heatingDwpRepo;

    @Autowired
    private RoomDigitalRepo roomDigitalRepo;

    @Override
    public void afterPropertiesSet() throws Exception {
        String [] mode = {"automatique", "manuel", "economique", "confort"};
        Random random = new Random();
        Faker faker = new Faker();
        List<RoomDigital> roomDigitalList = roomDigitalRepo.findAll();
        //System.out.println(roomDigitalList);
        for (RoomDigital room: roomDigitalList) {
            //System.out.println(room);
            String selectMode = mode[random.nextInt(mode.length)];
            //System.out.println(selectMode);
            HeatingDwp heatingDwp = new HeatingDwp(room.getIdRoom(),faker.bool().bool(),selectMode,faker.random().nextInt(7,30),room);
            heatingDwpRepo.save(heatingDwp);
        }

        List<HeatingDwp> heatingDwpList = heatingDwpRepo.findAll();
        //System.out.println(heatingDwpList);
        for (HeatingDwp heating: heatingDwpList) {
            heatingDwpRepo.insertScenario(heating.getId().intValue(),faker.random().nextInt(1,25),faker.random().nextInt(10,30));
        }
    }
}
