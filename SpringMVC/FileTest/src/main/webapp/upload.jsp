<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileupload</title>
</head>
<body>
    <h4>File Upload</h4>
    <form action="upload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Please select the uploaded file:</td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="upload"></td>
            </tr>
        </table>
    </form>
</body>
</html>