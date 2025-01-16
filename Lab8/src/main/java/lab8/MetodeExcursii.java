package lab8;

import java.sql.*;

public class MetodeExcursii {
    private final Connection connection;
    public MetodeExcursii(Connection connection) {
        this.connection = connection;
    }
    public void adaugaExcursii(int id_persoane,String destinatie,int anul) throws SQLException {
        try {
            if (anul < 1920 || anul > 2024){
                throw new SQLException("Anul introdus este invalid");}
            String verificaId = "SELECT * FROM persoane WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(verificaId)) {
                ps.setInt(1, id_persoane);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException("Nu exista persoane cu id-ul dat");
                    }
                }
            }
            String query = "INSERT INTO excursii (id_persoane, destinatie, anul) VALUES (?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id_persoane);
                ps.setString(2, destinatie);
                ps.setInt(3, anul);
                ps.executeUpdate();
                System.out.println("Excursie adaugata");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void afisareExcursiiPersoana(String nume) throws SQLException{
        String query = """
                SELECT e.destinatie, e.anul FROM excursii e
                JOIN persoane p ON e.id_persoane = p.id
                WHERE p.nume = ?;
                """;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nume);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String destinatie = rs.getString("destinatie");
                    int anul = rs.getInt("anul");
                    System.out.println(nume + ", "+ destinatie + ", " + anul);
                }
            }
        }
    }

    public void afiseazaPersoaneDestinatie(String destinatie) throws SQLException{
        String query = """
                SELECT DISTINCT p.nume, p.varsta FROM persoane p
                JOIN excursii e on p.id = e.id_persoane
                WHERE e.destinatie = ?;""";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, destinatie);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nume = rs.getString("nume");
                    String varsta = rs.getString("varsta");
                    System.out.println(destinatie+ ", " + nume + ", " + varsta);
                }
            }
        }
    }
    public void afiseazaPersoaneAn(int an ) throws SQLException{
        String query = """
                SELECT DISTINCT p.nume, p.varsta FROM persoane p
                JOIN excursii e on p.id = e.id_persoane
                WHERE e.anul = ?""";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, an);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nume = rs.getString("nume");
                    String varsta = rs.getString("varsta");
                    System.out.println(an + ", "+ nume + ", " + varsta);
                }
            }
        }
    }

    public void stergeExcursie(int id_excursii) throws SQLException{
        String q = "DELETE FROM excursii WHERE id_excursii = ?";
        try (PreparedStatement ps = connection.prepareStatement(q)) {
            ps.setInt(1, id_excursii);
            int sterse = ps.executeUpdate();
            if (sterse > 0){
                System.out.println("Excursie stearsa");
            }
            else {
                System.out.println("Eroare la stergerea excursiei");
            }
        }
    }


}
