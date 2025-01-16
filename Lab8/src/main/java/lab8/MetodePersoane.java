package lab8;

import java.sql.*;

public class MetodePersoane {
    private final Connection con;
    public MetodePersoane(Connection con) {
        this.con = con;
    }

    public void adaugaPersoana(String nume,int varsta) throws SQLException{
        try{
            if(varsta < 0 || varsta > 120){
                throw new IllegalArgumentException("Varsta nu este un numar valid!");
            }
            String query = "INSERT INTO persoane (nume,varsta) VALUES (?,?)";
            try(PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1, nume);
                ps.setInt(2, varsta);
                ps.executeUpdate();
                System.out.println("Persoana a fost adaugata!");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void afisareExcursiiPersoana() throws SQLException{
        String query = """
                SELECT p.id AS id_persoane, p.nume, p.varsta, e.destinatie, e.anul FROM persoane p
                LEFT JOIN excursii e ON p.id = e.id_persoane
                ORDER BY p.id""";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();

            int idCurent = -1;
            while(rs.next()){
                int id = rs.getInt("id_persoane");
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                String destinatia = rs.getString("destinatie");
                int anul = rs.getInt("anul");

                if (id != idCurent){
                    idCurent = id;
                    System.out.println("Persoana: " + nume+ ", " + varsta +", ");
                }
                else if(destinatia != null) {
                    System.out.print(destinatia + ", " + anul);
                }
            }
        }
    }

    public void stergePersoana(int id) throws SQLException{
        String stergeExcursiilePersoanei = "DELETE FROM excursii WHERE id_persoane = ?";
        try(PreparedStatement ps = con.prepareStatement(stergeExcursiilePersoanei)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }

        String stergePersoana = "DELETE FROM PERSOANE WHERE id = ?";
        try(PreparedStatement ps = con.prepareStatement(stergePersoana)) {
            ps.setInt(1, id);
            int verificare = ps.executeUpdate();
            if (verificare > 0)
            {
                System.out.println("Stergere reusita id=" + id);
            }
            else {
                System.out.println("Id-ul nu exista!");
            }
        }
    }
}
