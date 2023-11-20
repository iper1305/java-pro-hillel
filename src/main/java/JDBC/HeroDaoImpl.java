package JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/iryna";
    private static final String USER = "iryna_pe";
    private static final String PASSWORD = "iryna_123";

    @Override
    public List<Hero> findAll() {
        List<Hero> heroes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM heroes")) {

            while (resultSet.next()) {
                Hero hero = mapResultSetToHero(resultSet);
                heroes.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        List<Hero> heroes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM heroes WHERE name = ?")) {

            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Hero hero = mapResultSetToHero(resultSet);
                    heroes.add(hero);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    @Override
    public void create(Hero hero) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO heroes(name, gender, eyeColor, race, hairColor, height, publisher, " +
                             "skinColor, alignment, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, hero.getName());
            statement.setString(2, hero.getGender());
            statement.setString(3, hero.getEyeColor());
            statement.setString(4, hero.getRace());
            statement.setString(5, hero.getHairColor());
            statement.setDouble(6, hero.getHeight());
            statement.setString(7, hero.getPublisher());
            statement.setString(8, hero.getSkinColor());
            statement.setString(9, hero.getAlignment());
            statement.setInt(10, hero.getWeight());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero hero) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE heroes SET name=?, gender=?, eyeColor=?, race=?, hairColor=?, height=?, " +
                             "publisher=?, skinColor=?, alignment=?, weight=? WHERE id=?")) {

            statement.setString(1, hero.getName());
            statement.setString(2, hero.getGender());
            statement.setString(3, hero.getEyeColor());
            statement.setString(4, hero.getRace());
            statement.setString(5, hero.getHairColor());
            statement.setDouble(6, hero.getHeight());
            statement.setString(7, hero.getPublisher());
            statement.setString(8, hero.getSkinColor());
            statement.setString(9, hero.getAlignment());
            statement.setInt(10, hero.getWeight());
            statement.setLong(11, hero.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM heroes WHERE id=?")) {

            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Hero mapResultSetToHero(ResultSet resultSet) throws SQLException {
        Hero hero = new Hero();
        hero.setId(resultSet.getLong("id"));
        hero.setName(resultSet.getString("name"));
        hero.setGender(resultSet.getString("gender"));
        hero.setEyeColor(resultSet.getString("eyeColor"));
        hero.setRace(resultSet.getString("race"));
        hero.setHairColor(resultSet.getString("hairColor"));
        hero.setHeight(resultSet.getDouble("height"));
        hero.setPublisher(resultSet.getString("publisher"));
        hero.setSkinColor(resultSet.getString("skinColor"));
        hero.setAlignment(resultSet.getString("alignment"));
        hero.setWeight(resultSet.getInt("weight"));
        return hero;
    }
}

