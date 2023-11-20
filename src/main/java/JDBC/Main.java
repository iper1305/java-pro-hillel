package JDBC;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HeroDao heroDao = new HeroDaoImpl();

        List<Hero> allHeroes = heroDao.findAll();
        System.out.println("All Heroes: " + allHeroes);

        List<Hero> heroesByName = heroDao.findByName("Superman");
        System.out.println("Heroes by Name: " + heroesByName);

        Hero newHero = new Hero();
        newHero.setName("Batman");
        newHero.setGender("Male");
        heroDao.create(newHero);

        Hero heroToUpdate = allHeroes.get(0);
        heroToUpdate.setWeight(220);
        heroDao.update(heroToUpdate);

        Long idToDelete = allHeroes.get(1).getId();
        boolean deleted = heroDao.delete(idToDelete);
        System.out.println("Hero deleted: " + deleted);
    }
}

