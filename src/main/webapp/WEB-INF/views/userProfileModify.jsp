<%--
  Created by IntelliJ IDEA.
  User: chris.zhang
  Date: 16-6-27
  Time: 上午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<div class="page-header">
    <h2>修改个人档案</h2>
</div>
<div>
    <form class="pure-form" id="form" action="/user/${sessionScope.user.id}/modify" method="POST">

        <input id="uploadFile" name="avatar" placeholder="Choose File"  />
        <div class="fileUpload btn btn-primary">
            <span>Upload</span>
            <input id="uploadBtn" type="file" class="upload" />
        </div>
        <button type="submit">保存</button>
        <script>
            document.getElementById("uploadBtn").onchange = function () {
                //document.getElementById("uploadFile").value = this.value;
                var input = document.getElementById("uploadBtn");
                var fReader = new FileReader();
                fReader.readAsDataURL(input.files[0]);
                fReader.onloadend = function(event){
                    var img = document.getElementById("uploadFile");
                    img.value = event.target.result;
                    console.log(img.value)
                }
            };


        </script>
    </form>
</div>