package edu.esprit.services;
import edu.esprit.entities.Post;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.esprit.utils.MyConnection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author afefz
 */
public class PostCRUD implements IService<Post> {
    Connection Cnx;
    public PostCRUD()
    {
      Cnx=MyConnection.getInstance().getCnx();
    }
   

    @Override
    public void ajouter(Post P) {
        try {
            String requete ="INSERT INTO post (titre,description ,dateDeCreation,dateExpiration ,salaire) "
                    +"VALUES (?,?,?,?,?)";
            PreparedStatement pst = Cnx.prepareStatement(requete);
            pst.setDate(3, (Date) P.getDateDeCreation());
            pst.setDate(4, (Date) P.getDateExpiration());
            pst.setString(2,P.getDescription());
            pst.setString(1,P.getTitre());
            pst.setInt(5, P.getSalaire());
            pst.executeUpdate();
            System.out.println("Post ajouté avec succes");
        
        
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        
        }    
    }

    @Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM post WHERE id=?";
            PreparedStatement pst = Cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Post supprimee !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Post P) {
        try {
            String requete = "UPDATE post SET titre=?,description=?,salaire=?,`dateDeCreation`=?,`dateExpiration`=?  WHERE id=?";
            PreparedStatement pst = Cnx.prepareStatement(requete);
            pst.setInt(6, P.getId());
            pst.setString(1, P.getTitre());
            pst.setString(2, P.getDescription());
            pst.setInt(3, P.getSalaire());
            pst.setDate(4, P.getDateDeCreation());
            pst.setDate(5, P.getDateExpiration());
            pst.executeUpdate();
            System.out.println("Post modifie !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public List<Post> afficher() {
        List<Post>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM post";
            Statement st = Cnx.prepareStatement(requet2);              
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                Post P = new Post();
                P.setId(rs.getInt(1));
                P.setDateDeCreation(rs.getDate("dateDeCreation"));
                P.setDateExpiration(rs.getDate("dateExpiration"));
                P.setDescription(rs.getString("description"));
                P.setTitre(rs.getString("titre"));
                P.setSalaire(rs.getInt("salaire"));
                myList.add(P);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;
    }
    public List<Post> triParSalaire(){
        return afficher().stream().sorted(Comparator.comparing(Post::getSalaire)).collect(Collectors.toList());
    }
    public List<Post> triParTitre(){
         List<Post>myList = new ArrayList<>();
        try {
            
            String requet2="SELECT * FROM post order by titre";
            Statement st = Cnx.prepareStatement(requet2);              
            ResultSet rs = st.executeQuery(requet2);
            while(rs.next()){
                Post P = new Post();
                P.setId(rs.getInt(1));
                P.setDateDeCreation(rs.getDate("dateDeCreation"));
                P.setDateExpiration(rs.getDate("dateExpiration"));
                P.setDescription(rs.getString("description"));
                P.setTitre(rs.getString("titre"));
                P.setSalaire(rs.getInt("salaire"));
                myList.add(P);
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
        return myList;
    }
}
