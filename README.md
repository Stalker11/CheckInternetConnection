# CheckInternetConnection
Module for checking connection device to internet.<br/> 
For using this module add in your gradle this code:
```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
 Add the dependency:
 ```
 dependencies {
	        compile 'com.github.Stalker11:CheckInternetConnection:r.r.r'
	}
  ```
  Where r.r.r last release version.<br/>
  For implement this module in your progect you have to implement interface **ICallBack** and create object **Checking()**:
  ```
  public class MainActivity extends AppCompatActivity implements ICallBack{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Checking(this);
    }

    @Override
    public void requestCallBack(boolean b, int i) {

    }
}
```
**int i** it is response code.
