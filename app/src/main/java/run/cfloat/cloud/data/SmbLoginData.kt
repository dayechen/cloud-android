package run.cfloat.cloud.data

data class SmbLoginForm(
    val label: String,
    val value: String
)

data class SmbLoginData(
    var form: SmbLoginForm,
    val testName: String = "测试专用的名称"
)
