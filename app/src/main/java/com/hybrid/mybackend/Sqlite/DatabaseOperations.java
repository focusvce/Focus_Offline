package com.hybrid.mybackend.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by adarsh on 4/7/16.
 */
public class DatabaseOperations extends SQLiteOpenHelper {


    Html_Test_Const html_test_const = new Html_Test_Const();
    User_Const user_const = new User_Const();
    Likes_Const likes_const = new Likes_Const();
    Comments_Const comments_const = new Comments_Const();
    Post_Const post_const= new Post_Const();
    String create_html_test = "CREATE TABLE " + html_test_const.getTable_name() + "(" +
            html_test_const.getSr_key() + " INTEGER PRIMARY KEY," +
            html_test_const.getLink() + " VARCHAR(200)," +
            html_test_const.getTitle() + " VARCHAR(50)," +
            html_test_const.getDescription() + " VARCHAR(200)," +
            html_test_const.getUp_down() + " INTEGER," +
            html_test_const.getComment_count() + " INTEGER," +
            html_test_const.getUid() + " INTEGER," +
            html_test_const.getDate() + " DATE);";

    String create_user = "CREATE TABLE " + user_const.getTable_name() + "(" +
            user_const.getUser_id() + " INTEGER PRIMARY KEY," +
            user_const.getUser_name() + " VARCHAR(30)," +
            user_const.getUser_email() + " VARCHAR(50)," +
            user_const.getUser_password() + " VARCHAR(50)," +
            user_const.getUser_status() + " VARCHAR(50)," +
            user_const.getUser_description() + " VARCHAR(200)," +
            user_const.getUser_pic() + " VARCHAR(200));";
    String create_like = "CREATE TABLE " + likes_const.getTable_name() + "(" +
            likes_const.getLogin_id() + " INTEGER," +
            likes_const.getPost_id() + " INTEGER," +
            likes_const.getLike_or_not() + " INTEGER," +
            likes_const.getLike_status() + " INTEGER);";
    String create_comment = "CREATE TABLE " + comments_const.getTable_name() + "(" +
            comments_const.getUid() + " INTEGER," +
            comments_const.getPid() + " INTEGER," +
            comments_const.getComment() + " VARCHAR(200));";

    String create_post="CREATE TABLE "+post_const.getTablename()+ "("+
            post_const.getTitle()+" VARCHAR(50),"+
            post_const.getLink()+" VARCHAR(200),"+
            post_const.getDescription()+" VARCHAR(200),"+
            post_const.getDop()+" VARCHAR(20),"+
            post_const.getUser_name()+" VARCHAR(50),"+
            post_const.getUser_pic()+" VARCHAR(200),"+
            post_const.getSr_key()+" INTEGER,"+
            post_const.getUp()+" INTEGER,"+
            post_const.getComment_count()+" INTEGER,"+
            post_const.getUid()+" INTEGER);";
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    public DatabaseOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_html_test);
        sqLiteDatabase.execSQL(create_user);
        sqLiteDatabase.execSQL(create_like);
        sqLiteDatabase.execSQL(create_comment);
        sqLiteDatabase.execSQL(create_post);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void delete_post(DatabaseOperations databaseOperations){
        SQLiteDatabase sqLiteDatabase = databaseOperations.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ post_const.getTablename());
    }
    public void delete_all(DatabaseOperations databaseOperations) {
        SQLiteDatabase sqLiteDatabase = databaseOperations.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + html_test_const.getTable_name());
        sqLiteDatabase.execSQL("delete from " + user_const.getTable_name());
        sqLiteDatabase.execSQL("delete from " + likes_const.getTable_name());
        sqLiteDatabase.execSQL("delete from " + comments_const.getTable_name());
    }

    public void putInfo_Post(DatabaseOperations dp,String title,String link,String description,String dop
    ,String user_name,String user_pic,int sr_key,int up,int comment_count,int uid){
        SQLiteDatabase sqLiteDatabase = dp.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(post_const.getTitle(),title);
        cv.put(post_const.getLink(),link);
        cv.put(post_const.getDescription(),description);
        cv.put(post_const.getDop(),dop);
        cv.put(post_const.getUser_name(),user_name);
        cv.put(post_const.getUser_pic(),user_pic);
        cv.put(post_const.getSr_key(),sr_key);
        cv.put(post_const.getUp(),up);
        cv.put(post_const.getComment_count(),comment_count);
        cv.put(post_const.getUid(),uid);
        sqLiteDatabase.insert(post_const.getTablename(),null,cv);
    }

    public void putInfo_Comment(DatabaseOperations dop, int uid, int pid, String comment) {
        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(comments_const.getUid(), uid);
        cv.put(comments_const.getPid(), pid);
        cv.put(comments_const.getComment(), comment);
        sqLiteDatabase.insert(comments_const.getTable_name(), null, cv);
    }

    public void putInfo_Like(DatabaseOperations dop, int uid, int pid, int flag, int flagd) {
        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(likes_const.getLogin_id(), uid);
        cv.put(likes_const.getPost_id(), pid);
        cv.put(likes_const.getLike_or_not(), flag);
        cv.put(likes_const.getLike_status(), flagd);
        sqLiteDatabase.insert(likes_const.getTable_name(), null, cv);
    }

    public void putInfo_Users(DatabaseOperations dop, String uname, String uemail, String upass, String ustatus, String udesc, String upic) {
        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(user_const.getUser_name(), uname);
        cv.put(user_const.getUser_email(), uemail);
        cv.put(user_const.getUser_password(), upass);
        cv.put(user_const.getUser_status(), ustatus);
        cv.put(user_const.getUser_description(), udesc);
        cv.put(user_const.getUser_pic(), upic);
        sqLiteDatabase.insert(user_const.getTable_name(), null, cv);
    }

    public void putInfo_HtmlTest(DatabaseOperations dop, String link, String title, String desc, int up, int comment, int uid, String d) {
        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(html_test_const.getLink(), link);
        cv.put(html_test_const.getTitle(), title);
        cv.put(html_test_const.getDescription(), desc);
        cv.put(html_test_const.getUp_down(), up);
        cv.put(html_test_const.getComment_count(), comment);
        cv.put(html_test_const.getUid(), uid);
        cv.put(html_test_const.getDate(), d);
        sqLiteDatabase.insert(html_test_const.getTable_name(), null, cv);

    }
    public Cursor getInfo_Post(DatabaseOperations dop){
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String columns[]={post_const.getTitle(),post_const.getLink(),post_const.getDescription(),
        post_const.getDop(),post_const.getUser_name(),post_const.getUser_pic(),post_const.getSr_key(),
        post_const.getUp(),post_const.getComment_count(),post_const.getUid()};
        Cursor cr = sqLiteDatabase.query(post_const.getTablename(),columns,null,null,null,null,null);
        return cr;
    }
    public Cursor getInfo_Comment(DatabaseOperations dop) {
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String columns[] = {comments_const.getUid(), comments_const.getPid(), comments_const.getComment()};
        Cursor cr = sqLiteDatabase.query(comments_const.getTable_name(), columns, null, null, null, null, null);
        return cr;
    }

    public Cursor getInfo_Like(DatabaseOperations dop) {
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String columns[] = {likes_const.getLogin_id(), likes_const.getPost_id(),
                likes_const.getLike_or_not(), likes_const.getLike_status()};
        Cursor cr = sqLiteDatabase.query(likes_const.getTable_name(), columns, null, null, null, null, null);
        return cr;
    }

    public Cursor getInfo_Users(DatabaseOperations dop) {
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String columns[] = {user_const.getUser_id(), user_const.getUser_name(), user_const.getUser_email(),
                user_const.getUser_password(), user_const.getUser_status(), user_const.getUser_description(),
                user_const.getUser_pic()};
        Cursor cr = sqLiteDatabase.query(user_const.getTable_name(), columns, null, null, null, null, null);
        return cr;
    }

    public Cursor getInfo_HmtlTest(DatabaseOperations dop) {
        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();
        String columns[] = {html_test_const.getSr_key(), html_test_const.getLink(), html_test_const.getTitle(),
                html_test_const.getDescription(), html_test_const.getUp_down(), html_test_const.getComment_count(),
                html_test_const.getDate()};
        Cursor cr = sqLiteDatabase.query(html_test_const.getTable_name(), columns, null, null, null, null, null);
        return cr;
    }

    public class Comments_Const {
        String pid = "pid";
        String uid = "uid";
        String comment = "comment";
        String table_name = "comments";

        public String getTable_name() {
            return table_name;
        }

        public String getPid() {
            return pid;
        }

        public String getUid() {
            return uid;
        }

        public String getComment() {
            return comment;
        }
    }

    public class Likes_Const {
        String table_name = "likes";
        String login_id = "login_id";
        String post_id = "post_id";
        String like_or_not="like_or_not";
        String like_status="like_status";

        public String getTable_name() {
            return table_name;
        }

        public String getLogin_id() {
            return login_id;
        }

        public String getPost_id() {
            return post_id;
        }

        public String getLike_or_not() {
            return like_or_not;
        }

        public String getLike_status() {
            return like_status;
        }
    }

    public class User_Const {
        String table_name = "users";
        String user_id = "user_id";
        String user_name = "user_name";
        String user_email = "user_email";
        String user_password = "user_password";
        String user_status = "user_status";
        String user_description = "user_description";
        String user_pic = "user_pic";

        public String getTable_name() {
            return table_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getUser_email() {
            return user_email;
        }

        public String getUser_password() {
            return user_password;
        }

        public String getUser_status() {
            return user_status;
        }

        public String getUser_description() {
            return user_description;
        }

        public String getUser_pic() {
            return user_pic;
        }
    }

    public class Html_Test_Const {
        String table_name = "html_test";
        String sr_key = "sr_key";
        String link = "link";
        String title = "title";
        String description = "description";
        String up_down = "up_down";
        String comment_count = "comment_count";
        String uid = "uid";
        String date = "date";

        Html_Test_Const() {

        }

        public String getTable_name() {
            return table_name;
        }

        public String getSr_key() {
            return sr_key;
        }

        public String getLink() {
            return link;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getUp_down() {
            return up_down;
        }

        public String getComment_count() {
            return comment_count;
        }

        public String getUid() {
            return uid;
        }

        public String getDate() {
            return date;
        }
    }
    public class Post_Const{
        String tablename="post";
        String title="title";
        String link="link";
        String description="description";
        String dop ="dop";
        String user_name="user_name";
        String user_pic="user_pic";
        String sr_key="sr_key";
        String up="up";
        String comment_count="comment_count";
        String uid="uid";

        public String getTablename() {
            return tablename;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getDescription() {
            return description;
        }

        public String getDop() {
            return dop;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getUser_pic() {
            return user_pic;
        }

        public String getSr_key() {
            return sr_key;
        }

        public String getUp() {
            return up;
        }

        public String getComment_count() {
            return comment_count;
        }

        public String getUid() {
            return uid;
        }
    }

}
