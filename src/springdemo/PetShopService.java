package springdemo;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/22.
 */
public class PetShopService {

    private IPetDao petDao;

    public IPetDao getPetDao() {

        return petDao;
    }

    public void setPetDao(IPetDao value) {

        petDao = value;
    }

    public String getPetName(int id) {

        return petDao.getPetName(id);
    }

}
