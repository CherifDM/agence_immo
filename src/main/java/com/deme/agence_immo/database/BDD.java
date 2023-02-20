package com.deme.agence_immo.database;

import com.deme.agence_immo.logement.Logement;
import com.deme.agence_immo.logement.LogementCriteria;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * MYSQL implementation of the IDatabase class
 */
@Service
public class BDD {
    private static final String url = "jdbc:mysql://localhost:3306/agence_immo";
    private static final String username = "root";
    private static final String password = "";
    private static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static Statement connexion() throws SQLException {
        return con.createStatement();
    }

    static PreparedStatement connexion(String sql) throws SQLException {
        return con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    /*USER*/



    /*RESSOURCE*/
/*
    private Image getRessourceFromQueryResultat(ResultSet res) throws SQLException {
        return new Image(res.getString(1), res.getString(8), res.getString(2), res.getString(3), res.getString(4), null, res.getDate(5), res.getString(6), res.getBoolean(7));
    }

    private User getUserWithAuthFromQueryResultat(ResultSet res) throws SQLException {
        return new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
    }

    private User getUserFromQueryResultat(ResultSet res) throws SQLException {
        return new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5), "");
    }

    private Video getVideoFromQueryResultat(IRessource ressource, ResultSet res) throws SQLException {
        return new Video(ressource.getId(),ressource.getId_author(), ressource.getAuthorName(), ressource.getTitle(),ressource.getDescription(),ressource.getCategoryIds(),ressource.getUploadDate(),ressource.getFileName(),ressource.isPrivate(), res.getString(2), res.getInt(3), res.getInt(4));
    }

    private Category getCategoryFromQueryResultat(ResultSet res) throws SQLException {
        return new Category(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
    }

    public IRessource setRessourceCategories(IRessource ressource) throws SQLException {
        List<String> categoryIds = new ArrayList<>();
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from categoryressources where IdRessource  ='"+ressource.getId()+"';");
        while(res.next()){
            categoryIds.add(res.getString(1));
        }
        ressource.setCategoryIds(categoryIds);
        return ressource;
    }

    public IRessource getRessourceById(String ressourceId) throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from ressource where IdRessource  ='"+ressourceId+"';");
        while(res.next()){
            IRessource ressource = getRessourceFromQueryResultat(res);
            return setRessourceCategories(ressource);
        }
        return null;
    }


    public IRessource insertRessource(IRessource ressource) throws SQLException {
        System.out.println("Inserting into ressources");
        String sql = "INSERT INTO Ressource(IdRessource,id_author,AuthorName,Title,Description, UploadDate, FileName, IsPrivate) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connexion(sql);
        preparedStatement.setString(1, ressource.getId());
        preparedStatement.setString(2, ressource.getId_author());
        preparedStatement.setString(3, ressource.getAuthorName());
        preparedStatement.setString(4, ressource.getTitle());
        preparedStatement.setString(5, ressource.getDescription());
        preparedStatement.setDate(6, new java.sql.Date(ressource.getUploadDate().getTime()));
        preparedStatement.setString(7, ressource.getFileName());
        preparedStatement.setBoolean(8, ressource.isPrivate());
        preparedStatement.executeUpdate();
        System.out.println("Succesfully added ressource : " + ressource.getFileName());
        return ressource;
    }


    /*VIDEOS*/
/*
    @Override
    public Video insertVideo(Video video) throws SQLException {
        String videoUUID = UUID.randomUUID().toString();
        video.setId(videoUUID);
        String sql = "INSERT INTO Video(IdRessource,IdThumbnailImage, Duration ,NbViews) VALUES(?,?,?,?)";
        insertRessource(video);
        PreparedStatement preparedStatement = connexion(sql);
        preparedStatement.setString(1, video.getId());
        preparedStatement.setString(2, video.getIdThumbnailImage());
        preparedStatement.setInt(3, video.getDuration());
        preparedStatement.setInt(4, video.getNbViews());
        preparedStatement.executeUpdate();
        for (String categoryId:video.getCategoryIds()) {
            insertRessourceCategories(video.getId(), categoryId);
        }
        System.out.println("Succesfully added video : " + video.getFileName());
        return video;
    }

    @Override
    public Video getVideoById(String videoId) throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from video where IdRessource  ='"+videoId+"';");
        while(res.next()){
            IRessource iRessource = getRessourceById(videoId);
            return getVideoFromQueryResultat(iRessource, res);
        }
        return null;
    }

    @Override
    public List<Video> getAllVideos() throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from video ;");
        List videos = new ArrayList();
        while(res.next()){
            IRessource iRessource = getRessourceById(res.getString(1));
            videos.add(getVideoFromQueryResultat(iRessource, res));
        }
        return videos;

    }*/




    public Logement getLogementById(String logementId) throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from video where IdRessource  ='"+logementId+"';");
        while(res.next()){
            //IRessource iRessource = getRessourceById(videoId);
            //return getVideoFromQueryResultat(iRessource, res);
        }
        return null;
    }

    public List<Logement> getLogementsByCriteria(Logement logementCriteria) throws SQLException {
        Statement st = connexion();
        Class<?> clazz = logementCriteria.getClass();

        for(Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(logementCriteria);
                if(fieldValue != null){
                    System.out.println("fieldName : "+fieldName+" / Field Value : "+ fieldValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Logement> getAllLogements() throws SQLException {
        Statement st = connexion();
        getLogementsByCriteria(new Logement(5, "Paris"));
        return null;
    }
}
