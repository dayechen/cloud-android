package run.cfloat.cloud.pkg

import android.os.NetworkOnMainThreadException
import android.util.Log
import com.hierynomus.msdtyp.AccessMask
import com.hierynomus.mssmb2.SMB2CreateDisposition
import com.hierynomus.mssmb2.SMB2CreateOptions
import com.hierynomus.mssmb2.SMB2ShareAccess
import com.hierynomus.smbj.SMBClient
import com.hierynomus.smbj.auth.AuthenticationContext
import com.hierynomus.smbj.share.DiskShare
import java.io.File
import java.io.IOException


class Smb {
    private val client = SMBClient()
    fun login(
        serverName: String,
        shareName: String,
        userName: String,
        password: String,
        domain: String
    ) {
        try {
            val connection = client.connect(serverName)
            val ac = AuthenticationContext(userName, password.toCharArray(), domain)
            val session = connection.authenticate(ac)
            val share = session.connectShare(shareName) as DiskShare
            val file = share.openFile(
                "/smb_test/test001.txt",
                setOf(AccessMask.FILE_READ_DATA),
                null,
                SMB2ShareAccess.ALL,
                SMB2CreateDisposition.FILE_OPEN,
                setOf(SMB2CreateOptions.FILE_DIRECTORY_FILE)
            )
            for (item in share.list("/smb_test")) {
                Log.i("SMB", item.fileName)
            }
        } catch (e: IOException) {
            Log.i("SMB", "连接失败${e.localizedMessage}")
        } catch (e: NetworkOnMainThreadException) {
            Log.i("SMB", "连接失败${e.localizedMessage}")
        }
    }
}