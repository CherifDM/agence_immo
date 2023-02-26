package com.deme.agence_immo.database;

import com.deme.agence_immo.database.communs.CriteriaQueryBuilder;
import com.deme.agence_immo.database.communs.QueryOperator;
import com.deme.agence_immo.logement.Logement;
import com.deme.agence_immo.logement.LogementCriteria;
import com.deme.agence_immo.offre.Offre;
import com.deme.agence_immo.offre.OffreCriteria;
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

    /*LOGEMENTS*/

    private Logement getLogementFromQueryResultat(ResultSet res) throws SQLException {
        return new Logement(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getInt(6),res.getString(7),res.getInt(8),res.getString(9),res.getInt(10));
    }
    private Logement getLogementFromJoinQueryResultat(ResultSet res) throws SQLException {
        return new Logement(res.getInt(9),res.getInt(10),res.getInt(11),res.getString(12),res.getString(13),res.getInt(14),res.getString(15),res.getInt(16),res.getString(17),res.getInt(18));
    }


    public Logement getLogementById(String logementId) throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from logement where Num_logement  ='"+logementId+"';");
        while(res.next()){
            return getLogementFromQueryResultat(res);
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
        ResultSet res = st.executeQuery("SELECT * from logement ;");
        List logements = new ArrayList();
        while(res.next()){
            logements.add(getLogementFromQueryResultat(res));
        }
        return logements;
    }

    private String buildLogementCriteriaSQL(LogementCriteria logementCriteria, CriteriaQueryBuilder criteriaQueryBuilder) {
        StringBuilder sqlBuilder = new StringBuilder();
        if(logementCriteria == null) return "";
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.num_logement", QueryOperator.EQUAL, logementCriteria.getNum_logement()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.nombre_pieces", QueryOperator.SUPERIOR, logementCriteria.getNombre_pieces()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.Surface_habitable", QueryOperator.SUPERIOR, logementCriteria.getMin_Surface_habitable()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.Surface_habitable", QueryOperator.INFERIOR, logementCriteria.getMax_Surface_habitable()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.id_display_pic", QueryOperator.EQUAL, logementCriteria.getId_display_pic()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.numero", QueryOperator.EQUAL, logementCriteria.getNumero()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.rue", QueryOperator.EQUAL, logementCriteria.getRue()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.code_postal", QueryOperator.EQUAL, logementCriteria.getCode_postal()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.num_proprio", QueryOperator.EQUAL, logementCriteria.getNum_proprio()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.nombre_pieces", QueryOperator.SUPERIOR, logementCriteria.getMin_Surface_habitable()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("L.nombre_pieces", QueryOperator.INFERIOR, logementCriteria.getMax_Surface_habitable()));
        sqlBuilder.append(criteriaQueryBuilder.buildQueryWithArray("L.type_loge",  logementCriteria.getType_loge()));
        sqlBuilder.append(criteriaQueryBuilder.buildQueryWithArray("L.ville",  logementCriteria.getVille()));
        return sqlBuilder.toString();
    }

    /*OFFRES*/

    private Offre getOffreFromQueryResultat(ResultSet res, Logement logement) throws SQLException {
        return new Offre(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getDate(5),res.getDate(6),res.getInt(7), logement,res.getInt(8));
    }

    private String buildOffreCriteriaSQL(OffreCriteria offreCriteria, CriteriaQueryBuilder criteriaQueryBuilder){
        StringBuilder sqlBuilder = new StringBuilder();
        if(offreCriteria == null) return "";
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("O.Id_offre", QueryOperator.EQUAL, offreCriteria.getId_offre()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("O.Num_logement", QueryOperator.EQUAL, offreCriteria.getNum_logement()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("O.Disponible", QueryOperator.EQUAL, offreCriteria.getDisponible()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("O.montant", QueryOperator.SUPERIOR, offreCriteria.getMinMontant()));
        sqlBuilder.append(criteriaQueryBuilder.buildQuery("O.montant", QueryOperator.INFERIOR, offreCriteria.getMaxMontant()));
        sqlBuilder.append(criteriaQueryBuilder.buildQueryWithArray("O.objectif", offreCriteria.getObjectif()));
        sqlBuilder.append(criteriaQueryBuilder.buildQueryWithArray("O.etat", offreCriteria.getEtat()));
        return sqlBuilder.toString();
    }

    public Offre getOffreById(String offreId) throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from offre where Id_offre  ='"+offreId+"';");
        while(res.next()){
            return getOffreFromQueryResultat(res, null);
        }
        return null;
    }
    public List<Offre> getOffresByCriteria(OffreCriteria offreCriteria) throws SQLException {
        Statement st = connexion();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * FROM Offre AS O INNER JOIN Logement AS L ON O.Num_logement = L.Num_logement ");
        CriteriaQueryBuilder criteriaQueryBuilder = new CriteriaQueryBuilder();
        sqlBuilder.append(buildOffreCriteriaSQL(offreCriteria, criteriaQueryBuilder));
        sqlBuilder.append(buildLogementCriteriaSQL(offreCriteria.getLogementCriteria(), criteriaQueryBuilder));
        sqlBuilder.append(";");
        ResultSet res = st.executeQuery(sqlBuilder.toString());
        List offres = new ArrayList();
        while(res.next()){
            Logement logement = getLogementFromJoinQueryResultat(res);
            offres.add(getOffreFromQueryResultat(res,logement));
        }
        return offres;
    }

    public List<Offre> getAllOffres() throws SQLException {
        Statement st = connexion();
        ResultSet res = st.executeQuery("SELECT * from offre AS O INNER JOIN Logement AS L ON O.Num_logement = L.Num_logement WHERE O.Disponible = 1;");
        List offres = new ArrayList();
        while(res.next()){
            Logement logement = getLogementFromJoinQueryResultat(res);
            offres.add(getOffreFromQueryResultat(res, logement));
        }
        return offres;
    }
}
