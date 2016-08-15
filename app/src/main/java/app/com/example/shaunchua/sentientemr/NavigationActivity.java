package app.com.example.shaunchua.sentientemr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ProfilePictureView;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //private ImageView profile_pic;
    private String pictureUri;
    private LoginResult loginResult;
    private DrawerLayout mDrawerlayout;
    private ProfilePictureView profile_pic;
    //private ImageView profile_pic1;
    //private Drawable drawable;
    //private Drawable [] drawables = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        //View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_navigation);

        //Intent intent = getIntent();
        //String userId = intent.getStringExtra(loginResult.getAccessToken().getUserId());
        //String pictureUrl = "https://graph.facebook.com/" + userId + "/picture?type=large";
        Profile  profile = Profile.getCurrentProfile();

        if (profile != null) {
            profile_pic = (ProfilePictureView) headerLayout.findViewById(R.id.profilePicture);
            profile_pic.setProfileId(profile.getId());
            ImageView imageView = ((ImageView)profile_pic.getChildAt(0));
//            String userID = loginResult.getAccessToken().getUserId();

            //Toast.makeText(LoginActivity.this, profile.getName(), Toast.LENGTH_SHORT).show();
            //pictureUri = profile.getProfilePictureUri(120, 120).toString();
            //String userID = profile.getId();
            String pictureUrl = "https://graph.facebook.com/" + profile.getId() + "/picture?type=large";

            Glide.with(NavigationActivity.this)
                    .load(pictureUrl)
                    .into(imageView);
            //profileName.setText(profile.getName());

            /*mDrawer.getMenu().findItem(R.id.nav_myAccount).setVisible(false);
            Bundle extra = getIntent().getExtras();
            String email;
            if (extra != null) {
                email = extra.getString("email");
                profileEmail.setText(email);
                Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            } else if (sessionManagerFacebook.isLoggedIn()) {
                profileEmail.setText(userFacebook.get(SessionManagerFacebook.KEY_EMAIL));
                Toast.makeText(MainActivity.this, userFacebook.get(SessionManagerFacebook.KEY_EMAIL), Toast.LENGTH_SHORT).show();

            }*/

        } else {
//            drawables = new Drawable[] {
//                    getResources().getDrawable(R.drawable.ic_menu_camera)
//            };
//            drawable = drawables[0];
//            profile_pic1 = (ImageView) findViewById(R.id.imageView);
//            profile_pic1.setImageDrawable(drawable);


        }


        //Profile profile = Profile.getCurrentProfile();
        //String userID = loginResult.getAccessToken().getUserId();
        //ProfilePictureView profilePicture = (ProfilePictureView) findViewById(R.id.profilePicture);
        //profilePicture.setProfileId(userID);
        /* make the API call */

    }

    /**
     * Function loads the users facebook profile pic
     *
     *
     */
    /*public Bitmap getUserPic(String userID) {
        String imageURL;
        Bitmap bitmap = null;
        //Log.d(TAG, "Loading Picture");
        imageURL = "http://graph.facebook.com/"+userID+"/picture?type=small";
        try {
            bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageURL).getContent());
        } catch (Exception e) {
            Log.d("TAG", "Loading Picture FAILED");
            e.printStackTrace();
        }
        return bitmap;
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {//home
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {//my doctors
            Intent i = new Intent(NavigationActivity.this, DoctorsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {//test results
            Intent i = new Intent(NavigationActivity.this, TestResultsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {//settings
            Intent i = new Intent(NavigationActivity.this, SettingsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {//medical history
            Intent i = new Intent(NavigationActivity.this, MedicalHistoryActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {//messages
            Intent i = new Intent(NavigationActivity.this, MessagesActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_logout) {//log out
            LoginManager.getInstance().logOut();
            Intent i = new Intent(NavigationActivity.this, LoginActivity.class);
            startActivity(i);
            //this.finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
