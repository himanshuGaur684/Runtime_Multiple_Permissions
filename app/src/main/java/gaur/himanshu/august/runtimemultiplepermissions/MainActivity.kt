package gaur.himanshu.august.runtimemultiplepermissions

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePermission()

    }

fun takePermission(){
    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
        ActivityCompat.requestPermissions(this,
        arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.CAMERA),0)
    }
}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode==0){
            val camera=grantResults[0]==PackageManager.PERMISSION_GRANTED
            val write=grantResults[1]==PackageManager.PERMISSION_GRANTED

            Toast.makeText(this,"Permission camera : $camera",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"Permission write external storage : $write",Toast.LENGTH_SHORT).show()

        }
    }


}