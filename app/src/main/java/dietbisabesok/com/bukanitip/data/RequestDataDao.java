package dietbisabesok.com.bukanitip.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "REQUEST_DATA".
*/
public class RequestDataDao extends AbstractDao<RequestData, Long> {

    public static final String TABLENAME = "REQUEST_DATA";

    /**
     * Properties of entity RequestData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Budget = new Property(3, String.class, "budget", false, "BUDGET");
        public final static Property Status = new Property(4, int.class, "status", false, "STATUS");
        public final static Property Country_id = new Property(5, int.class, "country_id", false, "COUNTRY_ID");
        public final static Property Img_url = new Property(6, String.class, "img_url", false, "IMG_URL");
        public final static Property Jumlah_offering = new Property(7, int.class, "jumlah_offering", false, "JUMLAH_OFFERING");
        public final static Property Trending = new Property(8, int.class, "trending", false, "TRENDING");
        public final static Property Country_name = new Property(9, String.class, "country_name", false, "COUNTRY_NAME");
    }


    public RequestDataDao(DaoConfig config) {
        super(config);
    }
    
    public RequestDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"REQUEST_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL UNIQUE ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"DESCRIPTION\" TEXT," + // 2: description
                "\"BUDGET\" TEXT," + // 3: budget
                "\"STATUS\" INTEGER NOT NULL ," + // 4: status
                "\"COUNTRY_ID\" INTEGER NOT NULL ," + // 5: country_id
                "\"IMG_URL\" TEXT," + // 6: img_url
                "\"JUMLAH_OFFERING\" INTEGER NOT NULL ," + // 7: jumlah_offering
                "\"TRENDING\" INTEGER NOT NULL ," + // 8: trending
                "\"COUNTRY_NAME\" TEXT);"); // 9: country_name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REQUEST_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RequestData entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
 
        String budget = entity.getBudget();
        if (budget != null) {
            stmt.bindString(4, budget);
        }
        stmt.bindLong(5, entity.getStatus());
        stmt.bindLong(6, entity.getCountry_id());
 
        String img_url = entity.getImg_url();
        if (img_url != null) {
            stmt.bindString(7, img_url);
        }
        stmt.bindLong(8, entity.getJumlah_offering());
        stmt.bindLong(9, entity.getTrending());
 
        String country_name = entity.getCountry_name();
        if (country_name != null) {
            stmt.bindString(10, country_name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RequestData entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
 
        String budget = entity.getBudget();
        if (budget != null) {
            stmt.bindString(4, budget);
        }
        stmt.bindLong(5, entity.getStatus());
        stmt.bindLong(6, entity.getCountry_id());
 
        String img_url = entity.getImg_url();
        if (img_url != null) {
            stmt.bindString(7, img_url);
        }
        stmt.bindLong(8, entity.getJumlah_offering());
        stmt.bindLong(9, entity.getTrending());
 
        String country_name = entity.getCountry_name();
        if (country_name != null) {
            stmt.bindString(10, country_name);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public RequestData readEntity(Cursor cursor, int offset) {
        RequestData entity = new RequestData( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // budget
            cursor.getInt(offset + 4), // status
            cursor.getInt(offset + 5), // country_id
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // img_url
            cursor.getInt(offset + 7), // jumlah_offering
            cursor.getInt(offset + 8), // trending
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // country_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RequestData entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBudget(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStatus(cursor.getInt(offset + 4));
        entity.setCountry_id(cursor.getInt(offset + 5));
        entity.setImg_url(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setJumlah_offering(cursor.getInt(offset + 7));
        entity.setTrending(cursor.getInt(offset + 8));
        entity.setCountry_name(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RequestData entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RequestData entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RequestData entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
