package springdemo;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/22.
 */
public class PetDao implements IPetDao {

    @Override
    public String getPetName(int petId) {

        return "Kitty";
    }
}
