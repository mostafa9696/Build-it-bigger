package com.udacity.gradle.testing;//import android.app.Application;

import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import com.example.GenerateJokes;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.MyAsyncTask;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;



@RunWith(AndroidJUnit4.class)
public class asyncTaskTest extends ApplicationTestCase{
    MainActivityFragment mainActivityFragment;
    GenerateJokes generateJokes;
    String MyString="",Ans=null;
    Exception wrong=null;
    CountDownLatch signal = null;
    public asyncTaskTest(Class applicationClass) {
        super(applicationClass);
    }
    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }
    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }
    public void testAlbumGetTask() throws InterruptedException {
        mainActivityFragment=new MainActivityFragment();
        generateJokes=new GenerateJokes();
        new MyAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                MyString = result;
                signal.countDown();
            }
        }.execute(mainActivityFragment);
        signal.await();
        assertEquals(MyString, generateJokes.GetJoke());
        assertNull(wrong);
        assertFalse(TextUtils.isEmpty(MyString));
    }

}